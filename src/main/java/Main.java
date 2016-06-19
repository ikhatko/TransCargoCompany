import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;

public class Main {
    public static void main(String[] args) throws Exception {
        GeoApiContext context = new GeoApiContext();
        context.setApiKey("AIzaSyDIkAgFpUkSMtaQMqI3yOaA4dYh4PFlL2A");
        DirectionsResult result = DirectionsApi.newRequest(context)
                .origin("Saint Petersburg")
                .destination("Saint Petersburg")
                .optimizeWaypoints(true)
                .waypoints("Moscow", "Minsk", "Novgorod", "Soligorsk")
                .await();
        for (int i : result.routes[0].waypointOrder) {
            System.out.println(i);
        }

    }
}