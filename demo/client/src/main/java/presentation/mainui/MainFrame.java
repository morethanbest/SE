package presentation.mainui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import po.Job;
import presentation.managerui.ManagerPanel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout card;
	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		card = new CardLayout(0, 0);
		contentPane.setLayout(card);
		LoginPanel login = new LoginPanel(this);
		contentPane.add(login, "login");
	
	}

	public void skipToNext(Job job) {
		if (job == Job.manager) {
			JPanel temp = new ManagerPanel();
			contentPane.add(temp, "manager");
			card.show(contentPane, "manager");
		} else if (job == Job.visitor) {
			System.out.println("Login failed!!!");
		}
	}


}
