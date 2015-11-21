package presentation.managerui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagerPanel() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(14, 13, 113, 27);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(141, 13, 113, 27);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(268, 13, 113, 27);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(395, 13, 113, 27);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5E38\u91CF\u4FE1\u606F\u5236\u5B9A");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(522, 13, 113, 27);
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(649, 13, 113, 27);
		add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(855, 13, 113, 27);
		add(btnNewButton_6);

	}
}
