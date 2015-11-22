package businesslogic.managerbl.StaffPack;

import java.rmi.RemoteException;
import java.util.List;

import po.Job;
import businesslogicservice.managerblservice.StaffBlService;
import vo.ResultMessage;
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
	public List<StaffVO> getStaffbyName(String name){
		// TODO Auto-generated method stub
		FindStaff find=new FindStaff();
		Staff s=new Staff(find);
		List<StaffVO> result=s.findStaff(name);
		return result;
	}
	public List<StaffVO> getStaffbyJob(Job job){
		FindStaff find=new FindStaff();
		Staff s=new Staff(find);
		List<StaffVO> result=s.findStaffbyJob(job);
		return result;
	}
	public List<StaffVO> getStaffbyBoth(String name, Job job){
		FindStaff find=new FindStaff();
		Staff s=new Staff(find);
		List<StaffVO> result=s.findStaffbyBoth(name, job);
		return result;
	}

}
