package presentation.mycomp.mycombobox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class IComboBoxRenderer<E> implements ListCellRenderer<E> {

	private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();

	public IComboBoxRenderer() {
		super();
	}

	public Component getListCellRendererComponent(JList<? extends E> list, E value,
			int index, boolean isSelected, boolean cellHasFocus) {

		JLabel renderer = (JLabel) defaultCellRenderer
				.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
		if (isSelected) {
			renderer.setBackground(Color.BLACK);
			renderer.setForeground(Color.WHITE);
		} else {
			renderer.setBackground(Color.WHITE);
		}
		list.setSelectionBackground(Color.WHITE);
		list.setBorder(null);
		renderer.setFont(new Font("微软雅黑", Font.BOLD, 15));
		renderer.setHorizontalAlignment(JLabel.CENTER);
		return renderer;
	}
}
