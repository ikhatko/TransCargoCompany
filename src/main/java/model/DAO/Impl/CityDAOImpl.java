package model.DAO.Impl;

import model.DAO.Interfaces.CityDAO;
import model.Entities.City;
import org.hibernate.Session;

/**
 * The type City dao.
 */
public class CityDAOImpl extends GenericDAOImpl  implements CityDAO {

    /**
     * Instantiates a new City dao.
     *
     * @param session the session
     */
    public CityDAOImpl(Session session) {
        super(City.class, session);
    }
}
