package businesslogic.managerbl.ConstantsPack;

import vo.ConstantsVO;
import vo.ResultMessage;

public class Constants {
	MockAddConstants addc;
	MockDelConstants delc;
	MockFindConstants findc;
	MockRevConstants revc;
	MockIdInfo id;
	
	public Constants(MockAddConstants addc,MockIdInfo id){
		this.addc=addc;
		this.id=id;
	}
	
	public Constants(MockDelConstants delc){
		this.delc=delc;
	}
	
	public Constants(MockFindConstants findc){
		this.findc=findc;
	}
	
	public Constants(MockRevConstants revc){
		this.revc=revc;
		
	}
	
	public ResultMessage addConstants(ConstantsVO vo){
		String name=vo.getName();
		double value=vo.getValue();
		long id=this.id.getid();
		addc.setAddInfo(id, name, value);
		ResultMessage result=addc.addConstants();
		return result;
		
	}
	
	public ResultMessage delConstants(ConstantsVO vo){
		String name=vo.getName();
		double value=vo.getValue();
		delc.setDelInfo(name, value);
		ResultMessage result=delc.delete();
		return result;
	}
	
	public ConstantsVO findConstants(String name){
		findc.setFindInfo(name);
		ConstantsVO vo=findc.findConstants();
		return vo;
	}
	
	public ResultMessage revConstants(ConstantsVO vo){
		String name=vo.getName();
		double value=vo.getValue();
		revc.setRevInfo(name, value);
		ResultMessage result=revc.rev();
		return result;
	}
}
