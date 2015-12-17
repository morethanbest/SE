package presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import po.Job;
import presentation.searchorder.Searchorder;
import businesslogic.userbl.UsersloginPack.UserloginController;
import businesslogicservice.userblservice.UserloginBlService;

public class LoginPanel extends JPanel implements ActionListener {

	private JTextField textField;
	private JPasswordField passwordField;
	private JButton button;
	private JButton button_1;
	private MainFrame frame;

	/**
	 * Create the panel.
	 */
	public LoginPanel(MainFrame frame) {
		this.frame = frame;
		setLayout(null);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("����", Font.PLAIN, 20));
		textField.setOpaque(false);
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(404, 203, 234, 45);
		add(textField);
		textField.setColumns(12);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("����", Font.PLAIN, 13));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(404, 286, 234, 45);
		passwordField.setOpaque(false);
		passwordField.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(passwordField);

		JLabel label = new JLabel(
				"\u5FEB\u9012\u516C\u53F8\u7BA1\u7406\u7CFB\u7EDF");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("华文琥珀", Font.BOLD, 49));
		label.setBounds(282, 94, 424, 64);
		add(label);

		button = new JButton("\u767B\u5F55");
		button.addActionListener(this);
		button.setFont(new Font("����", Font.BOLD, 18));
		button.setBounds(433, 381, 141, 43);
		add(button);

		button_1 = new JButton("\u67E5\u8BE2\u7269\u6D41\u4FE1\u606F");
		button_1.addActionListener(this);
		button_1.setFont(new Font("����", Font.BOLD, 18));
		button_1.setBounds(759, 473, 158, 43);
		add(button_1);

		JLabel label_3 = new JLabel(new ImageIcon(
				"G:\\GitHub\\SE\\Clientproject\\\u7528\u6237.png"));
		label_3.setBounds(358, 203, 280, 45);
		add(label_3);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(
				"G:\\GitHub\\SE\\Clientproject\\\u5BC6\u7801.png"));
		label_1.setBounds(358, 286, 280, 45);
		add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(
				"G:\\GitHub\\SE\\Clientproject\\\u4E34\u65F6\u80CC\u666F.png"));
		label_2.setBounds(0, 0, 982, 553);
		add(label_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button)) {
			UserloginBlService userloginBlService = new UserloginController();
//			try {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				frame.skipToNext(userloginBlService.login(username, password));
//				frame.skipToNext(Job.manager);//作者测试用，真实使用时注释掉
//			} catch (NullPointerException e1) {
//				try {
//					WrongDialog dialog = new WrongDialog();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
		}else if(e.getSource().equals(button_1)){
			frame.showLogistics();
		}
	}

}
