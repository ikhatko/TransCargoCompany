package controller.Servlet.Listners;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import utils.hibernate.CustomNamingStrategy;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * The type Hibernate session factory listner.
 */
public class HibernateSessionFactoryListner implements ServletContextListener{

    private static Logger logger = Logger.getLogger(HibernateSessionFactoryListner.class);

    public void contextInitialized(ServletContextEvent sce) {
        Configuration configuration = new Configuration();
        configuration.setNamingStrategy(CustomNamingStrategy.INSTANCE);
        configuration.configure("hibernate.cfg.xml");
        logger.info("Hibernate Configuration created successfully");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        logger.info("ServiceRegistry created successfully");

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        logger.info("SessionFactory created successfully");

        sce.getServletContext().setAttribute("SessionFactory", sessionFactory);
        logger.info("Hibernate SessionFactory Configured successfully");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        SessionFactory sessionFactory = (SessionFactory) sce.getServletContext().getAttribute("SessionFactory");
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            logger.info("Closing Hibernate SessionFactory");
            sessionFactory.close();
        }
        logger.info("Hibernate sessionFactory closed");
    }
}
