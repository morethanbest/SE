package presentation.managerui.examui;

import java.awt.CardLayout;

import javax.swing.JPanel;

import presentation.managerui.examui.examcentersalesmanui.ArrivalExamPanel;
import presentation.managerui.examui.examcentersalesmanui.CenterLoadExamPanel;
import presentation.managerui.examui.examcentersalesmanui.TransferExamPanel;
import presentation.managerui.examui.examcourierui.OrderExamPanel;
<<<<<<< HEAD
import presentation.managerui.examui.examdepotui.StockinExamPanel;
=======
import presentation.managerui.examui.examfinancial.RecordpayExamPanel;
>>>>>>> origin/master

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
<<<<<<< HEAD
		StockinExamPanel in = new StockinExamPanel(this, card);
=======
		RecordpayExamPanel pay= new RecordpayExamPanel(this, card);
>>>>>>> origin/master
		
		add(select, "select");
		add(arrival, "arrival");
		add(trans, "trans");
		add(cl, "cl");
		add(order, "order");
<<<<<<< HEAD
		add(in, "in");
=======
		add(pay, "pay");
>>>>>>> origin/master
	}

}
