package services;

import model.Entities.User;
import org.apache.log4j.Logger;
import org.hibernate.*;

public class CheckLogin {
    private static Logger logger = Logger.getLogger(CheckLogin.class);

    public static User checkEmailAndPassword(String email, String password, SessionFactory sessionFactory) {
        logger.info(String.format("Checking: email:%s,password:%s", email, password));
        User user = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from User where email=:email AND password=:password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            user = (User) query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (user != null) {
            logger.info("Check completed successful");
        } else {
            logger.info("Wrong user");
        }
        return user;
    }
}
