package businesslogic.managerbl.SalaryPack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.Job;
import po.SalaryMode;
import vo.ResultMessage;
import vo.SalaryVO;
import vo.StaffVO;

public class test {
	@Test
	public void testadd(){
		SalaryVO vo=new SalaryVO(Job.Courier,SalaryMode.chargebytimes,5,4);
		MockAddSalary adds=new MockAddSalary();
		MockIdInfo id=new MockIdInfo(5);
		Salary s=new Salary(adds,id);
		ResultMessage result=s.addSalary(vo);
		
		assertEquals(ResultMessage.success,result);
	}
	@Test
	public void testDel(){
		SalaryVO vo=new SalaryVO(Job.Courier,SalaryMode.chargebytimes,5,4);
		MockDelSalary dels=new MockDelSalary();
		Salary s=new Salary(dels); 
		ResultMessage result=s.delSalary(vo);
		assertEquals(ResultMessage.success,result);
	}
	@Test
	public void testRev(){
		SalaryVO vo=new SalaryVO(Job.Courier,SalaryMode.chargebytimes,5,4);
		MockRevSalary revs=new MockRevSalary();
		Salary s= new Salary(revs);
		ResultMessage result=s.revSalary(vo);
		assertEquals(ResultMessage.success,result);
	}
	@Test
	public void testFind(){
		Job job=Job.Courier;
		MockFindSalary finds=new MockFindSalary();
		Salary s=new Salary(finds);
		SalaryVO vo=s.findSalary(job);
		assertEquals(job,vo.getJob());
	}
}

