package presentation.mycomp;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WorkPanel extends JPanel {
	protected WorkPanel(){
		super();
		setOpaque(false);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon("img/workback.png").getImage();
		g.drawImage(image, 0, 0, this);
	}

}
