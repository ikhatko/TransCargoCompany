package model.DAO.Impl;

import model.DAO.Interfaces.CityDAO;
import org.hibernate.Session;

public class CityDAOImpl extends GenericDAOImpl  implements CityDAO {

    public CityDAOImpl(Class entityType, Session session) {
        super(entityType, session);
    }
}
