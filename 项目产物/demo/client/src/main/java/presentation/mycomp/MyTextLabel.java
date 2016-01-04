package presentation.mycomp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyTextLabel extends JLabel{
	
	private static final int CORNER = 4;
	private static final int IMG_HEIGHT = 29;
	private static final int IMG_WIDTH = 150;
	
	public MyTextLabel(int x, int y, int w, int h) {
		setBounds(x, y, w, h);
//		setIcon();
	}
	@Override
	public void paintComponent(Graphics g) {
		// 先画背景
		Graphics2D g2 = (Graphics2D) g;
		Image icon = new ImageIcon("img/textfield.png").getImage();
		int w = getSize().width;
		int h = getSize().height;
		g.drawImage(icon, 0, 0, CORNER, h, 0, 0, CORNER, IMG_HEIGHT,null);
		g.drawImage(icon, CORNER, 0, w - CORNER, h, CORNER, 0, IMG_WIDTH - CORNER, IMG_HEIGHT,null);
		g.drawImage(icon, w - CORNER, 0, w, h, IMG_WIDTH - CORNER, 0, IMG_WIDTH, IMG_HEIGHT,null);
		
		// 然后画控件，不然控件内容就被背景覆盖了
		super.paintComponent(g);
	}

}