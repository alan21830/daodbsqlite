package Model.Ticket;

public class Ticket {
	private int id;
	private String Description;
	private long date;
	
	
	
	public String toString() {
		
		return String.format("ID TICKET {0}, \nDESCRIZIONE {1}\nDATE {2}", this.id, this.Description, this.date);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	
	
	
	
	
	
	
}
