package presentation.managerui.examui;

import java.awt.CardLayout;

import javax.swing.JPanel;

import presentation.managerui.examui.examcentersalesmanui.ArrivalExamPanel;

public class ExamPanel extends JPanel {

	private CardLayout card;
	
	/**
	 * Create the panel.
	 */
	public ExamPanel() {
		card = new CardLayout();
		setLayout(card);
		
		ExamSelectPanel select = new ExamSelectPanel(this,card);
		ArrivalExamPanel arrival = new ArrivalExamPanel(this,card);
		
		add(select, "select");
		add(arrival, "arrival");
	}

}
