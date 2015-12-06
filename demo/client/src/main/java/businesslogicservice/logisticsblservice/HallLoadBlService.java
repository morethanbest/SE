package businesslogicservice.logisticsblservice;

		import java.rmi.RemoteException;
		import java.util.List;

		import po.Formstate;
		import po.ResultMessage;
		import vo.HLFareVO;
		import vo.HallLoadVO;

public interface HallLoadBlService {
	public ResultMessage addHallLoadForm (HallLoadVO vo);

	public double computeHallLoadFare (List<String> allbarcode,String City1,String City2);

	public ResultMessage update(HallLoadVO vo);
	public List<HallLoadVO> findforms(Formstate state,String orgcode);
	public String getid(String orgcode, long date) ;


}
