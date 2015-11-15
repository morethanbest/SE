package Bldriver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogic.managerbl.stub.ExamArrivals_Stub;
import businesslogic.managerbl.stub.ExamCLForms_Stub;
import businesslogic.managerbl.stub.ExamDebitnotes_Stub;
import businesslogic.managerbl.stub.ExamDeliverys_Stub;
import businesslogic.managerbl.stub.ExamGoodsRecevings_Stub;
import businesslogic.managerbl.stub.ExamHLForms_Stub;
import businesslogic.managerbl.stub.ExamInbounds_Stub;
import businesslogic.managerbl.stub.ExamOrdersBlService_Stub;
import businesslogic.managerbl.stub.ExamRecordcollects_Stub;
import businesslogic.managerbl.stub.ExamRecordpays_Stub;
import businesslogic.managerbl.stub.ExamRecordtrans_Stub;
import businesslogic.managerbl.stub.ExamStockouts_Stub;
import businesslogicservice.managerblservice.ExamArrivals;
import businesslogicservice.managerblservice.ExamCLForms;
import businesslogicservice.managerblservice.ExamDebitnotes;
import businesslogicservice.managerblservice.ExamDeliverys;
import businesslogicservice.managerblservice.ExamGoodsRecevings;
import businesslogicservice.managerblservice.ExamHLForms;
import businesslogicservice.managerblservice.ExamInbounds;
import businesslogicservice.managerblservice.ExamOrdersBlService;
import businesslogicservice.managerblservice.ExamRecordcollects;
import businesslogicservice.managerblservice.ExamRecordpays;
import businesslogicservice.managerblservice.ExamRecordtrans;
import businesslogicservice.managerblservice.ExamStockouts;
import po.Arrivalstate;
import po.City;
import po.CommodityLocation;
import po.Hall;
import po.Loadform;
import po.Ordertype;
import vo.ArrivalExamVO;
import vo.CLFormsExamVO;
import vo.DebitnoteExamVO;
import vo.DeliveryExamVO;
import vo.GoodsRecevingExamVO;
import vo.HLFormsExamVO;
import vo.OrderExamVO;
import vo.RecordcollectExamVO;
import vo.RecordpayExamVO;
import vo.RecordtranExamVO;
import vo.ResultMessage;
import vo.StockinExamVO;
import vo.StockoutExamVO;

