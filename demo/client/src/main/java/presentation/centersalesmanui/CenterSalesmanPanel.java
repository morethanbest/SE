package presentation.centersalesmanui;

import javax.swing.JPanel;
import javax.swing.JButton;

import presentation.centersalesmanui.arrivalui.ArrivalPanel;
import presentation.centersalesmanui.loadui.LoadPanel;
import presentation.centersalesmanui.transferui.TransferPanel;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CenterSalesmanPanel extends JPanel implements ActionListener{
	private JPanel panel;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private CardLayout card;
	private ArrivalPanel arrival;
	private TransferPanel transfer;
	private LoadPanel load;

	/**
	 * Create the panel.
	 */
	public CenterSalesmanPanel(String orgName, String orgCode, String city) {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		btnNewButton = new JButton("到达单");
		btnNewButton.setBounds(14, 13, 113, 27);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("中转单");
		btnNewButton_1.setBounds(141, 13, 113, 27);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("装车单");
		btnNewButton_2.setBounds(268, 13, 113, 27);
		add(btnNewButton_2);
		
		panel = new JPanel();
		panel.setBounds(18, 75, 945, 418);
		add(panel);
		card = new CardLayout();
		panel.setLayout(card);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);

		arrival = new ArrivalPanel(orgCode);
		transfer = new TransferPanel(orgCode, city);
		load = new LoadPanel(orgCode, city);
		
		panel.add(arrival, "arrival");
		panel.add(transfer, "transfer");
		panel.add(load, "load");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnNewButton)){
			card.show(panel, "arrival");
		} else if(e.getSource().equals(btnNewButton_1)){
			card.show(panel, "transfer");
		} else if(e.getSource().equals(btnNewButton_2)){
			card.show(panel, "load");
		}
	}
}
