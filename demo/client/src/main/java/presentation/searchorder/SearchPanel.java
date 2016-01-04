package presentation.searchorder;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import po.Job;
import presentation.Financial.account.AccountPanel;
import presentation.Financial.balance.BalancePanel;
import presentation.Financial.debitnote.DebitnotePanel;
import presentation.Financial.newbook.NewBookPanel;
import presentation.Financial.recordpay.RecordpayCheckPanel;
import presentation.Financial.recordpay.RecordpayPanel;
import presentation.Financial.recordpay.RecordpayUpdatePanel;
import presentation.Financial.statistics.StatisticsPanel;
import presentation.mainui.MainFrame;
import presentation.mycomp.PersonPanel;

public class SearchPanel extends PersonPanel implements ActionListener{
	private JPanel switcher;
	private JButton btnNewButton;
	private JLabel hint;
	private CardLayout card;
	private Searchorder searchorder;
    private MainFrame parent;
	/**
	 * Create the panel.
	 */
	public SearchPanel(MainFrame parent) {
		this.parent=parent;
		setLayout(null);
		setBounds(0, 0, 982, 553);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		btnNewButton = new JButton("返回");
		btnNewButton.setBounds(879, 0, 103, 40);
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton);
		add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 982, 2);
		add(separator);

		switcher = new JPanel();
		switcher.setBackground(SystemColor.controlHighlight);
		switcher.setBounds(14, 75, 954, 450);
		add(switcher);
		card = new CardLayout();
		switcher.setLayout(card);
		
		//card中添加各种功能面板
		searchorder=new Searchorder(parent);
		switcher.setOpaque(false);
		switcher.add(searchorder, "search");
		hint = new JLabel("");
		hint.setBounds(585, 508, 383, 32);
		hint.setVisible(false);
		add(hint);

}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		setSelectButton(button);
		if (e.getSource().equals(btnNewButton)) {
			parent.skipToLogin();
		}
	}
	private void setNoneBorder(JButton button){
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
	
	private void setSelectButton(JButton button){
		List<JButton> list= new ArrayList<JButton>();
		list.add(btnNewButton);
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


}
