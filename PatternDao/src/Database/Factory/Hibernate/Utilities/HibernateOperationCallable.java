package Database.Factory.Hibernate.Utilities;

import java.util.concurrent.Callable;

import org.hibernate.Session;

public abstract class HibernateOperationCallable implements Callable<Object> {

	protected Session session;

	public void setSession(Session session) {
		this.session = session;
	}
}
