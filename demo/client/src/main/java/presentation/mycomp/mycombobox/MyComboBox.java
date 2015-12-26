package presentation.mycomp.mycombobox;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class MyComboBox<E> extends JComboBox {

	public MyComboBox() {
		super();
		init();
	}

	public MyComboBox(ComboBoxModel<E> model) {
		super(model);
		init();
	}

	public MyComboBox(E[] items) {
		super(items);
		init();
	}

	public MyComboBox(Vector<E> items) {
		super(items);
		init();
	}

	private void init() {
		setOpaque(false);
		setUI(new IComboBoxUI(this));
		setRenderer(new IComboBoxRenderer<E>());
		setBackground(SystemColor.inactiveCaptionBorder);
	}

	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}
}
