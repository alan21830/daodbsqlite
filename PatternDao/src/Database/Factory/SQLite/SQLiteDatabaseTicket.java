package Database.Factory.SQLite;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import Database.DatabaseTicket;
import Database.Factory.DAOFactorySQLite;
import Database.Factory.SQLite.Utilities.SQLiteCallableOperation;
import Model.Ticket.Ticket;

public class SQLiteDatabaseTicket implements DatabaseTicket {

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> GetAll() {

		SQLiteCallableOperation operation = new SQLiteCallableOperation() {

			@Override
			public Object call() throws Exception {

				List<Ticket> output = new Vector<Ticket>();		
				Statement statement = this.myConnection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from Ticket");

				while(resultSet.next())
				{				
					Ticket obj = new Ticket();

					obj.setDescription(resultSet.getString("Description"));
					obj.setId(resultSet.getInt("id"));
					obj.setDate(resultSet.getInt("Date"));

					output.add(obj);
				}

				return output;
			}
		};
		return (List<Ticket>) DAOFactorySQLite.performOperation(operation);
	}

	
	
	@Override
	public void InsertTicket(Ticket obj) {
		// TODO InsertTicket
	}
}
