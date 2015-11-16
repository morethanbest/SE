//package Bldriver;
//
//import java.rmi.RemoteException;
//
//import businesslogic.managerbl.stub.SalaryBlService_Stub;
//import businesslogicservice.managerblservice.SalaryBlService;
//import po.Job;
//import po.SalaryMode;
//import vo.ResultMessage;
//import vo.SalaryVO;
//
//public class Salary_Driver {
//	public void driver(SalaryBlService SalaryBlservice){
//		try{
//			ResultMessage result=SalaryBlservice.salary(new SalaryVO(Job.Courier,SalaryMode.chargebytimes,1,1));
//			if(result==ResultMessage.success)
//				System.out.println("Rev successfully");
//			
//		}catch(RemoteException e){
//			e.printStackTrace();
//		}
//	}
//	public static void main(String[] args){
//		SalaryBlService salarybl=new SalaryBlService_Stub();
//		Salary_Driver driver=new Salary_Driver();
//		driver.driver(salarybl);
//	}
//}
