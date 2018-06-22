package Database.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Database.TicketDAO;
import Database.Factory.SQLite.SQLiteCallableOperation;
import Database.Factory.SQLite.SQLiteTicket;

/**
 * This class represents a factory used to get all concrete classes which manage all SQLite tables.
 * Furthermore it is used to perform operation on database.
 * 
 * @author Andrea Graziani
 * @version 1.0
 */
public class SQLiteDAOFactory implements DAOFactory {

	private static final String ConnectionString = "jdbc:sqlite:C:\\Users\\Andrea Graziani\\Documents\\GitHub\\daodbsqlite\\PatternDao\\Database\\Database.db";
	private static final String ClassPath = "org.sqlite.JDBC";

	/**
	 * This method is used to perform a specified operation described by a {@code SQLiteCallableOperation} object.
	 * 
	 * @param operation
	 *            - Represents a {@code SQLiteCallableOperation} object
	 * @return An object.
	 */
	public static Object performOperation(SQLiteCallableOperation operation) {

		/* Output... */
		Object output;
		/* Connection... */
		Connection connection = null;

		try {

			/* Establish connection */
			Class.forName(ClassPath);		
			connection = DriverManager.getConnection(ConnectionString);

			/* Setting up "Connection" object for "SQLiteCallableOperation" object... */
			operation.setMyConnection(connection);

			/* Perform operation... */
			output = operation.call();

		} catch (Exception myException) {

			/* Print the exception */
			myException.printStackTrace();

			/* Return null in case of failure */
			return null;

		} finally {
			/* Close the session */
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return output;
	}


	@Override
	public TicketDAO getTicketDAO() {		
		return new SQLiteTicket();
	}
}
