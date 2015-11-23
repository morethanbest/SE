package businesslogic.balancebl.RecordpayPack;

import po.Formstate;
import po.RecordpayPO;
import vo.ResultMessage;

public class MockRecord extends Record{
	long id;
	long paytime;
	double paysum;
	String payman;
	String payaccount;
	double rent;
	double fee;
	double salary;
	double reward;
	String remark;
	Formstate documentstate=Formstate.waiting;
	public void setRecordInfo(long id,long paytime,double paysum,String payman,String payaccount,
			double rent,double fee,double salary,double reward,String remark){
		this.id=id;
		this.paytime=paytime;
		this.paysum=paysum;
		this.payman=payman;
		this.payaccount=payaccount;
		this.rent=rent;
		this.fee=fee;
		this.salary=salary;
		this.reward=reward;
		this.remark=remark;
	}
	public ResultMessage Recordpay(){
		RecordpayPO po=new RecordpayPO(id, paytime, paysum, payman, payaccount, rent, fee, salary, reward, remark);
		return ResultMessage.success;
	}
}
