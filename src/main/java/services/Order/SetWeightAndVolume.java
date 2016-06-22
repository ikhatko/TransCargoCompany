package services.Order;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import model.DAO.Impl.OrderDAOImpl;
import model.Entities.CargoStatus;
import model.Entities.Order;
import model.Entities.Waypoint;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.*;


/**
 * This class is using Google API to make route.
 */
public class SetWeightAndVolume {

    private static final String API_KEY = "AIzaSyDIkAgFpUkSMtaQMqI3yOaA4dYh4PFlL2A";
    /**
     * The constant METERS_TO_KM using to set meters to kilometers.
     */
    public static final int METERS_TO_KM = 1000;
    /**
     * The constant SEC_TO_HOURS using to set seconds to hours.
     */
    public static final int SEC_TO_HOURS = 3600;
    /**
     * The constant COEFFICIENT using for route duration.
     */
    public static final float COEFFICIENT = 1.1f;
    /**
     * The constant SAINT_PETERSBURG using for make route origin and destionation.
     */
    public static final String SAINT_PETERSBURG = "Saint Petersburg";

    private float maxWeight;
    private float maxVolume;
    private float currentWeight;
    private float currentVolume;
    private float distance;
    private float duration;

    private Logger logger = Logger.getLogger(SetWeightAndVolume.class);
    private DirectionsResult directionsResult;
    private List<Waypoint> trueWaypointOrder;

    /**
     * Sets max weight and max volume to Order using route, created by Directions API.
     *
     * @param orderId        the order id
     * @param sessionFactory the session factory
     */
    public void setMaxWeightAndVolume(String orderId, SessionFactory sessionFactory) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderDAOImpl orderDAO = new OrderDAOImpl(session);
            Transaction transaction = session.beginTransaction();
            Order order = (Order) orderDAO.read(Integer.parseInt(orderId));

            List<Waypoint> orderWaypoints = GetOrderWaypoints.getOrderWaypoints(orderId, sessionFactory);
            String[] waypointsCities = getWaypointsCities(orderWaypoints);
            String[] strings = removeDuplicateCities(waypointsCities);
            String[] trueOrder = getTrueOrder(strings);
            trueWaypointOrder = getTrueWaypointsOrder(trueOrder, orderWaypoints);

            order.setWaypointList(trueWaypointOrder);
            order.setMaxVolume(maxVolume);
            order.setMaxWeight(maxWeight);
            order.setRouteDistance(distance / METERS_TO_KM);
            order.setRouteDuration(duration * COEFFICIENT / SEC_TO_HOURS);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Getting cities names from current order waypoints.
     *
     * @param cargoesWaypoints list of order waypoints.
     * @return String array with cities names.
     */
    private String[] getWaypointsCities(List<Waypoint> cargoesWaypoints) {
        String[] result = new String[cargoesWaypoints.size()];
        for (int i = 0; i < cargoesWaypoints.size(); i++) {
            result[i] = cargoesWaypoints.get(i).getWaypointCity().getCityName();
        }
        return result;
    }

    /**
     * Remove duplicates cities from array.
     *
     * @param citiesName array with cities names
     * @return array that doesn't contains duplicated cities names
     */
    private String[] removeDuplicateCities(String[] citiesName) {
        Set<String> citiesNames = new HashSet<>(Arrays.asList(citiesName));
        String[] strings = citiesNames.toArray(new String[citiesNames.size()]);
        return strings;
    }

