package businesslogic.balancebl.DebitnotePack;

import java.rmi.RemoteException;
import java.util.List;

import businesslogic.managerbl.OrganizationPack.Organization;
import businesslogicservice.balanceblservice.DebitnoteBlService;
import vo.CityVO;
import vo.DebitnoteExamVO;
import vo.DebitnoteVO;
import vo.OrganizationVO;
import po.ResultMessage;


public class DebitnoteController implements DebitnoteBlService {



	@Override
	public List<CityVO> getALLCity()  {
		CityGet getter=new CityGet();
		List<CityVO> list=getter.getcity();
		return list;
	}

	@Override
	public List<OrganizationVO> getAllOrganization(String city)  {
		OrgGet getter=new OrgGet();
		List<OrganizationVO> list=getter.getorg(city);
		return list;
	}

	@Override
	public DebitnoteVO getRecordcollectbyhall(String orgcode) {
		HallCollect collect=new HallCollect();
		Debitnote deb=new Debitnote(collect);
		DebitnoteVO vo=deb.gethall(orgcode);
		return vo;
	}

	@Override
	public DebitnoteVO getRecordcollectbydate(long date){
		DateCollect collect=new DateCollect();
		Debitnote deb=new Debitnote(collect);
		DebitnoteVO vo=deb.getdate(date);
		return vo;
	}

	@Override
	public DebitnoteExamVO examcollect(DebitnoteVO vo) {
		DebitExam exam=new DebitExam();
		Debitnote det=new Debitnote(exam);

		DebitnoteExamVO result=det.debitexam(vo);
		return result;
	}
}
