package presentation.managerui.examui;

import java.awt.CardLayout;

import javax.swing.JPanel;

import presentation.managerui.examui.examcentersalesmanui.ArrivalExamPanel;
import presentation.managerui.examui.examcentersalesmanui.CenterLoadExamPanel;
import presentation.managerui.examui.examcentersalesmanui.TransferExamPanel;
import presentation.managerui.examui.examcourierui.OrderExamPanel;
import presentation.managerui.examui.examdepotui.StockinExamPanel;
import presentation.managerui.examui.examdepotui.StockoutExamPanel;
import presentation.managerui.examui.examfinancial.RecordpayExamPanel;
import presentation.managerui.examui.examhallsalesmanui.DeliveryExamPanel;
import presentation.managerui.examui.examhallsalesmanui.GoodRecievingExamPanel;
import presentation.managerui.examui.examhallsalesmanui.HallLoadExamPanel;
import presentation.managerui.examui.examhallsalesmanui.RecordcollectExamPanel;


public class ExamPanel extends JPanel {

	private CardLayout card;
	
	/**
	 * Create the panel.
	 */
	public ExamPanel() {
		card = new CardLayout();
		setLayout(card);
		
		ExamSelectPanel select = new ExamSelectPanel(this, card);
		//中转中心业务员
		ArrivalExamPanel arrival = new ArrivalExamPanel(this, card);
		TransferExamPanel trans = new TransferExamPanel(this, card);
		CenterLoadExamPanel cl = new CenterLoadExamPanel(this, card);
		//营业厅业务员
		HallLoadExamPanel hl = new HallLoadExamPanel(this, card);
		GoodRecievingExamPanel gr = new GoodRecievingExamPanel(this, card);
		DeliveryExamPanel delivery = new DeliveryExamPanel(this, card);
		RecordcollectExamPanel collect=new RecordcollectExamPanel(this, card);
		//快递员
		OrderExamPanel order = new OrderExamPanel(this, card);
		//仓库管理员
		StockinExamPanel in = new StockinExamPanel(this, card);
		StockoutExamPanel out = new StockoutExamPanel(this, card);
		//财务人员
		RecordpayExamPanel pay= new RecordpayExamPanel(this, card);
		
		add(select, "select");
		
		add(arrival, "arrival");
		add(trans, "trans");
		add(cl, "cl");
		
		add(hl, "hl");
		add(gr, "gr");
		add(delivery, "delivery");
		add(collect, "collect");
		
		add(order, "order");
		
		add(in, "in");
		add(out, "out");
		
		add(pay, "pay");
	}

}