    /**
     * Getting the real order of the cities, distance and duration of the route.
     * Using Directions API and API_KEY to send request and getting Direction Result object.
     * @param citiesName array with cities names
     * @return an array containing the correct order of cities
     */
    private String[] getTrueOrder(String[] citiesName) {
        String[] trueOrder = new String[citiesName.length + 1];
        GeoApiContext context = new GeoApiContext();
        context.setApiKey(API_KEY);
        try {
            directionsResult = DirectionsApi.newRequest(context)
                    .origin(SAINT_PETERSBURG)
                    .destination(SAINT_PETERSBURG)
                    .optimizeWaypoints(true)
                    .waypoints(citiesName)
                    .await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (DirectionsLeg leg : directionsResult.routes[0].legs) {
            distance += leg.distance.inMeters;
            duration += leg.duration.inSeconds;
        }
        int[] waypointOrder = directionsResult.routes[0].waypointOrder;
        trueOrder[0] = directionsResult.routes[0].legs[0].startAddress;

        for (int i = 1; i < waypointOrder.length; i++) {
            trueOrder[i] = citiesName[waypointOrder[i]];
        }
        return trueOrder;
    }

    /**
     * @param trueOrder        array with the true cities order
     * @param cargoesWaypoints list of the cargoes waypoints
     * @return list that contains true order of waypoints
     */
    private List<Waypoint> getTrueWaypointsOrder(String[] trueOrder, List<Waypoint> cargoesWaypoints) {
        List<Waypoint> result = new ArrayList<>();
        for (int i = 0; i < trueOrder.length; i++) {
            String cityName = trueOrder[i];
            for (Iterator<Waypoint> iterator = cargoesWaypoints.iterator(); iterator.hasNext(); ) {
                Waypoint waypoint = iterator.next();
                if (waypoint.getWaypointType().getWaypointStatusName().equals("Unloading")
                        && waypoint.getWaypointCargo().getCargoStatus().getStatusName().equals("Shipped")
                        && waypoint.getWaypointCity().getCityName().equals(cityName)) {
                    currentWeight -= waypoint.getWaypointCargo().getWeight();
                    currentVolume -= waypoint.getWaypointCargo().getVolume();
                    checkMaxWeightAndVolume(currentWeight, currentVolume);
                    result.add(waypoint);
                    iterator.remove();
                    continue;
                }

                if (waypoint.getWaypointType().getWaypointStatusName().equals("Loading")
                        && waypoint.getWaypointCargo().getCargoStatus().getStatusName().equals("Ready")
                        && waypoint.getWaypointCity().getCityName().equals(cityName)) {
                    CargoStatus cargoStatus = new CargoStatus();
                    cargoStatus.setStatusName("Shipped");
                    waypoint.getWaypointCargo().setCargoStatus(cargoStatus);
                    currentWeight += waypoint.getWaypointCargo().getWeight();
                    currentVolume += waypoint.getWaypointCargo().getVolume();
                    checkMaxWeightAndVolume(currentWeight, currentVolume);
                    result.add(waypoint);
                    iterator.remove();
                    continue;
                }
            }
        }

        for (int i = trueOrder.length - 1; i >= 0; i--) {
            String cityName = trueOrder[i];
            for (Iterator<Waypoint> iterator = cargoesWaypoints.iterator(); iterator.hasNext(); ) {
                Waypoint waypoint = iterator.next();
                if (waypoint.getWaypointType().getWaypointStatusName().equals("Unloading")
                        && waypoint.getWaypointCargo().getCargoStatus().getStatusName().equals("Shipped")
                        && waypoint.getWaypointCity().getCityName().equals(cityName)) {
                    currentWeight -= waypoint.getWaypointCargo().getWeight();
                    currentVolume -= waypoint.getWaypointCargo().getVolume();
                    checkMaxWeightAndVolume(currentWeight, currentVolume);
                    result.add(waypoint);
                    iterator.remove();
                }
            }
        }
        for (Waypoint waypoint : result) {
            System.out.println(waypoint.getWaypointCity() + " " + waypoint.getWaypointType() + " " + waypoint.getWaypointCargo().getName());
        }
        return result;
    }

    /**
     * Checking weight and volume.
     * Setting it to variables maxWeight and maxVolume if state is true.
     * @param weight current weight
     * @param volume current volume
     */
    private void checkMaxWeightAndVolume(float weight, float volume) {
        if (weight > maxWeight) {
            maxWeight = weight;
        }
        if (volume > maxVolume) {
            maxVolume = volume;
        }
    }

    /**
     * Gets true waypoint order.
     *
     * @return the true waypoint order
     */
    public List<Waypoint> getTrueWaypointOrder() {
        return trueWaypointOrder;
    }
}
