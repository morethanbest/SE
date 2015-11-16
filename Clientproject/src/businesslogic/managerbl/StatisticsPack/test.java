package businesslogic.managerbl.StatisticsPack;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vo.DebitnoteVO;
import vo.RecordpayVO;
import vo.StatisticsVO;
public class test {
	@Test
	public void testStatistics(){
		List<RecordpayVO> list1=new ArrayList<RecordpayVO>();
		List<DebitnoteVO> list2=new ArrayList<DebitnoteVO>();
		list1.add(new RecordpayVO(20151021, 100, "ss", 100, 0, 0, 0, 0, ""));
		list2.add(new DebitnoteVO(20150112, "", "", "", 100, null));
		StatisticsVO vo=new StatisticsVO(20150101, 20150102, list1, list2);
		Statistics statistics=new Statistics(20150101, 20150102);
		StatisticsVO vo2=statistics.getStatistics();
		assertEquals(vo.getList1().get(0).getPaysum(), vo2.getList1().get(0).getPaysum());
	}

}
