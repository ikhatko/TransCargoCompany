package model.DAO.Impl;

import model.DAO.Interfaces.CityDAO;
import model.Entities.City;
import org.hibernate.Session;

public class CityDAOImpl extends GenericDAOImpl  implements CityDAO {

    public CityDAOImpl(Session session) {
        super(City.class, session);
    }
}
