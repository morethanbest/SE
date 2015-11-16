package businesslogic.managerbl.ExamPack;

import java.util.List;

import vo.ArrivalExamVO;
import vo.ResultMessage;

public class MockSetArrivals extends SetArrivals {
	public ResultMessage exam(List<ArrivalExamVO> volist){
		
		return ResultMessage.success;
	}
}
