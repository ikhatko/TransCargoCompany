package utils.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * The type Hibernate util.
 */
public class HibernateUtil {
    private SessionFactory sessionFactory = null;

    private void buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setNamingStrategy(CustomNamingStrategy.INSTANCE).configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Gets session factory.
     *
     * @return the session factory
     */
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory;
    }
}
