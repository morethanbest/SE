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
	public ConstantsVO findConstants(){
		ConstantsDataService constants=new ConstantsData();
		ConstantsPO po;
		ConstantsVO vo;
		try {
			po = constants.findConstants(name);
			if(po==null){
				return null;
			}
			double value=po.getValue();
			String name=po.getName();
			vo=new ConstantsVO(name,value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vo=null;
			System.out.println("findconstants fail");
		}
	
		return vo;
	}
	public List<ConstantsVO> fuzzyfindConstants(){
		ConstantsDataService constants=new ConstantsData();
		List<ConstantsPO> listpo;
		List<ConstantsVO> listvo;
		try {
			listpo = constants.fuzzyfindConstants(name);
			listvo=new ArrayList<ConstantsVO>();
			for(int i=0;i<listpo.size();i++){
				ConstantsPO po=listpo.get(i);
				double value=po.getValue();
				String name=po.getName();
				ConstantsVO vo=new ConstantsVO(name,value);
				listvo.add(i,vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			listvo=null;
			System.out.println("fuzzyfindconstants fail");
		}
		
		return listvo;
		
	}
}
