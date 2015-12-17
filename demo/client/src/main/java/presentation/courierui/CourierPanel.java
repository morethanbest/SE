package presentation.courierui;

import java.awt.CardLayout;

import javax.swing.JPanel;

import presentation.mainui.MainFrame;

public class CourierPanel extends JPanel {
	
	private CardLayout card;
	private OrderPanel order;
	private RecievePanel recieve;
	private String orgCode;
	private String orgName;
	private MainFrame parent;
	/**
	 * Create the panel.
	 * @param orgName 机构名
	 * @param orgCode 机构编号
	 */
	public CourierPanel(String orgCode, String orgName,MainFrame parent) {
		this.parent=parent;
		this.orgCode = orgCode;
		this.orgName = orgName;
		card = new CardLayout();
		order = new OrderPanel(this,parent);
		recieve = new RecievePanel(this,parent);
		
		setLayout(card);
		add(order, "order");
		add(recieve, "recieve");
	}
	
	void switchPanel(){
		card.next(this);
	}

	public String getOrgCode() {
		return orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

}
