package model.DAO.Impl;

import model.DAO.Interfaces.WagonDAO;
import model.Entities.Wagon;
import org.hibernate.Session;

/**
 * The type Wagon dao.
 */
public class WagonDAOImpl extends GenericDAOImpl  implements WagonDAO {

    /**
     * Instantiates a new Wagon dao.
     *
     * @param session the session
     */
    public WagonDAOImpl(Session session) {
        super(Wagon.class, session);
    }
}
