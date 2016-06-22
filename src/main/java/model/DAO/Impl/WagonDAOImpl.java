package model.DAO.Impl;

import model.DAO.Interfaces.WagonDAO;
import model.Entities.Wagon;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * The type Wagon dao.
 */
public class WagonDAOImpl extends GenericDAOImpl implements WagonDAO {

    private Session session;

    /**
     * Instantiates a new Wagon dao.
     *
     * @param session the session
     */
    public WagonDAOImpl(Session session) {
        super(Wagon.class, session);
        this.session = session;
    }


    @Override
    public List<Wagon> getAllReadyWagons() {
        List list = null;
        Query query = session.createQuery("from Wagon where wagonStatus = 1");
        list = query.list();
        return list;
    }
}
