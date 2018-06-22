package Database;

import java.util.List;
import Model.Ticket.Ticket;

public interface TicketDao {
	List<Ticket> GetAll();
	void InsertTicket(Ticket obj);
}
