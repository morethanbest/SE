package businesslogic.managerbl.SearchAccountPack;

import po.AccountPO;
import vo.AccountVO;

public class MockSearchAccount extends SearchAccount {
	long id;
	public void setGetInfo(long id){
		this.id=id;
	}
	public AccountVO getAccountbyID(){
		// TODO Auto-generated method stub
		AccountPO po=new AccountPO(id, "sunchao", 0);
		String name=po.getAccountname();
		double sum=po.getAccountsum();
		AccountVO vo=new AccountVO(id, name, sum);
		return vo;
	}
}
