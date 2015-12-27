package presentation.mycomp.mycombobox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import presentation.mycomp.myscrollpane.MyScrollPane;

public class IComboBoxUI extends BasicComboBoxUI {

	private JButton arrow;
	private boolean boundsLight = false;
	private static final int ARCWIDTH = 5;
	private static final int ARCHEIGHT = 5;
	MyComboBox myComboBox;

	public IComboBoxUI(MyComboBox myComboBox) {
		super();
		this.myComboBox = myComboBox;
		
	}

	//下箭头按钮
	@Override
	protected JButton createArrowButton() {
		arrow = new JButton("");
//		ImageIcon increase = new ImageIcon("img/DarkDownArrow.png");
//		arrow.setIcon(increase);
		arrow.setRolloverEnabled(true);
//		arrow.setRolloverIcon(increase);
		arrow.setBorder(null);
		arrow.setBackground(SystemColor.inactiveCaptionBorder);
		arrow.setOpaque(false);
		arrow.setContentAreaFilled(false);
		return arrow;
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		hasFocus = comboBox.hasFocus();
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int w = c.getWidth();
		int h = c.getHeight();
		Image increase = new ImageIcon("img/comboboxback.png").getImage();
		g2.drawImage(increase, 0, 0, 7, h, 0, 0, 7, 27, null);
		g2.drawImage(increase, 7, 0, w - 21, h, 7, 0, 97, 27, null);
		g2.drawImage(increase, w - 21, 0, w, h, 97, 0, 118, 27, null);
		if (!comboBox.isEditable()) {
			int x = (int) myComboBox.getLocation().getX();
			int y = (int) myComboBox.getLocation().getY();
			g2.setFont(new Font("黑体", Font.PLAIN, 15));
			g2.drawString(myComboBox.getSelectedItem() + "", 5, 18);
		}


	}
	@Override
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		Font oldFont = comboBox.getFont();
		comboBox.setFont(new Font("宋体", Font.BOLD, 15));
		super.paintCurrentValue(g, bounds, hasFocus);
		comboBox.setFont(oldFont);
	}
	@Override
	public Dimension getPreferredSize(JComponent c) {
		return super.getPreferredSize(c);
	}

	public boolean isBoundsLight() {
		return boundsLight;
	}

	public void setBoundsLight(boolean boundsLight) {
		this.boundsLight = boundsLight;
	}
	@Override
	protected ComboPopup createPopup() {
		ComboPopup popup = new BasicComboPopup(comboBox) {
			protected JScrollPane createScroller() {
				MyScrollPane sp = new MyScrollPane(list,
						ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				sp.setHorizontalScrollBar(null);
				return sp;
			}

			// 重载paintBorder方法 来画出我们想要的边框..
			public void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.BLACK);
				g2.drawRoundRect(0, -arrow.getHeight(), getWidth() - 1,
						getHeight() + arrow.getHeight() - 1, 0, 0);
			}
		};
		return popup;
	}
}
