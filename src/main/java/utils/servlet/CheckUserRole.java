package utils.servlet;

import model.Entities.User;
import org.apache.log4j.Logger;

/**
 * The type Check user role.
 */
public class CheckUserRole {
    private static Logger logger = Logger.getLogger(CheckUserRole.class);

    /**
     * Gets user role.
     *
     * @param user the user
     * @return the user role
     */
    public static String getUserRole(User user) {
        String role = "public";
        if (user != null) {
            logger.info("Checking user role:" + user.getEmail());
            int userRoleId = user.getUserRole().getUserRoleId();
            if (userRoleId == 1) {
                role = "admin";
            } else if (userRoleId == 2) {
                role = "staff";
            } else if (userRoleId == 3) {
                role = "driver";
            } else if (userRoleId == 4) {
                role = "public";
            }
        }
        logger.info("User role:" + role);
        return role;
    }
}
