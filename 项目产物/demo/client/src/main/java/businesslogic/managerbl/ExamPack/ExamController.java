package businesslogic.managerbl.ExamPack;

import java.rmi.RemoteException;
import java.util.List;

import businesslogicservice.managerblservice.ExamBlService;
import po.Formstate;
import vo.*;
import po.ResultMessage;

public class ExamController implements ExamBlService {


	@Override
	public List<ArrivalVO> getArrivalForm(Formstate state) {
		ArrivalExam exam=new ArrivalExam();
		List<ArrivalVO> vos=exam.find(state);
		return vos;
	}

	@Override
	public ResultMessage updateArrivalForm(ArrivalVO vo) {
		ArrivalExam exam=new ArrivalExam();
		ResultMessage result=exam.update(vo);
		return result;
	}

	@Override
	public List<CenterloadVO> getCenterLoadForm(Formstate state) {
		CenterLoadExam exam=new CenterLoadExam();
		List<CenterloadVO> list=exam.find(state);
		return list;
	}

	@Override
	public ResultMessage updateCenterLoadForm(CenterloadVO vo) {
		CenterLoadExam exam=new CenterLoadExam();
		ResultMessage result=exam.update(vo);
		return result;
	}



	@Override
	public List<DeliveryVO> getDeliveryForm(Formstate state) {
		DeliveryExam exam=new DeliveryExam();
		List<DeliveryVO> list=exam.find(state);
		return list;
	}

	@Override
	public ResultMessage updateDeliveryForm(DeliveryVO vo) {
		DeliveryExam exam=new DeliveryExam();
		ResultMessage result=exam.update(vo);
		return result;

	}

	@Override
	public List<GoodsReceivingVO> getGoodsReceivingForm(Formstate state) {
		GoodsRevExam exam=new GoodsRevExam();
		List<GoodsReceivingVO> list=exam.find(state);
		return list;
	}

	@Override
	public ResultMessage updateGoodsReceivingForm(GoodsReceivingVO vo) {
		GoodsRevExam exam=new GoodsRevExam();
		ResultMessage result=exam.update(vo);
		return result;
	}

	@Override
	public List<HallLoadVO> getLoadForm(Formstate state) {
		HallLoadExam exam=new HallLoadExam();
		List<HallLoadVO> vos=exam.find(state);
		return vos;
	}

	@Override
	public ResultMessage updateLoadForm(HallLoadVO vo) {
		HallLoadExam exam=new HallLoadExam();
		ResultMessage result=exam.update(vo);
		return result;
	}

	@Override
	public List<StockinVO> getStockinForm(Formstate state) {
		StockinExam exam=new StockinExam();
		List<StockinVO> list=exam.find(state);
		return list;
	}

	@Override
	public ResultMessage updateStockinForm(StockinVO vo) {
		StockinExam exam=new StockinExam();
		ResultMessage result=exam.update(vo);
		return result;
	}

	@Override
	public List<OrderVO> getOrderForm(Formstate state) {
		OrderExam exam=new OrderExam();
		List<OrderVO> list=exam.find(state);
		return list;
	}

	@Override
	public ResultMessage updateOrderForm(OrderVO vo) {
		OrderExam exam=new OrderExam();
		ResultMessage result=exam.update(vo);
		return result;
	}

	@Override
	public List<RecordcollectVO> getRecordcollectForm(Formstate statee) {
		RecordcollectExam exam=new RecordcollectExam();
		List<RecordcollectVO> list=exam.find(statee);
		return list;
	}

	@Override
	public ResultMessage updateRecordcollectForm(RecordcollectVO vo) {
		RecordcollectExam exam=new RecordcollectExam();

		ResultMessage result=exam.update(vo);
		return result;
	}



	@Override
	public List<RecordpayVO> getRecordpayForm(Formstate state) {
		RecordpayExam exam=new RecordpayExam();
		List<RecordpayVO> list=exam.find(state);
		return list;
	}

	@Override
	public ResultMessage updateRecordpayForm(RecordpayVO vo) {
		RecordpayExam exam=new RecordpayExam();
		ResultMessage result=exam.update(vo);
		return result;
	}

	@Override
	public List<RecordtransVO> getRecordtransForm(Formstate state) {
		RecordtransExam exam=new RecordtransExam();
		List<RecordtransVO> list=exam.find(state);
		return list;
	}

	@Override
	public ResultMessage updateRecordtransForm(RecordtransVO vo) {
		RecordtransExam exam=new RecordtransExam();
		ResultMessage result=exam.update(vo);
		return result;
	}

	@Override
	public List<StockoutVO> getStockoutForm(Formstate state) {
		StockoutExam exam=new StockoutExam();
		List<StockoutVO> list=exam.find(state);
		return list;
	}

	@Override
	public ResultMessage updateStockoutForm(StockoutVO vo) {
		StockoutExam exam=new StockoutExam();
		ResultMessage result=exam.update(vo);
		return  result;
	}
}
