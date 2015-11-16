package businesslogic.managerbl.ExamPack;

import java.util.List;

import vo.ArrivalExamVO;
import vo.ResultMessage;

public class ExamArrivals {
	MockGetArrivals mockGetArrivals;
	MockSetArrivals mockSetArrivals;
	
	public ExamArrivals(MockGetArrivals mockGetArrivals){
		this.mockGetArrivals=mockGetArrivals;
	}
	
	public ExamArrivals(MockSetArrivals mockSetArrivals){
		this.mockSetArrivals=mockSetArrivals;
	}
	
	public List<ArrivalExamVO> GetArrivals(){
		List<ArrivalExamVO> l=mockGetArrivals.getArrivals();
		return l;
	}
	
	public ResultMessage setArrivals(List<ArrivalExamVO> volist){
		ResultMessage result=mockSetArrivals.exam(volist);
		return result;
	}
}
