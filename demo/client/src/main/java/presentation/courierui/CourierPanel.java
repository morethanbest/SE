package presentation.courierui;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CourierPanel extends JPanel {
	
	private CardLayout card;
	private OrderPanel order;
	private RecievePanel recieve;
	private String orgCode;
	private String orgName;
	
	/**
	 * Create the panel.
	 * @param orgName 机构名
	 * @param orgCode 机构编号
	 */
	public CourierPanel(String orgCode, String orgName) {
		this.orgCode = orgCode;
		this.orgName = orgName;
		card = new CardLayout();
		order = new OrderPanel(this);
		recieve = new RecievePanel(this);
		
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
