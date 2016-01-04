package presentation.depotui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
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
import presentation.mycomp.PersonPanel;

public class DepotPanel extends PersonPanel implements ActionListener {
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
	private MainFrame parent;

	/**
	 * Create the panel.
	 */
	public DepotPanel(String orgCode, String city,MainFrame parent) {
		this.parent=parent;
		card = new CardLayout();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		button = new JButton("入库");
		button.setBounds(0, 0, 96, 40);
		button.setForeground(SystemColor.windowBorder);
		button.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		button.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(button);
		add(button);
		
		button_1 = new JButton("出库");
		button_1.setBounds(97, 0, 96, 40);
		button_1.setForeground(SystemColor.windowBorder);
		button_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		button_1.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(button_1);
		add(button_1);

		button_2 = new JButton("库存查看");
		button_2.setBounds(194, 0, 96, 40);
		button_2.setForeground(SystemColor.windowBorder);
		button_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		button_2.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(button_2);
		add(button_2);

		button_3 = new JButton("库存盘点");
		button_3.setBounds(291, 0, 96, 40);
		button_3.setForeground(SystemColor.windowBorder);
		button_3.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		button_3.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(button_3);
		add(button_3);

		switcher = new JPanel();
		switcher.setOpaque(false);
		switcher.setLayout(card);
		switcher.setBounds(20, 71, 945, 420);
		add(switcher);

		StockinUpdatePanel inu = new StockinUpdatePanel(this, card);
		inc = new StockinCheckPanel(switcher, card, inu, orgCode);
		in = new StockinPanel(orgCode, city, this, card);
		
		StockoutUpdatePanel outu = new StockoutUpdatePanel(this, card);
		outc = new StockoutCheckPanel(switcher, card, outu, orgCode);
		out = new StockoutPanel(orgCode, city, this, card);
		
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
		
		button_4 = new JButton("注销");
		button_4.setBounds(879, 0, 103, 40);
		button_4.setForeground(SystemColor.windowBorder);
		button_4.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		button_4.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(button_4);
		add(button_4);
		
		button.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_4.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton newbutton = (JButton) e.getSource();
		setSelectButton(newbutton);
		if (e.getSource().equals(button))
			card.show(switcher, "in");
		else if (e.getSource().equals(button_1))
			card.show(switcher, "out");
		else if (e.getSource().equals(button_2))
			card.show(switcher, "exam");
		else if (e.getSource().equals(button_3))
			card.show(switcher, "taking");
		else if(e.getSource().equals(button_4)){
			parent.skipToLogin();
		}
	}
	private void setNoneBorder(JButton button){
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	};
	
	private void setSelectButton(JButton newbutton){
		List<JButton> list= new ArrayList<JButton>();
		list.add(button);
		list.add(button_1);
		list.add(button_2);
		list.add(button_3);
		list.add(button_4);
		for(JButton b:list){
			if(b.equals(newbutton)){
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

	public StockinCheckPanel getInc() {
		return inc;
	}

	public StockoutCheckPanel getOutc() {
		return outc;
	}

}
