package presentation.depotui;

import init.ClientInitException;
import init.RMIHelper;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import presentation.depotui.stockexamui.StockExamPanel;
import presentation.depotui.stockinui.StockinCheckPanel;
import presentation.depotui.stockinui.StockinPanel;
import presentation.depotui.stockinui.StockinUpdatePanel;
import presentation.depotui.stockoutui.StockoutCheckPanel;
import presentation.depotui.stockoutui.StockoutPanel;
import presentation.depotui.stockoutui.StockoutUpdatePanel;
import presentation.depotui.stocktakingui.StockTakingPanel;
import presentation.mainui.MainFrame;

public class DepotPanel extends JPanel implements ActionListener {
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private CardLayout card;
	private StockinPanel in;
	private StockoutPanel out;
	private StockExamPanel exam;
	private StockTakingPanel taking;
	private JPanel switcher;
	private JButton button_4;
	
	private StockinCheckPanel inc;
	private StockoutCheckPanel outc;

	/**
	 * Create the panel.
	 */
	public DepotPanel(String orgCode, String city) {
		card = new CardLayout();
		
		

		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		button = new JButton("入库");
		button.setBounds(14, 13, 113, 27);
		add(button);

		button_1 = new JButton("出库");
		button_1.setBounds(141, 13, 113, 27);
		add(button_1);

		button_2 = new JButton("库存查看");
		button_2.setBounds(268, 13, 113, 27);
		add(button_2);

		button_3 = new JButton("库存盘点");
		button_3.setBounds(395, 13, 113, 27);
		add(button_3);

		switcher = new JPanel();
		switcher.setLayout(card);
		switcher.setBounds(20, 71, 945, 420);
		add(switcher);

		StockinUpdatePanel inu = new StockinUpdatePanel(this, card);
		inc = new StockinCheckPanel(switcher, card, inu, orgCode);
		in = new StockinPanel(orgCode, city, switcher, card);
		
		StockoutUpdatePanel outu = new StockoutUpdatePanel(this, card);
		outc = new StockoutCheckPanel(switcher, card, outu, orgCode);
		out = new StockoutPanel(orgCode, city, switcher, card);
		
		exam = new StockExamPanel(orgCode);
		
		taking = new StockTakingPanel(orgCode);
		
		switcher.add(in, "in");
		switcher.add(inc, "inc");
		switcher.add(inu, "inu");
		switcher.add(out, "out");
		switcher.add(outc, "outc");
		switcher.add(outu, "outu");
		switcher.add(exam, "exam");
		switcher.add(taking, "taking");
		
		button.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		
		button_4 = new JButton("注销");
		button_4.setBounds(838, 13, 113, 27);
		add(button_4);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button))
			card.show(switcher, "in");
		else if (e.getSource().equals(button_1))
			card.show(switcher, "out");
		else if (e.getSource().equals(button_2))
			card.show(switcher, "exam");
		else if (e.getSource().equals(button_3))
			card.show(switcher, "taking");
		else if(e.getSource().equals(button_4)){
			try {
		           RMIHelper.init();
		           MainFrame frame= new MainFrame();
		           frame.start();
		        } catch (ClientInitException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(
		                    null,
		                    "Client boots fail!\nCause: " + e1.getMessage(),
		                    "Fatal Error",
		                    JOptionPane.ERROR_MESSAGE
		            );
		        }
		}
	}

	public JPanel getSwitcher() {
		return switcher;
	}

	public StockinCheckPanel getInc() {
		return inc;
	}

	public StockoutCheckPanel getOutc() {
		return outc;
	}

}
