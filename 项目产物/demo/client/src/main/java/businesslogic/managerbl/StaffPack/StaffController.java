package businesslogic.managerbl.StaffPack;

import java.util.List;

import businesslogicservice.managerblservice.StaffBlService;
import po.Job;
import po.ResultMessage;
import vo.StaffVO;

public class StaffController implements StaffBlService {

	@Override
	public ResultMessage addStaff(StaffVO vo){
		// TODO Auto-generated method stub
		AddStaff adds=new AddStaff();
		Staff s=new Staff(adds);
		ResultMessage result=s.addStaff(vo);
		return result;
	}

	@Override
	public ResultMessage delStaff(StaffVO vo){
		// TODO Auto-generated method stub
		DelStaff dels=new DelStaff();
		Staff s=new Staff(dels);
		ResultMessage result=s.delStaff(vo);
		return result;
	}

	@Override
	public ResultMessage revStaff(StaffVO vo){
		// TODO Auto-generated method stub
		RevStaff revs=new RevStaff();
		Staff s=new Staff(revs);
		ResultMessage result=s.revStaff(vo);
		return result;
	}
	
	@Override
	public List<StaffVO> getStaffAll(){
		// TODO Auto-generated method stub
		FindStaff find=new FindStaff();
		Staff s=new Staff(find);
		List<StaffVO> result=s.getStaffAll();
		return result;
	}
	
	@Override
	public List<StaffVO> getStaffbyOrganization(String organizationcode){
		// TODO Auto-generated method stub
		FindStaff find=new FindStaff();
		Staff s=new Staff(find);
		List<StaffVO> result=s.findStaffbyOrganization(organizationcode);
		return result;
	}

	@Override
	public List<StaffVO> getStaffbyJob(Job job){
		FindStaff find=new FindStaff();
		Staff s=new Staff(find);
		List<StaffVO> result=s.findStaffbyJob(job);
		return result;
	}

	@Override
	public List<StaffVO> getStaffbyBoth(String organizationcode, Job job){
		FindStaff find=new FindStaff();
		Staff s=new Staff(find);
		List<StaffVO> result=s.findStaffbyBoth(organizationcode, job);
		return result;
	}
	
	@Override
	public long getid(){
		IdInfo idInfo=new IdInfo();
		Staff s=new Staff(idInfo);
		long id=s.getid();
		return id;
	}

}
