package presentation.administratorui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import init.ClientInitException;
import init.RMIHelper;
import presentation.mainui.LoginPanel;
import presentation.mainui.MainFrame;

public class AdministratorPanel extends JPanel implements ActionListener {
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton1;
	private JLabel hint;
	private CardLayout card;
	private UserPanel userPanel;
	private MainFrame parent;
    /**
	 * Create the panel.
	 */
	public AdministratorPanel(String orgcode,MainFrame parent) {
		this.parent=parent;
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		setBounds(0, 0, 982, 553);

		btnNewButton = new JButton("用户管理");
		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setBounds(0, 0, 96, 40);
		setNoneBorder(btnNewButton);
		add(btnNewButton);
     
		btnNewButton1 = new JButton("注销");
		btnNewButton1.setBounds(879, 0, 103, 40);
		btnNewButton1.setForeground(SystemColor.windowBorder);
		btnNewButton1.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton1.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton1);
		btnNewButton1.addActionListener(this);
		add(btnNewButton1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 982, 2);
		add(separator);

		panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(14, 75, 954, 420);
		add(panel);
		card = new CardLayout();
		panel.setLayout(card);
		
		//card中添加各种功能面板
		userPanel=new UserPanel(orgcode);
		panel.add(userPanel, "uesr");
		
		hint = new JLabel("");
		hint.setBounds(585, 508, 383, 32);
		hint.setVisible(false);
		add(hint);

    }
	private void setNoneBorder(JButton button){
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	};
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		setSelectButton(button);
		if (e.getSource().equals(btnNewButton1)) {
			parent.skipToLogin();
		}

	}
	private void setSelectButton(JButton button){
		List<JButton> list= new ArrayList<JButton>();
		list.add(btnNewButton);
		list.add(btnNewButton1);
		for(JButton b:list){
			if(b.equals(button)){
				b.setForeground(SystemColor.text);
				b.setBackground(SystemColor.textHighlight);
			}else{
				b.setForeground(SystemColor.windowBorder);
				b.setBackground(SystemColor.inactiveCaptionBorder);
			}
		}
	};

}
