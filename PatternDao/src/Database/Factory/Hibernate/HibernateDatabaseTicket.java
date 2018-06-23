package Database.Factory.Hibernate;

import java.util.List;
import Database.DatabaseTicket;
import Database.Factory.DAOFactoryHibernate;
import Model.Ticket.Ticket;


public class HibernateDatabaseTicket implements DatabaseTicket {

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> GetAll() {
		return (List<Ticket>) DAOFactoryHibernate.performQuery("SELECT * FROM Ticket");
	}

	@Override
	public void InsertTicket(Ticket obj) {
		// TODO Auto-generated method stub
		
	}
}
