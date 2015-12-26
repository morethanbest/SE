package presentation.mycomp.mycombobox;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class MyListCellRender extends DefaultListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
		return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon icon = (ImageIcon) getIcon();
		Image img = icon.getImage();
		int x = getSize().width;
		int y = getSize().height;
		g.drawImage(img, 0, 0, x, y, null);
		g.drawString(getText(), 5, y / 2 + 3);
	}
}
