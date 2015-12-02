package businesslogicservice.logisticsblservice;

		import java.rmi.RemoteException;
		import java.util.List;

		import po.Formstate;
		import po.ResultMessage;
		import vo.HLFareVO;
		import vo.HallLoadVO;

public interface HallLoadBlService {
	public ResultMessage addHallLoadForm (HallLoadVO vo)throws RemoteException;
	public double computeHallLoadFare (HallLoadVO vo,String City1,String City2,String transporttype)throws RemoteException;
	public ResultMessage update(HallLoadVO vo)throws RemoteException;
	public List<HallLoadVO> findforms(Formstate state,String orgcode) throws RemoteException;
	public String getid(String orgcode, long date) throws  RemoteException;


}
