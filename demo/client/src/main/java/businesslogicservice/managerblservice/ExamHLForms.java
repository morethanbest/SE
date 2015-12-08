package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.HallLoadPO;
import po.ResultMessage;
import vo.HLFormsExamVO;
import vo.HallLoadVO;

public interface ExamHLForms {
	public List<HallLoadVO> getLoadForm (Formstate state);

	public ResultMessage updateLoadForm(HallLoadVO vo);

}
