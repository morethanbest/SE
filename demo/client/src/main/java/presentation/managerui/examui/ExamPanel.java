package presentation.managerui.examui;

import java.awt.CardLayout;

import javax.swing.JPanel;

import presentation.managerui.examui.examcentersalesmanui.ArrivalExamPanel;
import presentation.managerui.examui.examcentersalesmanui.CenterLoadExamPanel;
import presentation.managerui.examui.examcentersalesmanui.TransferExamPanel;
import presentation.managerui.examui.examcourierui.OrderExamPanel;
import presentation.managerui.examui.examdepotui.StockinExamPanel;

public class ExamPanel extends JPanel {

	private CardLayout card;
	
	/**
	 * Create the panel.
	 */
	public ExamPanel() {
		card = new CardLayout();
		setLayout(card);
		
		ExamSelectPanel select = new ExamSelectPanel(this, card);
		ArrivalExamPanel arrival = new ArrivalExamPanel(this, card);
		TransferExamPanel trans = new TransferExamPanel(this, card);
		CenterLoadExamPanel cl = new CenterLoadExamPanel(this, card);
		OrderExamPanel order = new OrderExamPanel(this, card);
		StockinExamPanel in = new StockinExamPanel(this, card);
		
		add(select, "select");
		add(arrival, "arrival");
		add(trans, "trans");
		add(cl, "cl");
		add(order, "order");
		add(in, "in");
	}

}
