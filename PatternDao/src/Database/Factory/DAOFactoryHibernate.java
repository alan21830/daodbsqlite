package Database.Factory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Database.DAOFactory;
import Database.DatabaseTicket;
import Database.Factory.Hibernate.Utilities.HibernateOperationCallable;
import Database.Factory.Hibernate.Utilities.HibernateUtilities;

import java.util.List;

public class DAOFactoryHibernate implements DAOFactory {

	/**
	 * This method is used to save an object into database.
	 * 
	 * @param obj
	 *            - Represents an object.
	 * @return An {@code object}.
	 */
	public static Object save(Object obj) {

		// Generating operation...
		HibernateOperationCallable operation = new HibernateOperationCallable() {

			@Override
			public Object call() throws Exception {
				return this.session.save(obj);
			}
		};
		return performOperation(operation);
	}

	/**
	 * This method is used to delete an object stored into database.
	 * 
	 * @param obj
	 *            - Represents an object.
	 */
	public static void delete(Object obj) {

		// Generating operation...
		HibernateOperationCallable operation = new HibernateOperationCallable() {

			@Override
			public Object call() throws Exception {
				this.session.delete(obj);
				return null;
			}
		};
		performOperation(operation);
	}

	/**
	 * This method is used to update an object stored into database.
	 * 
	 * @param obj
	 *            - Represents an object.
	 */
	public static void update(Object obj) {

		// Generating operation...
		HibernateOperationCallable operation = new HibernateOperationCallable() {

			@Override
			public Object call() throws Exception {
				this.session.update(obj);
				return null;
			}
		};
		performOperation(operation);
	}

	/**
	 * This method is used to perform a query.
	 * 
	 * @param queryStr
	 *            - Represents a {@code String} object.
	 * @return A {@code List<?>} object.
	 */
	public static List<?> performQuery(String queryStr) {

		// Generating operation...
		HibernateOperationCallable operation = new HibernateOperationCallable() {

			@Override
			public Object call() throws Exception {
				return session.createQuery(queryStr).list();
			}
		};
		return (List<?>) performOperation(operation);

	}

	/**
	 * This method is used to perform a query. It returns a single instance that
	 * matches the query, or null if the query returns no results.
	 * 
	 * @param queryStr
	 *            - Represents a {@code String} object.
	 * @return An object.
	 */
	public static Object performQueryUniqueResult(String queryStr) {

		// Generating operation...
		HibernateOperationCallable operation = new HibernateOperationCallable() {

			@Override
			public Object call() throws Exception {
				return session.createQuery(queryStr).uniqueResult();
			}
		};
		return performOperation(operation);
	}

	/**
	 * This method is used to perform a query that return a pageable collection of
	 * items.
	 * 
	 * @param queryStr
	 *            - Represents a {@code String} object
	 * @param pageSize
	 *            - Page size.
	 * @param pageNumber
	 *            - Page number.
	 * @return A {@code List<?>} object.
	 */
	public static List<?> performQueryPageableCollections(String queryStr, int pageSize, int pageNumber) {

		// Generating operation...
		HibernateOperationCallable operation = new HibernateOperationCallable() {

			@Override
			public Object call() throws Exception {

				// Create "Query" object and setting it up...
				Query queryObj = this.session.createQuery(queryStr);
				queryObj.setMaxResults(pageSize);
				queryObj.setFirstResult(pageSize * pageNumber);

				// Return data
				return queryObj.list();
			}
		};
		return (List<?>) performOperation(operation);

	}

	/**
	 * This method is used to perform a given operation.
	 * 
	 * @param operation
	 *            - Represents a {@code HibernateOperationCallable} object
	 * @return AN object
	 */
	private static Object performOperation(HibernateOperationCallable operation) {

		// Output...
		Object output;
		// Hibernate session...
		Session mySession = HibernateUtilities.getInstance().getSessionFactory().openSession();
		// Hibernate transaction...
		Transaction myTransaction = null;

		try {

			// Begin a transaction..
			myTransaction = mySession.beginTransaction();

			// Setting up "Session" object for "HibernateOperationCallable" object...
			operation.setSession(mySession);

			// Perform operation...
			output = operation.call();

			// Commit transaction...
			myTransaction.commit();

		} catch (Exception myException) {

			// If there are any exceptions, roll back the changes
			if (myTransaction != null)
				myTransaction.rollback();

			// Print the exception
			myException.printStackTrace();

			// Failure
			return null;

		} finally {
			// Close the session
			mySession.close();
		}

		return output;
	}

	@Override
	public DatabaseTicket getTicketDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
