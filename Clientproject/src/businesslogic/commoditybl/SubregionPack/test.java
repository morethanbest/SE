package businesslogic.commoditybl.SubregionPack;

import static org.junit.Assert.*;

import org.junit.Test;

import po.CommodityLocation;
import po.CommodityPO;
import vo.ResultMessage;

public class test {

	@Test
	public void test() {
		CommodityLocation beforeLocation=new CommodityLocation(4, 4, 6, 6);
		CommodityLocation afterLocation=new CommodityLocation(1,1,1,1);
		CommodityPO po=new CommodityPO(11,"001220",20130412,beforeLocation,20140121);
		SubRegionMock newmock=new SubRegionMock(po);
		Subregion subre=new Subregion(newmock);
		ResultMessage result=subre.sub(beforeLocation, afterLocation);
		assertEquals(result,ResultMessage.success);
	}

}
