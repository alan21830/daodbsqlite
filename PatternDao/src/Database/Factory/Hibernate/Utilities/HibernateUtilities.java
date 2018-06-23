package Database.Factory.Hibernate.Utilities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import Model.Ticket.Ticket;

import java.util.Properties;

public class HibernateUtilities {

    // 'SessionFactory' instance...
    private final SessionFactory SESSION_FACTORY;

    /**
     * Constructs a newly allocated {@code HibernateController} object.
     */
    private HibernateUtilities() {

        // Create a Configuration object.
        Configuration config = new Configuration();

        // Configure using the application resource named hibernate.cfg.xml.
        config.configure();

        // Extract the properties from the configuration file.
        Properties prop = config.getProperties();

        // Create StandardServiceRegistryBuilder using the properties.
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(prop);

        // Build a ServiceRegistry
        ServiceRegistry registry = builder.build();

        // Mapping tables
        config.addAnnotatedClass(Ticket.class);


        // Create the SessionFactory using the ServiceRegistry
        SESSION_FACTORY = config.buildSessionFactory(registry);
    }

    /**
     * This function is used to get an {@code HibernateController} object.
     *
     * @return A {@code HibernateController} object.
     */
    public static HibernateUtilities getInstance() {
        return HibernateUtilitiesLazyHolder.INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public void closeSessionFactory() {
        SESSION_FACTORY.close();
    }

    /**
     * Following class is used according to 'initialization-on-demand holder' pattern.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom">Initialization-on-demand holder idiom</a>
     */
    private static class HibernateUtilitiesLazyHolder {
        static final HibernateUtilities INSTANCE = new HibernateUtilities();
    }
}
