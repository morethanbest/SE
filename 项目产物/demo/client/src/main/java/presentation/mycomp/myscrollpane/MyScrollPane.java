package presentation.mycomp.myscrollpane;

import java.awt.Component;

import javax.swing.JScrollPane;

public class MyScrollPane extends JScrollPane {
	
	public MyScrollPane(){
		super();
		getVerticalScrollBar().setUI(new IScrollBarUI());
	}
	
	public MyScrollPane(Component view, int vsbPolicy, int hsbPolicy){
		super(view, vsbPolicy, hsbPolicy);
		getVerticalScrollBar().setUI(new IScrollBarUI());
	}
}
