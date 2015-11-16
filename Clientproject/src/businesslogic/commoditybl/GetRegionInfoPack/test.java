package businesslogic.commoditybl.GetRegionInfoPack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import po.CommodityLocation;
import vo.CommodityInVO;
import vo.RegionInfoVO;

public class test {

	@Test
	public void test() {
		long blocknum=1;
		List<CommodityInVO> list=new ArrayList<CommodityInVO>();
		CommodityLocation loc=new CommodityLocation(blocknum,1,1,2);
		CommodityInVO invo=new CommodityInVO("522244",20140214,loc);
		list.add(invo);
		
		RegionGetMock regiongetter=new RegionGetMock(list);//change
		GetRegionInfo regioninfo=new GetRegionInfo(regiongetter);
		RegionInfoVO vo=regioninfo.getinfo(blocknum);
		List<CommodityInVO> anolist=vo.getList();
		assertEquals(anolist.size(),1);
		System.out.println(anolist.size());
		for(int i=0;i<=anolist.size()-1;i++){
			assertEquals(anolist.get(i).getLocation().getBlocknum(),blocknum);
		}
	}

}
