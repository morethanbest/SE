package presentation.administratorui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class AdministratorPanel extends JPanel implements ActionListener {
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton1;
	private JLabel hint;
	private CardLayout card;
	private UserPanel userPanel;
    /**
	 * Create the panel.
	 */
	public AdministratorPanel(String orgcode) {
		setLayout(null);
		setBounds(0, 0, 982, 553);

		btnNewButton = new JButton("用户管理");
		btnNewButton.setBounds(14, 13, 113, 27);
		add(btnNewButton);
     
		btnNewButton1 = new JButton("注销");
		btnNewButton1.setBounds(855, 13, 113, 27);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnNewButton1)) {
			
		}
	}

}
