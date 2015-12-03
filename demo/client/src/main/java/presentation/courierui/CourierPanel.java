package presentation.courierui;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CourierPanel extends JPanel {
	
	CardLayout card;
	OrderPanel order;
	RecievePanel recieve;
	
	/**
	 * Create the panel.
	 */
	public CourierPanel() {
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

}
