package businesslogic.balancebl.DebitnotePack;

import po.DebitnotePO;
import po.Formstate;
import vo.ResultMessage;

public class MockRecord extends Record{
	long id;
	long debittime;
	String debitunit;
	String debitor;
	String debitside;
	double sum;
	String location;
	Formstate documentstate=Formstate.waiting;
	public void setRecordInfo(long id,long debittime,String debitunit,String debitor,String debitside,double sum,String location){
		this.id=id;
		this.debittime=debittime;
		this.debitunit=debitunit;
		this.debitor=debitor;
		this.debitside=debitside;
		this.sum=sum;
		this.location=location;
	}
	public ResultMessage RecordDebitnote(){
		DebitnotePO po=new DebitnotePO(id, debittime, debitunit, debitor, debitside, sum, location);
		return ResultMessage.success;
	}
}
