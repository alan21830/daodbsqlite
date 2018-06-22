package Model.Ticket;

import java.text.MessageFormat;

public class Ticket {
	private int id;
	private String Description;
	private long date;
	
	
	
	public String toString() {
		
		return MessageFormat.format("ID Ticket: {0}\n Description: {1}\n Date {2}", this.id, this.Description, this.date);
		
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
