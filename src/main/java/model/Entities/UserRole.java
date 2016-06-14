package model.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type User role.
 */
@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private int userRoleId;

    private String userRoleName;

    @Override
    public String toString() {
        return "" + userRoleName;
    }

    /**
     * Instantiates a new User role.
     */
    public UserRole() {
    }

    /**
     * Gets user role id.
     *
     * @return the user role id
     */
    public int getUserRoleId() {
        return userRoleId;
    }

    /**
     * Sets user role id.
     *
     * @param userRoleId the user role id
     */
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * Gets user role name.
     *
     * @return the user role name
     */
    public String getUserRoleName() {
        return userRoleName;
    }

    /**
     * Sets user role name.
     *
     * @param userRoleName the user role name
     */
    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }
}
