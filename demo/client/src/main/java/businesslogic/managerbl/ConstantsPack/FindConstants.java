package businesslogic.managerbl.ConstantsPack;

import java.util.ArrayList;
import java.util.List;

import dataservice.managerdataservice.ConstantsDataService;
import init.RMIHelper;
import po.ConstantsPO;
import vo.ConstantsVO;

public class FindConstants {

	String name;
	
	public void setFindInfo(String name){
		this.name=name;
	}
	public ConstantsVO findConstants(){
		ConstantsDataService constants=RMIHelper.getConstantsdata();
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
		ConstantsDataService constants=RMIHelper.getConstantsdata();
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
		if(name.equals("距离")){
			for(int i=0;i<listvo.size();i++){
				ConstantsVO vo1=listvo.get(i);
				String[] splits1=vo1.getName().split("-");
				String beforeadd1=splits1[1];
				String afteradd1=splits1[2];
				for(int j=0;j<i;j++){
					ConstantsVO vo2=listvo.get(j);
					String[] splits2=vo2.getName().split("-");
					String beforeadd2=splits2[1];
					String afteradd2=splits2[2];
					if(beforeadd1.equals(afteradd2)&&afteradd1.equals(beforeadd2)){
						listvo.remove(i);
						i--;
						break;
					}
				}

			}
		}
		return listvo;
		
	}
}
