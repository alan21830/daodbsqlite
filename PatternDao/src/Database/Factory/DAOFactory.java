package Database.Factory;

import Database.TicketDAO;

public interface DAOFactory {
	public TicketDAO getTicketDAO();
}
