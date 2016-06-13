package services.User;

import model.DAO.Impl.UserDAOImpl;
import model.Entities.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateUser {

    private static Logger logger = Logger.getLogger(UpdateUser.class);

    public static void updateUser(int id, String firstName, String lastName, String email, String password, String userRoleId, SessionFactory sessionFactory) {
        logger.info("Trying to update User with id:" + id);
        Session session = null;

        try {
            session = sessionFactory.openSession();
            UserDAOImpl userDAO = new UserDAOImpl(session);
            User user = (User) userDAO.read(id);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setEmail(email);
            if (userRoleId != null) {
                UserRole userRole = new UserRole();
                userRole.setUserRoleId(Integer.parseInt(userRoleId));
                user.setUserRole(userRole);
            }
            Transaction transaction = session.beginTransaction();
            transaction.commit();

            logger.info("User with id:" + id + " updated successfully");

        } catch (HibernateException e) {
            logger.info("User with id:" + id + " doesn't updated");
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
