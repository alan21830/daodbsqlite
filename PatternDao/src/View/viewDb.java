package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.DAOFactory;
import Database.DatabaseTicket;
import Database.Factory.DAOAbstractFactory;
import Model.Ticket.Ticket;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class viewDb extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewDb frame = new viewDb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */


	public viewDb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(57, 72, 500, 500);
		contentPane.add(textArea);
		JButton btnView = new JButton("View");




		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				/* Esempio con JDBC SQLite... */
				
				DAOFactory myDAOFactorySQLite = DAOAbstractFactory.getDAOFactory(DAOAbstractFactory.SQLITE);
				DatabaseTicket myTicketDAOSQLite = myDAOFactorySQLite.getTicketDAO();

				List<Ticket> list1 = myTicketDAOSQLite.GetAll();

				textArea.setText(textArea.getText() + "FROM JDBC SQLite\n\n");
				if(list1.isEmpty())
					textArea.setText(textArea.getText() + "vuota");

				for (Ticket obj : list1) 				
					textArea.setText(textArea.getText() + "\n" + obj.toString());								
				
				/* Esempio con HIBERNATE... */

				DAOFactory myDAOFactoryHibernate = DAOAbstractFactory.getDAOFactory(DAOAbstractFactory.SQLITE);
				DatabaseTicket myTicketDAOHibernate = myDAOFactoryHibernate.getTicketDAO();

				List<Ticket> list2 = myTicketDAOHibernate.GetAll();

				textArea.setText(textArea.getText() + "\n\nFROM HIBERNATE\n\n");
				if(list2.isEmpty())
					textArea.setText("vuota");

				for (Ticket obj : list2) 				
					textArea.setText(textArea.getText() + "\n" + obj.toString());	


			}
		});
		
		
		btnView.setBounds(35, 31, 117, 29);
		contentPane.add(btnView);

		

	}
}
