package presentation.mycomp.mycombobox;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class MyComboBox extends JComboBox {

	public MyComboBox() {
		super();
		init();
	}

	public MyComboBox(ComboBoxModel model) {
		super(model);
		init();
	}

	public MyComboBox(Object[] items) {
		super(items);
		init();
	}

	public MyComboBox(Vector<?> items) {
		super(items);
		init();
	}

	private void init() {
		setOpaque(false);
		setUI(new IComboBoxUI());
		setRenderer(new IComboBoxRenderer());
		setBackground(SystemColor.inactiveCaptionBorder);
	}

	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}
}
