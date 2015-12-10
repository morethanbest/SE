package presentation.mainui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import po.Job;
import presentation.Financial.FinancialPanel;
import presentation.administratorui.AdministratorPanel;
import presentation.centersalesmanui.CenterSalesmanPanel;
import presentation.courierui.CourierPanel;
import presentation.depotui.DepotPanel;
import presentation.hallsalesmanui.HallsalesmanPanel;
import presentation.managerui.ManagerPanel;
import presentation.searchorder.Searchorder;
import vo.LoginVO;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout card;
	private Searchorder searchorder;
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
		searchorder=new Searchorder();
		contentPane.add(searchorder, "searchorder");
	
	}

	public void skipToNext(LoginVO vo) {
		if (vo.getJob() == Job.manager) {
			JPanel temp = new ManagerPanel();
			contentPane.add(temp, "manager");
			card.show(contentPane, "manager");
		} else if (vo.getJob() == Job.Courier) {
			JPanel temp = new CourierPanel(vo.getOrganizationcode(), vo.getOrganizationname());
			contentPane.add(temp, "courier");
			card.show(contentPane, "courier");
		} else if(vo.getJob() == Job.hallsalesman){
			JPanel temp=new HallsalesmanPanel(vo.getOrganizationname(), vo.getOrganizationcode(), vo.getCity());
			contentPane.add(temp, "hallsalesman");
			card.show(contentPane, "hallsalesman");
		} else if(vo.getJob() == Job.administrator){
			JPanel temp=new AdministratorPanel(vo.getOrganizationcode());
			contentPane.add(temp, "administrator");
			card.show(contentPane, "administrator");
		} else if(vo.getJob() == Job.Financial){
			JPanel temp=new FinancialPanel(vo.getOrganizationcode());
			contentPane.add(temp, "financial");
			card.show(contentPane, "financial");
		} else if(vo.getJob() == Job.transfercentersalesman){
			JPanel temp=new CenterSalesmanPanel(vo.getOrganizationname(), vo.getOrganizationcode(), vo.getCity());
			contentPane.add(temp, "centersalesman");
			card.show(contentPane, "centersalesman");
		} else if(vo.getJob() == Job.CenterDepot){
			JPanel temp=new DepotPanel(vo.getOrganizationcode(), vo.getCity());
			contentPane.add(temp, "centerdepot");
			card.show(contentPane, "centerdepot");
		}
	}
	public void showLogistics(){
		card.show(contentPane, "searchorder");
	}


}
