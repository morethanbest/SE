package presentation.mainui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import po.Job;
import businesslogic.userbl.UsersloginPack.UserloginController;
import businesslogicservice.userblservice.UserloginBlService;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("黑体", Font.PLAIN, 20));
		textField.setOpaque(false);
		textField.setBorder(new EmptyBorder(0,0,0,0));
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(404, 203, 234, 45);
		contentPane.add(textField);
		textField.setColumns(12);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 13));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(404, 286, 234, 45);
		passwordField.setOpaque(false);
		passwordField.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("\u5FEB\u9012\u516C\u53F8\u7BA1\u7406\u7CFB\u7EDF");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("华文琥珀", Font.BOLD, 49));
		label.setBounds(282, 94, 424, 64);
		contentPane.add(label);
		
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserloginBlService userloginBlService = new UserloginController();
				try {
					long id = Long.parseLong(textField.getText());
					String password = passwordField.getPassword().toString();
					skip(userloginBlService.login(id, password));
				} catch (NumberFormatException e1) {
					try {
						WrongDialog dialog = new WrongDialog();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
			private void skip(Job job){
				if(job == Job.manager){
					System.out.println("登录成功，身份为manager!!!");
				}else if(job == Job.visitor){
					System.out.println("登录失败，没有此账号!!!");
				}
			}
		});
		button .setFont(new Font("黑体", Font.BOLD, 18));
		button.setBounds(433, 381, 141, 43);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2\u7269\u6D41\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("不能用啊！！！！！！！");
			}
		});
		button_1.setFont(new Font("黑体", Font.BOLD, 18));
		button_1.setBounds(759, 473, 158, 43);
		contentPane.add(button_1);
		
		JLabel label_3 = new JLabel(new ImageIcon("G:\\GitHub\\SE\\Clientproject\\\u7528\u6237.png"));
		label_3.setBounds(358, 203, 280, 45);
		contentPane.add(label_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("G:\\GitHub\\SE\\Clientproject\\\u5BC6\u7801.png"));
		label_1.setBounds(358, 286, 280, 45);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("G:\\GitHub\\SE\\Clientproject\\\u4E34\u65F6\u80CC\u666F.png"));
		label_2.setBounds(0, 0, 982, 553);
		contentPane.add(label_2);
	}
	
	
}
