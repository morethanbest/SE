package businesslogic.managerbl.ConstantsPack;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.managerdata.ConstantsData;
import dataservice.managerdataservice.ConstantsDataService;
import po.ConstantsPO;
import vo.ConstantsVO;

public class FindConstants {

	String name;
	
	public void setFindInfo(String name){
		this.name=name;
	}
	public ConstantsVO findConstants() throws RemoteException{
		ConstantsDataService constants=new ConstantsData();
		ConstantsPO po=constants.findConstants(name);
		if(po==null){
			return null;
		}
		double value=po.getValue();
		String name=po.getName();
		ConstantsVO vo=new ConstantsVO(name,value);
		return vo;
	}
	public List<ConstantsVO> fuzzyfindConstants() throws RemoteException{
		ConstantsDataService constants=new ConstantsData();
		List<ConstantsPO> listpo=constants.fuzzyfindConstants(name);
		List<ConstantsVO> listvo=new ArrayList<ConstantsVO>();
		for(int i=0;i<listpo.size();i++){
			ConstantsPO po=listpo.get(i);
			double value=po.getValue();
			String name=po.getName();
			ConstantsVO vo=new ConstantsVO(name,value);
			listvo.add(i,vo);
		}
		return listvo;
		
	}
}
