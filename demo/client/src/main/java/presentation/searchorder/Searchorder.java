package presentation.searchorder;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Searchorder extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Searchorder() {
		setLayout(null);
		
		JLabel label = new JLabel("输入订单号查询订单");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label.setBounds(176, 78, 165, 41);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(124, 199, 274, 47);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton.setBounds(216, 326, 99, 31);
		add(btnNewButton);

	}

}
