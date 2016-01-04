package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;
import po.Formstate;
import po.ResultMessage;
import vo.DeliveryExamVO;
import vo.DeliveryVO;

public interface ExamDeliverys {
	public List<DeliveryVO> getDeliveryForm (Formstate state);

	public ResultMessage updateDeliveryForm (DeliveryVO vo);

}
