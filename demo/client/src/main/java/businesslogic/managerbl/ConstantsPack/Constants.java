package businesslogic.managerbl.ConstantsPack;

import java.util.List;

import po.ResultMessage;
import vo.ConstantsVO;

public class Constants {
	AddConstants addc;
    DelConstants delc;
	FindConstants findc;
	RevConstants revc;
	IdInfo id;
	
	public Constants(AddConstants addc,IdInfo id){
		this.addc=addc;
		this.id=id;
	}
	
	public Constants(DelConstants delc){
		this.delc=delc;
	}
	
	public Constants(FindConstants findc){
		this.findc=findc;
	}
	
	public Constants(RevConstants revc){
		this.revc=revc;
		
	}
	
	public ResultMessage addConstants(ConstantsVO vo){
		String name=vo.getName();
		double value=vo.getValue();
		long id=this.id.getid();
		addc.setAddInfo(id, name, value);
		ResultMessage result=addc.addConstants();
		String[] splits=name.split("-");
		if(splits[0].equals("距离")){
			name=splits[0]+"-"+splits[2]+"-"+splits[1];
			addc.setAddInfo(id+1, name, value);
			addc.addConstants();
		}
		return result;
		
	}
	
	public ResultMessage delConstants(ConstantsVO vo){
		String name=vo.getName();
		double value=vo.getValue();
		delc.setDelInfo(name, value);
		ResultMessage result=delc.delete();
		String[] splits=name.split("-");
		if(splits[0].equals("距离")){
			name=splits[0]+"-"+splits[2]+"-"+splits[1];
			delc.setDelInfo(name, value);
			delc.delete();
		}
		return result;
	}
	
	public List<ConstantsVO> fuzzyfindConstants(String name){
		findc.setFindInfo(name);
		List<ConstantsVO> listvo=findc.fuzzyfindConstants();
		return listvo;
	}
	
	public ResultMessage revConstants(ConstantsVO vo){
		String name=vo.getName();
		double value=vo.getValue();
		revc.setRevInfo(name, value);
		ResultMessage result=revc.rev();
		String[] splits=name.split("-");
		if(splits[0].equals("距离")){
			name=splits[0]+"-"+splits[2]+"-"+splits[1];
			revc.setRevInfo(name, value);
			revc.rev();
		}
		return result;
	}
}
