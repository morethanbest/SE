package presentation.centersalesmanui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.centersalesmanui.arrivalui.ArrivalCheckPanel;
import presentation.centersalesmanui.arrivalui.ArrivalPanel;
import presentation.centersalesmanui.arrivalui.ArrivalUpdatePanel;
import presentation.centersalesmanui.loadui.CenterLoadCheckPanel;
import presentation.centersalesmanui.loadui.CenterLoadPanel;
import presentation.centersalesmanui.loadui.CenterLoadUpdatePanel;
import presentation.centersalesmanui.transferui.TransferCheckPanel;
import presentation.centersalesmanui.transferui.TransferPanel;
import presentation.centersalesmanui.transferui.TransferUpdatePanel;
import presentation.mainui.MainFrame;

public class CenterSalesmanPanel extends JPanel implements ActionListener{
	private JPanel switcher;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnZhu;
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
	private MainFrame parent;
	/**
	 * Create the panel.
	 */
	public CenterSalesmanPanel(String orgName, String orgCode, String city,MainFrame parent) {
		this.parent=parent;
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		setBounds(0, 0, 982, 553);
		
		btnNewButton = new JButton("到达单");
		btnNewButton.setBounds(0, 0, 96, 40);
		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("中转单");
		btnNewButton_1.setBounds(97, 0, 96, 40);
		btnNewButton_1.setForeground(SystemColor.windowBorder);
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton_1);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("装车单");
		btnNewButton_2.setBounds(194, 0, 96, 40);
		btnNewButton_2.setForeground(SystemColor.windowBorder);
		btnNewButton_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton_2.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton_2);
		add(btnNewButton_2);
		
		switcher = new JPanel();
		switcher.setOpaque(false);
		switcher.setBounds(18, 75, 945, 418);
		add(switcher);
		card = new CardLayout();
		switcher.setLayout(card);
		
		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);
		btnNewButton_2.addActionListener(this);

		au = new ArrivalUpdatePanel(this, card, orgName);
		ac = new ArrivalCheckPanel(switcher, card, au, orgCode, city);
		arrival = new ArrivalPanel(orgCode, this, card);
		
		tu = new TransferUpdatePanel(this, card);
		tc = new TransferCheckPanel(switcher, card, tu, orgCode);
		transfer = new TransferPanel(orgCode, city, this, card);
		
		cu = new CenterLoadUpdatePanel(this, card);
		cc = new CenterLoadCheckPanel(switcher, card, cu, orgCode);
		load = new CenterLoadPanel(orgCode, city, this, card);
		
		switcher.add(arrival, "arrival");
		switcher.add(ac, "ac");
		switcher.add(au, "au");
		switcher.add(transfer, "transfer");
		switcher.add(tc, "tc");
		switcher.add(tu, "tu");
		switcher.add(load, "load");
		switcher.add(cc, "cc");
		switcher.add(cu, "cu");
		
		btnZhu = new JButton("注销");
		btnZhu.setBounds(815, 13, 113, 27);
		add(btnZhu);
		btnZhu.setBackground(SystemColor.inactiveCaptionBorder);
		btnZhu.setBounds(879, 0, 103, 40);
		btnZhu.addActionListener(this);
		setNoneBorder(btnZhu);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		setSelectButton(button);
		if(e.getSource().equals(btnNewButton)){
			card.show(switcher, "arrival");
		} else if(e.getSource().equals(btnNewButton_1)){
			card.show(switcher, "transfer");
		} else if(e.getSource().equals(btnNewButton_2)){
			card.show(switcher, "load");
		} else if(e.getSource().equals(btnZhu)){
			parent.skipToLogin();
		}
	}
	private void setNoneBorder(JButton button){
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	};
	
	private void setSelectButton(JButton button){
		List<JButton> list= new ArrayList<JButton>();
		list.add(btnNewButton);
		list.add(btnNewButton_1);
		list.add(btnNewButton_2);
		for(JButton b:list){
			if(b.equals(button)){
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
