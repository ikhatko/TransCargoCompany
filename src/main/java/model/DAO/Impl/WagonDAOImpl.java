package model.DAO.Impl;

import model.DAO.Interfaces.WagonDAO;
import model.Entities.Wagon;
import org.hibernate.Session;

public class WagonDAOImpl extends GenericDAOImpl  implements WagonDAO {

    public WagonDAOImpl(Session session) {
        super(Wagon.class, session);
    }
}
