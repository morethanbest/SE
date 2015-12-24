package presentation.managerui.examui;

import java.awt.CardLayout;

import javax.swing.JPanel;

import presentation.managerui.examui.examcentersalesmanui.ArrivalExamPanel;
import presentation.managerui.examui.examcentersalesmanui.ArrivalRevisePanel;
import presentation.managerui.examui.examcentersalesmanui.CenterLoadExamPanel;
import presentation.managerui.examui.examcentersalesmanui.CenterLoadRevisePanel;
import presentation.managerui.examui.examcentersalesmanui.TransferExamPanel;
import presentation.managerui.examui.examcentersalesmanui.TransferRevisePanel;
import presentation.managerui.examui.examcourierui.OrderExamPanel;
import presentation.managerui.examui.examcourierui.OrderRevisePanel;
import presentation.managerui.examui.examdepotui.StockinExamPanel;
import presentation.managerui.examui.examdepotui.StockinRevisePanel;
import presentation.managerui.examui.examdepotui.StockoutExamPanel;
import presentation.managerui.examui.examdepotui.StockoutRevisePanel;
import presentation.managerui.examui.examfinancial.RecordpayExamPanel;
import presentation.managerui.examui.examfinancial.RecordpayRevisePanel;
import presentation.managerui.examui.examhallsalesmanui.DeliveryExamPanel;
import presentation.managerui.examui.examhallsalesmanui.DeliveryRevisePanel;
import presentation.managerui.examui.examhallsalesmanui.GoodRecievingExamPanel;
import presentation.managerui.examui.examhallsalesmanui.GoodRecievingRevisePanel;
import presentation.managerui.examui.examhallsalesmanui.HallLoadExamPanel;
import presentation.managerui.examui.examhallsalesmanui.HallLoadRevisePanel;
import presentation.managerui.examui.examhallsalesmanui.RecordcollectExamPanel;
import presentation.managerui.examui.examhallsalesmanui.RecordcollectRevisePanel;


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
		setOpaque(false);
		ExamSelectPanel select = new ExamSelectPanel(this, card);
		//中转中心业务员
		ArrivalRevisePanel arrivalR = new ArrivalRevisePanel(this, card);
		arrival = new ArrivalExamPanel(this, card, arrivalR);
		TransferRevisePanel transR = new TransferRevisePanel(this, card);
		trans = new TransferExamPanel(this, card, transR);
		CenterLoadRevisePanel clR = new CenterLoadRevisePanel(this, card);
		cl = new CenterLoadExamPanel(this, card, clR);
		//营业厅业务员
		HallLoadRevisePanel hlR = new HallLoadRevisePanel(this, card);
		hl = new HallLoadExamPanel(this, card, hlR);
		GoodRecievingRevisePanel grR = new GoodRecievingRevisePanel(this, card);
		gr = new GoodRecievingExamPanel(this, card, grR);
		DeliveryRevisePanel deliveryR = new DeliveryRevisePanel(this, card);
		delivery = new DeliveryExamPanel(this, card, deliveryR);
		RecordcollectRevisePanel collectR = new RecordcollectRevisePanel(this, card);
		collect=new RecordcollectExamPanel(this, card, collectR);
		//快递员
		OrderRevisePanel orderR = new OrderRevisePanel(this, card);
		order = new OrderExamPanel(this, card, orderR);
		//仓库管理员
		StockinRevisePanel inR = new StockinRevisePanel(this, card);
		in = new StockinExamPanel(this, card, inR);
		StockoutRevisePanel outR = new StockoutRevisePanel(this, card);
		out = new StockoutExamPanel(this, card, outR);
		//财务人员
		RecordpayRevisePanel payR = new RecordpayRevisePanel(this, card);
		pay= new RecordpayExamPanel(this, card, payR);
		
		add(select, "select");
		
		add(arrival, "arrival");
		add(arrivalR, "arrivalR");
		add(trans, "trans");
		add(transR, "transR");
		add(cl, "cl");
		add(clR, "clR");

		add(hl, "hl");
		add(hlR, "hlR");
		add(gr, "gr");
		add(grR, "grR");
		add(delivery, "delivery");
		add(deliveryR, "deliveryR");
		add(collect, "collect");
		add(collectR, "collectR");
		
		add(order, "order");
		add(orderR, "orderR");
		
		add(in, "in");
		add(inR, "inR");
		add(out, "out");
		add(outR, "outR");
		
		add(pay, "pay");
		add(payR, "payR");
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
