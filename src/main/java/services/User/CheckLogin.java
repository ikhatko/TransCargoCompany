package services.User;

import model.DAO.Impl.UserDAOImpl;
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
            user = new UserDAOImpl(session).checkUser(email, password, session);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (user != null) {
            logger.info("Checking email completed successfully");
        } else {
            logger.info("Wrong user");
        }
        return user;
    }
}
