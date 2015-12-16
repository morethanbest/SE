package presentation.hallsalesmanui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import presentation.hallsalesmanui.delivery.DeliveryPanel;
import presentation.hallsalesmanui.driver.DriverPanel;
import presentation.hallsalesmanui.goodrecieving.GoodRecievingPanel;
import presentation.hallsalesmanui.hallload.HallLoadPanel;
import presentation.hallsalesmanui.recordcollect.RecordcollectPanel;
import presentation.hallsalesmanui.vehicle.VehiclePanel;



public class HallsalesmanPanel extends JPanel implements ActionListener {
	private JPanel panel;
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

	/**
	 * Create the panel.
	 */
	public HallsalesmanPanel(String orgName,String orgcode, String city) {
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

		panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(14, 75, 954, 450);
		add(panel);
		card = new CardLayout();
		panel.setLayout(card);
		
		//card中添加各种功能面板
		hallLoadPanel = new HallLoadPanel(orgcode, city, orgName);
		goodRecievingPanel = new GoodRecievingPanel(orgcode, city);
		deliveryPanel = new DeliveryPanel(orgcode);
		
		driverPanel=new DriverPanel(orgcode);
		vehiclePanel=new VehiclePanel(orgcode);
		recordcollectPanel=new RecordcollectPanel(orgcode);
		
		panel.add(hallLoadPanel, "hallLoad");
		panel.add(goodRecievingPanel, "goodRecieving");
		panel.add(deliveryPanel, "delivery");
		panel.add(driverPanel, "driver");
		panel.add(vehiclePanel, "vehicle");
		panel.add(recordcollectPanel, "recordcollect");
		
		hint = new JLabel("");
		hint.setBounds(585, 508, 383, 32);
		hint.setVisible(false);
		add(hint);

    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(vehicleButton)) {
			card.show(panel, "vehicle");
		} else if (e.getSource().equals(driverButton)) {
			card.show(panel, "driver");
		} else if (e.getSource().equals(loadButton)) {
			card.show(panel, "hallLoad");
		} else if (e.getSource().equals(goodrecevingButton)) {
			card.show(panel, "goodRecieving");
		} else if (e.getSource().equals(deliveryButton)) {
			card.show(panel, "delivery");
		} else if(e.getSource().equals(reciptionButton)){
			card.show(panel, "recordcollect");
		}
	}
}