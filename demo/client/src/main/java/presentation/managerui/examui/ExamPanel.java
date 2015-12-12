package presentation.managerui.examui;

import java.awt.CardLayout;

import javax.swing.JPanel;

import presentation.managerui.examui.examcentersalesmanui.ArrivalExamPanel;
import presentation.managerui.examui.examcentersalesmanui.CenterLoadExamPanel;
import presentation.managerui.examui.examcentersalesmanui.TransferExamPanel;
import presentation.managerui.examui.examcourierui.OrderExamPanel;
import presentation.managerui.examui.examcourierui.OrderRevisePanel;
import presentation.managerui.examui.examdepotui.StockinExamPanel;
import presentation.managerui.examui.examdepotui.StockoutExamPanel;
import presentation.managerui.examui.examfinancial.RecordpayExamPanel;
import presentation.managerui.examui.examhallsalesmanui.DeliveryExamPanel;
import presentation.managerui.examui.examhallsalesmanui.GoodRecievingExamPanel;
import presentation.managerui.examui.examhallsalesmanui.HallLoadExamPanel;
import presentation.managerui.examui.examhallsalesmanui.RecordcollectExamPanel;


public class ExamPanel extends JPanel {

	private CardLayout card;
	
	private ArrivalExamPanel arrival;
	private TransferExamPanel trans;
	private CenterLoadExamPanel cl;
	
	private HallLoadExamPanel hl;
	private GoodRecievingExamPanel gr;
	private DeliveryExamPanel delivery;
	private RecordcollectExamPanel collect;
	
	private OrderExamPanel order;
	
	private StockinExamPanel in;
	private StockoutExamPanel out;
	
	private RecordpayExamPanel pay;
	/**
	 * Create the panel.
	 */
	public ExamPanel() {
		card = new CardLayout();
		setLayout(card);
		
		ExamSelectPanel select = new ExamSelectPanel(this, card);
		//中转中心业务员
		arrival = new ArrivalExamPanel(this, card);
		trans = new TransferExamPanel(this, card);
		cl = new CenterLoadExamPanel(this, card);
		//营业厅业务员
		hl = new HallLoadExamPanel(this, card);
		gr = new GoodRecievingExamPanel(this, card);
		delivery = new DeliveryExamPanel(this, card);
		collect=new RecordcollectExamPanel(this, card);
		//快递员
		OrderRevisePanel orderR = new OrderRevisePanel(this, card);
		order = new OrderExamPanel(this, card, orderR);
		//仓库管理员
		in = new StockinExamPanel(this, card);
		out = new StockoutExamPanel(this, card);
		//财务人员
		pay= new RecordpayExamPanel(this, card);
		
		add(select, "select");
		
		add(arrival, "arrival");
		add(trans, "trans");
		add(cl, "cl");
		
		add(hl, "hl");
		add(gr, "gr");
		add(delivery, "delivery");
		add(collect, "collect");
		
		add(order, "order");
		add(orderR, "orderR");
		
		add(in, "in");
		add(out, "out");
		
		add(pay, "pay");
	}
	
	public ArrivalExamPanel getArrival() {
		return arrival;
	}
	public TransferExamPanel getTrans() {
		return trans;
	}
	public CenterLoadExamPanel getCl() {
		return cl;
	}
	public HallLoadExamPanel getHl() {
		return hl;
	}
	public GoodRecievingExamPanel getGr() {
		return gr;
	}
	public DeliveryExamPanel getDelivery() {
		return delivery;
	}
	public RecordcollectExamPanel getCollect() {
		return collect;
	}
	public OrderExamPanel getOrder() {
		return order;
	}
	public StockinExamPanel getIn() {
		return in;
	}
	public StockoutExamPanel getOut() {
		return out;
	}
	public RecordpayExamPanel getPay() {
		return pay;
	}

}
