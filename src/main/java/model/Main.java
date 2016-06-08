package model;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.hibernate.HibernateUtil;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        DOMConfigurator.configure("src/Main/resources/log4j.xml");
        SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
//        Wagon wagon = new Wagon();
//        City city = new City();
//
//        wagon.setCurrentCity(city);
//        wagon.setDriversChange(2);
//        wagon.setLicensePlate("12221");
//        wagon.setDriverStatus(Wagon.WagonStatus.BROKEN);
//        wagon.setVolume(1);
//        wagon.setWeight(1);
//
//        currentSession.save(city);
//        currentSession.save(wagon);
//        Wagon wagon = (Wagon) currentSession.get(Wagon.class, 1);
//        System.out.println(wagon);
        transaction.commit();
//        currentSession.close();
//        logger.info("CLOSED");


    }
}
