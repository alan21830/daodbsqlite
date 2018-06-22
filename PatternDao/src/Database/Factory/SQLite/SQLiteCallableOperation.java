package Database.Factory.SQLite;

import java.sql.Connection;
import java.util.concurrent.Callable;

public abstract class SQLiteCallableOperation implements Callable<Object> {

	protected Connection myConnection;

	public Connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(Connection myConnection) {
		this.myConnection = myConnection;
	}	
}