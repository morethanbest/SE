package businesslogic.managerbl.ExamPack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import po.Formstate;
import vo.ArrivalExamVO;
import vo.ResultMessage;

public class test {
	@Test
	public void testGetArrivals(){
		MockGetArrivals mockget=new MockGetArrivals();
		ExamArrivals examArrivals=new ExamArrivals(mockget);
		List<ArrivalExamVO> lv=examArrivals.GetArrivals();
		
		assertEquals(Formstate.waiting,lv.get(0).getDocumentstate());
	}
	@Test
	public void testSetArrivals(){
		MockSetArrivals mockset=new MockSetArrivals();
		ExamArrivals examArrivals=new ExamArrivals(mockset);
		List<ArrivalExamVO> lv=new ArrayList<ArrivalExamVO>();
		ResultMessage result=examArrivals.setArrivals(lv);
		assertEquals(ResultMessage.success,result);
	}
	
}
