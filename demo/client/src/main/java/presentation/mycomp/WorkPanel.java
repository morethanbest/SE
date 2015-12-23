package presentation.mycomp;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WorkPanel extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon("img/工作背景.png").getImage();
		g.drawImage(image, 0, 0, this);
	}

}
