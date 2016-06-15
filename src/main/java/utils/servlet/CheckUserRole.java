package utils.servlet;

import model.Entities.User;
import org.apache.log4j.Logger;

public class CheckUserRole {
    private static Logger logger = Logger.getLogger(CheckUserRole.class);

    public static String getUserRole(User user) {
        logger.info("Checking user role:" + user.getEmail());
        String role = "public";
        if (user != null) {
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
