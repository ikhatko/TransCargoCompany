package services.User;

import model.DAO.Impl.UserDAOImpl;
import model.Entities.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddNewUser {

    private static Logger logger = Logger.getLogger(AddNewUser.class);

    public static boolean addNewUser(String firstName, String lastName, String email, String password, int userRoleId, SessionFactory sessionFactory) {
        boolean result = false;
        Session session = null;
        User user = null;
        logger.info(String.format("Adding new user: %s, %s", firstName, lastName));
        try {
            session = sessionFactory.openSession();
            UserDAOImpl userDAO = new UserDAOImpl(session);
            user = new User(firstName, lastName, email, password, userRoleId);
            Transaction transaction = session.beginTransaction();
            userDAO.create(user);
            transaction.commit();
            result = true;
            logger.info("New user added successfully");
        } catch (Throwable e) {
            logger.info("New user doesn't added");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
