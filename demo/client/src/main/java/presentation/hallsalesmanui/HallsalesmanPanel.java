package presentation.hallsalesmanui;

import init.ClientInitException;
import init.RMIHelper;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import presentation.hallsalesmanui.delivery.DeliveryCheckPanel;
import presentation.hallsalesmanui.delivery.DeliveryPanel;
import presentation.hallsalesmanui.delivery.DeliveryUpdatePanel;
import presentation.hallsalesmanui.driver.DriverPanel;
import presentation.hallsalesmanui.goodrecieving.GoodRecievingCheckPanel;
import presentation.hallsalesmanui.goodrecieving.GoodRecievingPanel;
import presentation.hallsalesmanui.goodrecieving.GoodRecievingUpdatePanel;
import presentation.hallsalesmanui.hallload.HallLoadCheckPanel;
import presentation.hallsalesmanui.hallload.HallLoadPanel;
import presentation.hallsalesmanui.hallload.HallLoadUpdatePanel;
import presentation.hallsalesmanui.recordcollect.RecordcollectCheckPanel;
import presentation.hallsalesmanui.recordcollect.RecordcollectPanel;
import presentation.hallsalesmanui.vehicle.VehiclePanel;
import presentation.mainui.MainFrame;



public class HallsalesmanPanel extends JPanel implements ActionListener {
	private JPanel switcher;
	private JButton loadButton;
	private JButton goodrecevingButton;
	private JButton deliveryButton;
	private JButton reciptionButton;
	private JButton vehicleButton;
	private JButton driverButton;
	private JButton logoutButton;
	private JLabel hint;
	private CardLayout card;
	private HallLoadPanel hallLoadPanel;
	private GoodRecievingPanel goodRecievingPanel;
	private DeliveryPanel deliveryPanel;
	private DriverPanel driverPanel;
	private VehiclePanel vehiclePanel;
	private RecordcollectPanel recordcollectPanel;
	
	private DeliveryCheckPanel dc;
	private GoodRecievingCheckPanel gc;
	private HallLoadCheckPanel hc;
	private RecordcollectCheckPanel rc;
    private MainFrame parent;
	/**
	 * Create the panel.
	 */
	public HallsalesmanPanel(String orgName,String orgcode, String city,MainFrame parent) {
		this.parent=parent;
		setLayout(null);
		setBounds(0, 0, 982, 553);

		loadButton = new JButton("装车单");
		loadButton.setBounds(14, 13, 113, 27);
		loadButton.addActionListener(this);
		add(loadButton);

		goodrecevingButton = new JButton("到达单");
		goodrecevingButton.setBounds(141, 13, 113, 27);
		goodrecevingButton.addActionListener(this);
		add(goodrecevingButton);

		deliveryButton = new JButton("派件单");
		deliveryButton.setBounds(268, 13, 113, 27);
		deliveryButton.addActionListener(this);
		add(deliveryButton);

		reciptionButton = new JButton("收款单");
		reciptionButton.setBounds(395, 13, 113, 27);
		reciptionButton.addActionListener(this);
		add(reciptionButton);

		vehicleButton = new JButton("车辆信息");
		vehicleButton.setBounds(522, 13, 113, 27);
		vehicleButton.addActionListener(this);
		add(vehicleButton);

		driverButton = new JButton("司机信息");
		driverButton.setBounds(649, 13, 113, 27);
		driverButton.addActionListener(this);
		add(driverButton);
     
		logoutButton = new JButton("注销");
		logoutButton.setBounds(855, 13, 113, 27);
		logoutButton.addActionListener(this);
		add(logoutButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 982, 2);
		add(separator);

		switcher = new JPanel();
		switcher.setBackground(SystemColor.controlHighlight);
		switcher.setBounds(14, 75, 954, 450);
		add(switcher);
		card = new CardLayout();
		switcher.setLayout(card);
		
		//card中添加各种功能面板
		HallLoadUpdatePanel hu = new HallLoadUpdatePanel(this, card);
		hc = new HallLoadCheckPanel(switcher, card, hu, orgcode);
		hallLoadPanel = new HallLoadPanel(orgcode, city, orgName, switcher, card);
		
		GoodRecievingUpdatePanel gu = new GoodRecievingUpdatePanel(this, card, orgName);
		gc = new GoodRecievingCheckPanel(switcher, card, gu, orgcode, orgName);
		goodRecievingPanel = new GoodRecievingPanel(orgcode, city, switcher, card);
		
		DeliveryUpdatePanel du = new DeliveryUpdatePanel(this, card);
		dc = new DeliveryCheckPanel(switcher, card, du, orgcode);
		deliveryPanel = new DeliveryPanel(orgcode, switcher, card);
		
		driverPanel=new DriverPanel(orgcode);
		vehiclePanel=new VehiclePanel(orgcode);
		
		recordcollectPanel=new RecordcollectPanel(orgcode);
		
		switcher.add(hallLoadPanel, "hallLoad");
		switcher.add(hc, "hc");
		switcher.add(hu, "hu");
		switcher.add(goodRecievingPanel, "goodRecieving");
		switcher.add(gc, "gc");
		switcher.add(gu, "gu");
		switcher.add(deliveryPanel, "delivery");
		switcher.add(dc, "dc");
		switcher.add(du, "du");

		switcher.add(driverPanel, "driver");
		switcher.add(vehiclePanel, "vehicle");
		
		switcher.add(recordcollectPanel, "recordcollect");
		
		hint = new JLabel("");
		hint.setBounds(585, 508, 383, 32);
		hint.setVisible(false);
		add(hint);

    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(vehicleButton)) {
			card.show(switcher, "vehicle");
		} else if (e.getSource().equals(driverButton)) {
			card.show(switcher, "driver");
		} else if (e.getSource().equals(loadButton)) {
			card.show(switcher, "hallLoad");
		} else if (e.getSource().equals(goodrecevingButton)) {
			card.show(switcher, "goodRecieving");
		} else if (e.getSource().equals(deliveryButton)) {
			card.show(switcher, "delivery");
		} else if(e.getSource().equals(reciptionButton)){
			card.show(switcher, "recordcollect");
		} else if(e.getSource().equals(logoutButton)){
			parent.skipToLogin();

		}
	}
	public JPanel getSwitcher() {
		return switcher;
	}
	public DeliveryCheckPanel getDc() {
		return dc;
	}
	public GoodRecievingCheckPanel getGc() {
		return gc;
	}
	public HallLoadCheckPanel getHc() {
		return hc;
	}
	public RecordcollectCheckPanel getRc() {
		return rc;
	}
	
	
}