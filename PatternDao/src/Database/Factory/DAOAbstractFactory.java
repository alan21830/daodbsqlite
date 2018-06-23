package Database.Factory;

import java.text.MessageFormat;

import Database.DAOFactory;

public abstract class DAOAbstractFactory {

	public static final String SQLITE = "SQLite";
	public static final String HIBERNATE = "Hibernate";

    /**
     * This function is used to get a concrete DAO factory.
     *
     * @param arg0 Name of requested factory type.
     * @return A {@code DAOFactory} object.
     */
    public static DAOFactory getDAOFactory(String arg0) {

        // Building concrete factory's name...
        String nameDAOFactory = MessageFormat.format("{0}.DAOFactory{1}", DAOAbstractFactory.class.getPackage().getName(), arg0);

        // Building a new concrete factory's instance...
        try {
            return (DAOFactory) Class.forName(nameDAOFactory).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
}
