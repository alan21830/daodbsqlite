package Database.SQL_Lite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DaoFactory;
import Database.TicketDao;
import Model.Ticket.Ticket;

public class SqlLiteFactory extends DaoFactory {

	public static final String ConnectionString = "jdbc:sqlite:/Users/macmac/Desktop/patterndao";
	public static final String ClassPath = "org.sqlite.JDBC";


	public Connection GetConnection() {

		Connection connection = null;
		try
		{
			Class.forName(ClassPath);
			// create a database connection
			connection = DriverManager.getConnection(ConnectionString);
			

			
			
		}
		catch(SQLException e)
		{ System.err.println(e.getMessage()); 
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return connection;

	}
	
	


	protected TicketDao getTicketDao() {
		return new SqlLiteTicket();
	}





}
