package businesslogic.commoditybl.StockExaminationPack;

import java.rmi.RemoteException;

import vo.StockExaminationVO;
import businesslogicservice.commodityblservice.StockExaminationBlService;

public class StockExaminationController implements StockExaminationBlService{

	

	@Override
	public StockExaminationVO StockExamination(String orgcode,long startTime, long endTime)
			 {
		// TODO Auto-generated method stub
		Exam examer=new Exam();
		getPara para=new getPara();
		StockExamination exam=new StockExamination(examer,para);
		StockExaminationVO vos=exam.examhandle(orgcode,startTime, endTime);
		return vos;
	}

}
