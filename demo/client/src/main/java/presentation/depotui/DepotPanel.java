package presentation.depotui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import presentation.depotui.stockexamui.StockExamPanel;
import presentation.depotui.stockinui.StockinPanel;
import presentation.depotui.stockoutui.StockoutPanel;
import presentation.depotui.stocktakingui.StockTakingPanel;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public DepotPanel(String orgCode, String city) {
		card = new CardLayout();
		in = new StockinPanel(orgCode, city);
		out = new StockoutPanel(orgCode, city);
		exam = new StockExamPanel(orgCode);
		taking = new StockTakingPanel(orgCode);

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

		panel = new JPanel();
		panel.setLayout(card);
		panel.setBounds(20, 71, 945, 420);
		add(panel);

		panel.add(in, "in");
		panel.add(out, "out");
		panel.add(exam, "exam");
		panel.add(taking, "taking");
		
		button.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button))
			card.show(panel, "in");
		else if (e.getSource().equals(button_1))
			card.show(panel, "out");
		else if (e.getSource().equals(button_2))
			card.show(panel, "exam");
		else if (e.getSource().equals(button_3))
			card.show(panel, "taking");
	}

}
