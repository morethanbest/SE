package init;

import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Serverui extends JFrame {
	private JPanel contentPane;
	private JLabel showstart;
	private JLabel label;
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Serverui frame = new Serverui();
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
	public Serverui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		label=new JLabel();
		String ip="localhost";
		try{
			String temp=InetAddress.getLocalHost()+"";
			ip=temp.split("/")[1];
		} catch (UnknownHostException e){
			e.printStackTrace();
		}
		label.setText("本机ip为："+ip);
		label.setBounds(100, 60, 150, 30);
		contentPane.add(label);
		showstart=new JLabel();
		showstart.setText("服务器已启动");
		showstart.setBounds(140, 30, 150, 30);
		contentPane.add(showstart);
	}
	
}