public class Examine_Driver {
	public void driver(ExamArrivals examArrivals,ExamCLForms examcl,ExamDebitnotes examdebit,ExamDeliverys examdeliverys,
			ExamGoodsRecevings examgoodsrecevings,ExamHLForms examhl,ExamInbounds examinbound,ExamOrdersBlService examorders,
			ExamRecordcollects examrecordcollects,ExamRecordpays examrecordpays,ExamRecordtrans examrecordtrans,ExamStockouts examstockouts){
		try{
			//test arrival
			List<ArrivalExamVO> l1=new ArrayList<ArrivalExamVO>();
			l1.add(new ArrivalExamVO("1",1,"1",Hall.Nanjing,Arrivalstate.intact));
			ResultMessage result=examArrivals.ArrivalsExam(l1);
			if(result==ResultMessage.success)
				System.out.println("Arrivals set");
			if(examArrivals.getArrivals()!=null){
				System.out.println("Arrivals get");
			}
			//test CL
			List<String> s=new ArrayList<String>();
			s.add("1");
			List<CLFormsExamVO> l2=new ArrayList<CLFormsExamVO>();
			l2.add(new CLFormsExamVO(1,"1",Hall.Nanjing,"1","1","1",s,1));
			result=examcl.CLFormsExam(l2);
			if(result==ResultMessage.success)
				System.out.println("CL set");
			if(examArrivals.getArrivals()!=null){
				System.out.println("CL get");
			}
			//test Debitnotes
			List<DebitnoteExamVO> l3=new ArrayList<DebitnoteExamVO>();
			l3.add(new DebitnoteExamVO(1,1,"1","1","1",1,"1"));
			result=examdebit.DebitnotesExam(l3);
			if(result==ResultMessage.success)
				System.out.println("Debitnotes set");
			if(examArrivals.getArrivals()!=null){
				System.out.println("Debitnotes get");
			}
			//test Deliverys
			List<DeliveryExamVO> l4=new ArrayList<DeliveryExamVO>();
			l4.add(new DeliveryExamVO(1,"1","1"));
			result=examdeliverys.DeliverysExam(l4);
			if(result==ResultMessage.success)
				System.out.println("Deliverys set");
			if(examdeliverys.getDeliverys()!=null){
				System.out.println("Deliverys get");
			}
			//test GoodsRecevings
			List<GoodsRecevingExamVO> l5=new ArrayList<GoodsRecevingExamVO>();
			l5.add(new GoodsRecevingExamVO(1,"1",Hall.Nanjing,Arrivalstate.broken));
			result=examgoodsrecevings.GoodsRecevingsExam(l5);
			if(result==ResultMessage.success)
				System.out.println("GoodsRecevings set");
			if(examgoodsrecevings.getGoodsRecevings()!=null){
				System.out.println("GoodsRecevings get");
			}
			//test HL
			List<HLFormsExamVO> l6=new ArrayList<HLFormsExamVO>();
			l6.add(new HLFormsExamVO(1,"1","1",Hall.Nanjing,"1","1","1",s,1));
			result=examhl.HLFormsExam(l6);
			if(result==ResultMessage.success)
				System.out.println("HL set");
			if(examhl.getHLForms()!=null){
				System.out.println("HL get");
			}
			//test Inbounds
			List<StockinExamVO> l7=new ArrayList<StockinExamVO>();
			l7.add(new StockinExamVO("1",1,new CommodityLocation(1,1,1,1),City.Beijing));
			result=examinbound.InboundsExam(l7);
			if(result==ResultMessage.success)
				System.out.println("Inbounds set");
			if(examinbound.getInbounds()!=null){
				System.out.println("Inbounds get");
			}
			//test Orders
			List<OrderExamVO> l8=new ArrayList<OrderExamVO>();
			l8.add(new OrderExamVO(1,"1","1","1","1","1","1","1","1","1","1",1,1,1,"1",1,1,"1",Ordertype.economical));
			result=examorders.OrdersExam(l8);
			if(result==ResultMessage.success)
				System.out.println("Orders set");
			if(examorders.getOrders()!=null){
				System.out.println("Orders get");
			}
			//test Recordcollects
			List<RecordcollectExamVO> l9=new ArrayList<RecordcollectExamVO>();
			l9.add(new RecordcollectExamVO(1,1,1,"a",s));
			result=examrecordcollects.RecordcollectsExam(l9);
			if(result==ResultMessage.success)
				System.out.println("Recordcollects set");
			if(examrecordcollects.getRecordcollects()!=null){
				System.out.println("Recordcollects get");
			}
			//test Recordpays
			List<RecordpayExamVO> l10=new ArrayList<RecordpayExamVO>();
			l10.add(new RecordpayExamVO(1,1,"1",1,1,1,1,1,"1"));
			result=examrecordpays.RecordpaysExam(l10);
			if(result==ResultMessage.success)
				System.out.println("Recordpays set");
			if(examrecordpays.getRecordpays()!=null){
				System.out.println("Recordpays get");
			}
			//test Recordtrans
			List<RecordtranExamVO> l11=new ArrayList<RecordtranExamVO>();
			l11.add(new RecordtranExamVO(1,1,"1","1",Hall.Nanjing,Hall.Nanjing1,"1","1",s,0));
			result=examrecordtrans.RecordtransExam(l11);
			if(result==ResultMessage.success)
				System.out.println("Recordtrans set");
			if(examrecordtrans.getRecordtrans()!=null){
				System.out.println("Recordtrans get");
			}
			//test Stockouts
			List<StockoutExamVO> l12=new ArrayList<StockoutExamVO>();
			l12.add(new StockoutExamVO(1,"1",1,Hall.Nanjing,Loadform.plane,"1","1"));
			result= examstockouts.StockoutsExam(l12);
			if(result==ResultMessage.success)
				System.out.println("Stockouts set");
			if( examstockouts.getStockouts()!=null){
				System.out.println("Stockouts get");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		ExamArrivals examArrivals=new ExamArrivals_Stub();
		Examine_Driver driver=new Examine_Driver();
		ExamCLForms examcl=new ExamCLForms_Stub();
		ExamDebitnotes examdebit=new ExamDebitnotes_Stub();
		ExamDeliverys examdeliverys=new ExamDeliverys_Stub();
		ExamGoodsRecevings examgoodsrecevings=new ExamGoodsRecevings_Stub();
		ExamHLForms examhl=new ExamHLForms_Stub();
		ExamInbounds examinbound=new ExamInbounds_Stub();
		ExamOrdersBlService examorders=new ExamOrdersBlService_Stub();
		ExamRecordcollects examrecordcollects=new ExamRecordcollects_Stub();
		ExamRecordpays examrecordpays=new ExamRecordpays_Stub();
		ExamRecordtrans examrecordtrans=new ExamRecordtrans_Stub();
		ExamStockouts examstockouts=new ExamStockouts_Stub();
		driver.driver(examArrivals,examcl,examdebit,examdeliverys,examgoodsrecevings,examhl,examinbound,examorders,examrecordcollects
				,examrecordpays,examrecordtrans,examstockouts);
	}
}
