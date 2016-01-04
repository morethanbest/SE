package businesslogic.commoditybl.StockExaminationPack;

import java.util.ArrayList;
import java.util.List;

import po.CommodityLocation;
import po.CommodityPO;
import vo.CommodityExamVO;
import vo.CommodityTakingVO;
import vo.StockExaminationVO;

public class StockExamination {
	Exam getter;
	getPara para;
	public StockExamination(Exam getter,getPara para) {
		// TODO Auto-generated constructor stub
		this.getter=getter;
		this.para=para;
	}
	
	public StockExaminationVO examhandle(String orgcode,long startTime, long endTime){
		List<Long> nums=para.getSomeNum(orgcode,startTime,endTime);
		List<CommodityPO> pos=getter.getlist(orgcode,startTime,endTime);

		List<CommodityExamVO> examvos=new ArrayList<CommodityExamVO>();

		for(int i=0;i<=pos.size()-1;i++){
			CommodityPO po=pos.get(i);
			String ordercode=po.getOrdercode();
			CommodityLocation location=po.getLocation();
			CommodityExamVO newvo=new CommodityExamVO(ordercode,location);
			examvos.add(newvo);
		}


		StockExaminationVO result=new StockExaminationVO(startTime,endTime, nums.get(0),nums.get(1),nums.get(2),examvos);
		return result;

	}

}
