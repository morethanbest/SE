package presentation.centersalesmanui;

import javax.swing.JPanel;
import javax.swing.JButton;

import presentation.centersalesmanui.arrivalui.ArrivalCheckPanel;
import presentation.centersalesmanui.arrivalui.ArrivalPanel;
import presentation.centersalesmanui.arrivalui.ArrivalUpdatePanel;
import presentation.centersalesmanui.loadui.CenterLoadCheckPanel;
import presentation.centersalesmanui.loadui.CenterLoadPanel;
import presentation.centersalesmanui.loadui.CenterLoadUpdatePanel;
import presentation.centersalesmanui.transferui.TransferCheckPanel;
import presentation.centersalesmanui.transferui.TransferPanel;
import presentation.centersalesmanui.transferui.TransferUpdatePanel;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CenterSalesmanPanel extends JPanel implements ActionListener{
	private JPanel switcher;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private CardLayout card;
	
	private ArrivalPanel arrival;
	private TransferPanel transfer;
	private CenterLoadPanel load;

	private ArrivalCheckPanel ac;
	private CenterLoadCheckPanel cc;
	private TransferCheckPanel tc;
	
	private ArrivalUpdatePanel au;
	private CenterLoadUpdatePanel cu;
	private TransferUpdatePanel tu;
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
		
		switcher = new JPanel();
		switcher.setBounds(18, 75, 945, 418);
		add(switcher);
		card = new CardLayout();
		switcher.setLayout(card);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);

		au = new ArrivalUpdatePanel(this, card, orgName);
		ac = new ArrivalCheckPanel(switcher, card, au, orgCode, city);
		arrival = new ArrivalPanel(orgCode, switcher, card);
		
		tu = new TransferUpdatePanel(this, card);
		tc = new TransferCheckPanel(switcher, card, tu, orgCode);
		transfer = new TransferPanel(orgCode, city, switcher, card);
		
		cu = new CenterLoadUpdatePanel(this, card);
		cc = new CenterLoadCheckPanel(switcher, card, cu, orgCode);
		load = new CenterLoadPanel(orgCode, city, switcher, card);
		
		switcher.add(arrival, "arrival");
		switcher.add(ac, "ac");
		switcher.add(au, "au");
		switcher.add(transfer, "transfer");
		switcher.add(tc, "tc");
		switcher.add(tu, "tu");
		switcher.add(load, "load");
		switcher.add(cc, "cc");
		switcher.add(cu, "cu");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnNewButton)){
			card.show(switcher, "arrival");
		} else if(e.getSource().equals(btnNewButton_1)){
			card.show(switcher, "transfer");
		} else if(e.getSource().equals(btnNewButton_2)){
			card.show(switcher, "load");
		}
	}

	public JPanel getSwitcher() {
		return switcher;
	}

	public ArrivalCheckPanel getArrival() {
		return ac;
	}

	public TransferCheckPanel getTransfer() {
		return tc;
	}

	public CenterLoadCheckPanel getLoad() {
		return cc;
	}
	
	
}
