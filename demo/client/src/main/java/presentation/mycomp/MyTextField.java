package presentation.mycomp;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class MyTextField extends JTextField {
	
	private static final int CORNER = 4;

	JPanel parent;
	public MyTextField(){
		super();
		init();
	}
	public MyTextField(String str){
		super(str);
		init();
	}
	
	public MyTextField(int cols){
		super(cols);
		init();
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		int a = x;
		int b = y;
		int c = width;
		int d = height;
		addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorAdded(AncestorEvent event) {
				Container p =  getParent();
				p.add(new MyTextLabel(a, b, c, d));
				p.repaint();
			}
		});
		x += CORNER + 2; width -= 2 * CORNER;
		super.setBounds(x, y, width, height);
	}
	
	
	private void init(){
		setOpaque(false);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setFont(new Font("黑体", Font.PLAIN, 15));
		setCaretColor(Color.GRAY);
		
	}
}