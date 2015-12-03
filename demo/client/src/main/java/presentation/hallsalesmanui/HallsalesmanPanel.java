package presentation.hallsalesmanui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import presentation.hallsalesmanui.driver.DriverPanel;
import presentation.hallsalesmanui.vehicle.VehiclePanel;



public class HallsalesmanPanel extends JPanel implements ActionListener {
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JLabel hint;
	private CardLayout card;
	private DriverPanel driverPanel;
	private VehiclePanel vehiclePanel;
    private String orgcode;
	/**
	 * Create the panel.
	 */
	public HallsalesmanPanel(String orgcode) {
		this.orgcode=orgcode;
		setLayout(null);
		setBounds(0, 0, 982, 553);

		btnNewButton = new JButton("装车单");
		btnNewButton.setBounds(14, 13, 113, 27);
		btnNewButton.addActionListener(this);
		add(btnNewButton);

		btnNewButton_1 = new JButton("到达单");
		btnNewButton_1.setBounds(141, 13, 113, 27);
		btnNewButton_1.addActionListener(this);
		add(btnNewButton_1);

		btnNewButton_2 = new JButton("派件单");
		btnNewButton_2.setBounds(268, 13, 113, 27);
		btnNewButton_2.addActionListener(this);
		add(btnNewButton_2);

		btnNewButton_3 = new JButton("收款单");
		btnNewButton_3.setBounds(395, 13, 113, 27);
		btnNewButton_3.addActionListener(this);
		add(btnNewButton_3);

		btnNewButton_4 = new JButton("车辆信息");
		btnNewButton_4.setBounds(522, 13, 113, 27);
		btnNewButton_4.addActionListener(this);
		add(btnNewButton_4);

		btnNewButton_5 = new JButton("司机信息");
		btnNewButton_5.setBounds(649, 13, 113, 27);
		btnNewButton_5.addActionListener(this);
		add(btnNewButton_5);
     
		btnNewButton_6 = new JButton("注销");
		btnNewButton_6.setBounds(855, 13, 113, 27);
		btnNewButton_6.addActionListener(this);
		add(btnNewButton_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 982, 2);
		add(separator);

		panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(14, 75, 954, 420);
		add(panel);
		card = new CardLayout();
		panel.setLayout(card);
		
		//card中添加各种功能面板
		driverPanel=new DriverPanel(orgcode);
		vehiclePanel=new VehiclePanel(orgcode);
		panel.add(driverPanel, "driver");
		panel.add(vehiclePanel, "vehicle");
		
		hint = new JLabel("");
		hint.setBounds(585, 508, 383, 32);
		hint.setVisible(false);
		add(hint);

}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnNewButton_4)) {
			card.show(panel, "vehicle");
		}else if (e.getSource().equals(btnNewButton_5)) {
			card.show(panel, "driver");
		}
	}
}