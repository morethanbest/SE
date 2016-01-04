package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;
import vo.RecordtranExamVO;
import vo.RecordtransVO;

public interface ExamRecordtrans {
	public List<RecordtransVO> getRecordtransForm (Formstate state);

	public ResultMessage updateRecordtransForm (RecordtransVO vo);

}
