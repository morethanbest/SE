package presentation.hallsalesmanui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
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
import presentation.hallsalesmanui.recordcollect.RecordcollectUpdatePanel;
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
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		setBounds(0, 0, 982, 553);

		loadButton = new JButton("装车单");
		loadButton.setBounds(0, 0, 96, 40);
		loadButton.addActionListener(this);
		loadButton.setForeground(SystemColor.windowBorder);
		loadButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		loadButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(loadButton);
		add(loadButton);

		goodrecevingButton = new JButton("到达单");
		goodrecevingButton.setBounds(97, 0, 96, 40);
		goodrecevingButton.addActionListener(this);
		goodrecevingButton.setForeground(SystemColor.windowBorder);
		goodrecevingButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		goodrecevingButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(goodrecevingButton);
		add(goodrecevingButton);

		deliveryButton = new JButton("派件单");
		deliveryButton.setBounds(194, 0, 96, 40);
		deliveryButton.addActionListener(this);
		deliveryButton.setForeground(SystemColor.windowBorder);
		deliveryButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		deliveryButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(deliveryButton);
		add(deliveryButton);

		reciptionButton = new JButton("收款单");
		reciptionButton.setBounds(291, 0, 96, 40);
		reciptionButton.addActionListener(this);
		reciptionButton.setForeground(SystemColor.windowBorder);
		reciptionButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		reciptionButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(reciptionButton);
		add(reciptionButton);

		vehicleButton = new JButton("车辆信息");
		vehicleButton.setBounds(389, 0, 96, 40);
		vehicleButton.addActionListener(this);
		vehicleButton.setForeground(SystemColor.windowBorder);
		vehicleButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		vehicleButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(vehicleButton);
		add(vehicleButton);

		driverButton = new JButton("司机信息");
		driverButton.setBounds(485, 0, 96, 40);
		driverButton.addActionListener(this);
		driverButton.setForeground(SystemColor.windowBorder);
		driverButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		driverButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(driverButton);
		add(driverButton);
     
		logoutButton = new JButton("注销");
		logoutButton.setBounds(879, 0, 103, 40);
		logoutButton.addActionListener(this);
		logoutButton.setForeground(SystemColor.windowBorder);
		logoutButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		logoutButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(logoutButton);
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
		hallLoadPanel = new HallLoadPanel(orgcode, city, orgName, this, card);
		
		GoodRecievingUpdatePanel gu = new GoodRecievingUpdatePanel(this, card, orgName);
		gc = new GoodRecievingCheckPanel(switcher, card, gu, orgcode, orgName);
		goodRecievingPanel = new GoodRecievingPanel(orgcode, city, this, card);
		
		DeliveryUpdatePanel du = new DeliveryUpdatePanel(this, card);
		dc = new DeliveryCheckPanel(switcher, card, du, orgcode);
		deliveryPanel = new DeliveryPanel(orgcode, this, card);
		
		driverPanel=new DriverPanel(orgcode);
		vehiclePanel=new VehiclePanel(orgcode);
		
		RecordcollectUpdatePanel ru = new RecordcollectUpdatePanel(this, card);
		rc= new RecordcollectCheckPanel(switcher, card, ru, orgcode);
		recordcollectPanel=new RecordcollectPanel(orgcode, this, card);
		
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
		switcher.add(rc, "rc");
		switcher.add(ru, "ru");
		
		hint = new JLabel("");
		hint.setBounds(585, 508, 383, 32);
		hint.setVisible(false);
		add(hint);

    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		setSelectButton(button);
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
	private void setNoneBorder(JButton button){
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
	
	private void setSelectButton(JButton button){
		List<JButton> list= new ArrayList<JButton>();
		list.add(loadButton);
		list.add(goodrecevingButton);
		list.add(deliveryButton);
		list.add(reciptionButton);
		list.add(vehicleButton);
		list.add(driverButton);
		list.add(logoutButton);
		for(JButton b:list){
			if(b.equals(button)){
				b.setForeground(SystemColor.text);
				b.setBackground(SystemColor.textHighlight);
			}else{
				b.setForeground(SystemColor.windowBorder);
				b.setBackground(SystemColor.inactiveCaptionBorder);
			}
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