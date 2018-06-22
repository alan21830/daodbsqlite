package Database.SQL_Lite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import Database.TicketDao;
import Model.Ticket.Ticket;

public class SqlLiteTicket  implements TicketDao {

	@Override
	public List<Ticket> GetAll() {

		System.out.print("fdsfdsgdfg");
		
		Connection connection = null;
		List<Ticket> output = new Vector<Ticket>();

		try {
			SqlLiteFactory  sqlitefactory = new SqlLiteFactory();
			connection = sqlitefactory.GetConnection();

			if (connection == null)
				System.out.print("vvvv");
			System.out.print("\nconn ok");

			
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
				
				output.add(obj);
			}

		}catch(SQLException e){  System.err.println(e.getMessage()); }       
		finally {         
			try {
				if(connection != null)
					connection.close();
				
			}
			catch(SQLException e) {  // Use SQLException class instead.          
				System.err.println(e); 
			}
		}

		return output;


	}

	@Override
	public void InsertTicket(Ticket obj) {
		// TODO Auto-generated method stub

	}



}
