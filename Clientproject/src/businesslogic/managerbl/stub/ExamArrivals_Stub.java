//package businesslogic.managerbl.stub;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.List;
//import po.Arrivalstate;
//import po.Hall;
//import businesslogicservice.managerblservice.ExamArrivals;
//import vo.ArrivalExamVO;
//import vo.ResultMessage;
//
//public class ExamArrivals_Stub implements ExamArrivals {
//
//	@Override
//	public List<ArrivalExamVO> getArrivals() throws RemoteException {
//		// TODO Auto-generated method stub
//		List<ArrivalExamVO> l=new ArrayList<ArrivalExamVO>();
//		l.add(new ArrivalExamVO("1",1,"1",Hall.Nanjing,Arrivalstate.intact));
//		return l;
//	}
//
//	@Override
//	public ResultMessage ArrivalsExam(List<ArrivalExamVO> volist) throws RemoteException {
//		// TODO Auto-generated method stub
//		return ResultMessage.success;
//	}
//
//}
