package presentation.mycomp.mycombobox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	public IComboBoxUI() {
		super();
	}
//下箭头按钮
	protected JButton createArrowButton() {
		arrow = new JButton();
		ImageIcon increase = new ImageIcon("img/DarkDownArrow.png");
//		arrow.setIcon(increase);
		arrow.setRolloverEnabled(true);
		arrow.setRolloverIcon(increase);
		arrow.setBorder(null);
		arrow.setBackground(SystemColor.inactiveCaptionBorder);
		arrow.setOpaque(false);
		arrow.setContentAreaFilled(false);
		return arrow;
	}

	public void paint(Graphics g, JComponent c) {
		hasFocus = comboBox.hasFocus();
		Graphics2D g2 = (Graphics2D) g;
		if (!comboBox.isEditable()) {
			Rectangle r = rectangleForCurrentValue();
			// 重点:JComboBox的textfield 的绘制 并不是靠Renderer来控制 这点让我很吃惊.
			// 它会通过paintCurrentValueBackground来绘制背景
			// 然后通过paintCurrentValue();去绘制JComboBox里显示的值
			paintCurrentValueBackground(g2, r, hasFocus);
			paintCurrentValue(g2, r, hasFocus);
		}

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int width = c.getWidth()
				 - 2;
		int height = 0;
		int heightOffset = 0;
		ImageIcon increase = new ImageIcon("img/DarkDownArrow.png");
		if (comboBox.isPopupVisible()) {
			heightOffset = 5;
			height = c.getHeight();
			arrow.setIcon(increase);
		} else {
			heightOffset = 0;
			height = c.getHeight() - 1;
			arrow.setIcon(increase);
		}
		if (comboBox.isFocusable()) {
			g2.setColor(Color.BLACK);
		}
		g2.drawRoundRect(0, 0, width, height + heightOffset, ARCWIDTH,
				ARCHEIGHT);
	}

	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		Font oldFont = comboBox.getFont();
		comboBox.setFont(new Font("宋体", Font.BOLD, 15));

		super.paintCurrentValue(g, bounds, hasFocus);
		comboBox.setFont(oldFont);
	}

	public Dimension getPreferredSize(JComponent c) {
		return super.getPreferredSize(c);
	}

	public boolean isBoundsLight() {
		return boundsLight;
	}

	public void setBoundsLight(boolean boundsLight) {
		this.boundsLight = boundsLight;
	}

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
				g2.setColor(new Color(150, 207, 254));
				g2.drawRoundRect(0, -arrow.getHeight(), getWidth() - 1,
						getHeight() + arrow.getHeight() - 1, 0, 0);
			}
		};
		return popup;
	}
}