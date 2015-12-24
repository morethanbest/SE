package presentation.mycomp;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PersonPanel extends JPanel {
	protected PersonPanel(){
		super();
		setOpaque(false);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon("img/personback.png").getImage();
		g.drawImage(image, 0, 0, this);
	}
	
}
