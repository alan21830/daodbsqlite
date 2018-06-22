package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Database.TicketDAO;
import Database.Factory.DAOAbstractFactory;
import Database.Factory.DAOFactory;
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
		textArea.setBounds(57, 72, 311, 186);
		contentPane.add(textArea);
		JButton btnView = new JButton("View");




		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DAOFactory myDAOFactory = DAOAbstractFactory.getDAOFactory(DAOAbstractFactory.SQLITE);
				TicketDAO myTicketDAO = myDAOFactory.getTicketDAO();



				List<Ticket> list = myTicketDAO.GetAll();

				if(list.isEmpty())
					textArea.setText("vuota");

				for (Ticket obj : list) {
					
					textArea.setText(textArea.getText() + "\n" + obj.toString());
					
					
				}





			}
		});
		btnView.setBounds(35, 31, 117, 29);
		contentPane.add(btnView);

		JList list = new JList();
		list.setBounds(77, 123, 1, 1);
		contentPane.add(list);



		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(63, 81, 15, 96);
		contentPane.add(scrollBar);


	}
}
