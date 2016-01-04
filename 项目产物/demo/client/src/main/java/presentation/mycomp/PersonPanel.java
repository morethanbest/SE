package presentation.mycomp;

import java.awt.Graphics;
import java.awt.Image;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.userbl.inlinepack.Inlinetest;
import businesslogicservice.userblservice.Inline;

public class PersonPanel extends JPanel {
	private JLabel netLabel;

	protected PersonPanel() {
		super();
		setOpaque(false);
		setLayout(null);

		netLabel = new JLabel("");
		netLabel.setBounds(804, 516, 164, 24);
		add(netLabel);

		checkNet();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon("img/personback.png").getImage();
		g.drawImage(image, 0, 0, this);
	}

	private void checkNet() {
		Inline test = new Inlinetest();
		Thread check = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						test.addNew();
						netLabel.setText("网络连接良好");
					} catch (RemoteException e) {
						System.out.println("hjgk");
						netLabel.setText("网络连接断开");
					}
				}
			}
		});
		check.start();
	}
}
