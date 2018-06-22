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
			
			Statement statement = connection.createStatement();
			System.out.print("\nstatment ok");
			statement.setQueryTimeout(30);
			ResultSet resultSet = statement.executeQuery("select * from Ticket");

			System.out.print("\nresuslt set ok");
			
			while(resultSet.next())
			{
				System.out.println("Fetching...");
				
				Ticket obj = new Ticket();

				obj.setDescription(resultSet.getString("Description"));
				obj.setId(resultSet.getInt("id"));
				obj.setDate(resultSet.getInt("Data"));

				System.out.println(obj.toString());
				
			}
			
			
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
