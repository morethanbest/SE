package presentation.mycomp.mycombobox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class IComboBoxRenderer<E> implements ListCellRenderer<E> {

	private MyListCellRender defaultCellRenderer = new MyListCellRender();

	public IComboBoxRenderer() {
		super();
	}

	public Component getListCellRendererComponent(JList<? extends E> list, E value,
			int index, boolean isSelected, boolean cellHasFocus) {

		MyListCellRender renderer = (MyListCellRender)defaultCellRenderer.getListCellRendererComponent(
				 list, value, index, isSelected, cellHasFocus);
;
		renderer.setIcon(new ImageIcon("img/list_middle.png"));
		if(isSelected)
			renderer.setIcon(new ImageIcon("img/list_enter.png"));
		list.setSelectionBackground(Color.WHITE);
		list.setBorder(null);
		list.setFont(new Font("黑体", Font.ITALIC, 15));
		renderer.setHorizontalAlignment(JLabel.LEFT);
		return renderer;
	}
}
