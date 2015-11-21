package businesslogic.managerbl.ConstantsPack;

import java.rmi.RemoteException;
import java.util.List;

import vo.ConstantsVO;
import vo.ResultMessage;

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
	
	public ResultMessage addConstants(ConstantsVO vo) throws RemoteException{
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
	
	public ResultMessage delConstants(ConstantsVO vo) throws RemoteException{
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
	
	public List<ConstantsVO> fuzzyfindConstants(String name) throws RemoteException{
		findc.setFindInfo(name);
		List<ConstantsVO> listvo=findc.fuzzyfindConstants();
		return listvo;
	}
	
	public ResultMessage revConstants(ConstantsVO vo) throws RemoteException{
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
