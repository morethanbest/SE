package businesslogic.commoditybl.StockExaminationPack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import po.City;
import po.CommodityLocation;
import vo.CommodityOutVO;
import vo.StockExaminationVO;

public class test {

	@Test
	public void test() {
		long starttime=20140118;
		long endtime=20140120;
		
		
		long stockoutnum=30;
		long stockinnum=17;
		long moneyin=200000;
		long moneyout=150000;
		long allstocknum=15000;
		List<CommodityOutVO> list=new ArrayList<CommodityOutVO>();
		CommodityLocation loca=new CommodityLocation(1,1,1,1);
		CommodityOutVO infovo=new CommodityOutVO("0122005",20140119,-1, loca,City.Guangzhou);
		list.add(infovo);
		
		
		FormGetterMock formget=new FormGetterMock(list,stockoutnum,stockinnum,moneyin,moneyout,allstocknum);///修改传入参数
		StockExamination exam=new StockExamination(formget);
		StockExaminationVO vos=exam.examhandle(starttime, endtime);
		List<CommodityOutVO> aolist=vos.getList();
		for(int i=0;i<=aolist.size()-1;i++){
			assertEquals(aolist.get(i).getOutTime(),-1);
		}
		
	}

}
