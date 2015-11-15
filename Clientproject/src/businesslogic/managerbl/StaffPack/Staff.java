package businesslogic.managerbl.StaffPack;

import po.Job;
import vo.ResultMessage;
import vo.StaffVO;

public class Staff {
	MockAddStaff adds;
	MockDelStaff dels;
	MockFindStaff finds;
	MockRevStaff revs;
	MockIdInfo id;
	
	public Staff(MockAddStaff adds,MockIdInfo id){
		this.adds=adds;
		this.id=id;
	}
	
	public Staff(MockDelStaff dels){
		this.dels=dels;
	}
	
	public Staff(MockFindStaff finds){
		this.finds=finds;
	}
	
	public Staff(MockRevStaff revs){
		this.revs=revs;
		
	}
	
	public ResultMessage addStaff(StaffVO vo){
		String name=vo.getName();
		Job job=vo.getJob();
		long id=this.id.getid();
		adds.setAddInfo(id, name, job);
		ResultMessage result=adds.addStaff();
		return result;
		
	}
	
	public ResultMessage delStaff(StaffVO vo){
		String name=vo.getName();
		Job job=vo.getJob();
		dels.setDelInfo(name, job);
		ResultMessage result=dels.delete();
		return result;
	}
	
	public StaffVO findStaff(String name){
		finds.setFindInfo(name);
		StaffVO vo=finds.findStaff();
		return vo;
	}
	
	public ResultMessage revStaff(StaffVO vo){
		String name=vo.getName();
		Job job=vo.getJob();
		revs.setRevInfo(name, job);
		ResultMessage result=revs.rev();
		return result;
	}
}
