package presentation.courierui;

import java.awt.CardLayout;

import presentation.mainui.MainFrame;
import presentation.mycomp.PersonPanel;

public class CourierPanel extends PersonPanel {
	
	private CardLayout card;
	private OrderPanel order;
	private RecievePanel recieve;
	private String orgCode;
	private String orgName;
	private OrderCheckPanel orderc;
	/**
	 * Create the panel.
	 * @param orgName 机构名
	 * @param orgCode 机构编号
	 */
	public CourierPanel(String orgCode, String orgName,MainFrame parent) {
		this.orgCode = orgCode;
		this.orgName = orgName;
		card = new CardLayout();
		OrderUpdatePanel orderu = new OrderUpdatePanel(this, card);
		orderc = new OrderCheckPanel(this, orderu, orgCode);
		order = new OrderPanel(this,parent);
		recieve = new RecievePanel(this,parent);
		
		setLayout(card);
		add(order, "order");
		add(orderu, "orderu");
		add(orderc, "orderc");
		add(recieve, "recieve");
	}
	
	void switchPanel(String str){
		card.show(this, str);
	}

	public String getOrgCode() {
		return orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public OrderCheckPanel getOrderc() {
		return orderc;
	}

}
