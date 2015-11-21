package businesslogic.managerbl.StaffPack;

import java.rmi.RemoteException;
import java.util.List;

import po.Job;
import vo.ResultMessage;
import vo.StaffVO;

public class Staff {
	AddStaff adds;
	DelStaff dels;
	FindStaff finds;
	RevStaff revs;
	
	public Staff(AddStaff adds){
		this.adds=adds;
	}
	
	public Staff(DelStaff dels){
		this.dels=dels;
	}
	
	public Staff(FindStaff finds){
		this.finds=finds;
	}
	
	public Staff(RevStaff revs){
		this.revs=revs;
		
	}
	
	public ResultMessage addStaff(StaffVO vo) throws RemoteException{
		long id=vo.getId();
		String name=vo.getName();
		Job job=vo.getJob();
		adds.setAddInfo(id, name, job);
		ResultMessage result=adds.addStaff();
		return result;
		
	}
	
	public ResultMessage delStaff(StaffVO vo) throws RemoteException{
		long id=vo.getId();
		dels.setDelInfo(id);
		ResultMessage result=dels.delete();
		return result;
	}
	
	public List<StaffVO> findStaff(String name) throws RemoteException{
		finds.setFindInfo(name);
		List<StaffVO> listvo=finds.fuzzyfindStaff();
		return listvo;
	}
	
	public List<StaffVO> findStaffbyJob(Job job) throws RemoteException{
		finds.setFindInfo(job);
		List<StaffVO> listvo=finds.fuzzyfindStaffbyJob();
		return listvo;
	}
	
	public List<StaffVO> findStaffbyBoth(String name,Job job) throws RemoteException{
		finds.setFindInfo(name,job);
		List<StaffVO> listvo=finds.fuzzyfindStaffbyboth();
		return listvo;
	}
	
	public ResultMessage revStaff(StaffVO vo) throws RemoteException{
		long id=vo.getId();
		String name=vo.getName();
		Job job=vo.getJob();
		revs.setRevInfo(id,name, job);
		ResultMessage result=revs.rev();
		return result;
	}
}
