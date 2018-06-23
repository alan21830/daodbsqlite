package Database;

import java.util.List;
import Model.Ticket.Ticket;

/**
 * This interface is used to manage {@code Ticket} objects stored into database.
 * 
 * @author Andrea Graziani
 * @version 0.1
 */
public interface DatabaseTicket {

	/**
	 * This method is used to get all {@code Ticket} objects stored into database.
	 * 
	 * @return A {@code List} of {@code Ticket} objects.
	 */
	List<Ticket> GetAll();

	/**
	 * This method is used to insert a {@code Ticket} object.
	 * 
	 * @param obj - Represents a {@code Ticket} object.
	 */
	void InsertTicket(Ticket obj);
}
