package vo;

import po.Formstate;

import java.util.List;

public class RecordcollectVO {
	String id;
	long collectiontime;
	String accountcode;
	double collectionsum;
	String collectionman;
	List<String> allordercode;
	Formstate formstate;
	public RecordcollectVO(String id,long collectiontime, String accountcode,double collectionsum,
			String collectionman, List<String> allordercode, Formstate formstate) {
		this.id=id;
		this.collectiontime = collectiontime;
		this.accountcode=accountcode;
		this.collectionsum = collectionsum;
		this.collectionman = collectionman;
		this.allordercode = allordercode;
		this.formstate=formstate;
	}
	public String getid(){return id;}
	public long getCollectiontime() {
		return collectiontime;
	}
	public String getAccountcode(){return accountcode;}
	public double getCollectionsum() {
		return collectionsum;
	}
	public String getCollectionman() {
		return collectionman;
	}
	public List<String> getAllordercode() {
		return allordercode;
	}
	public Formstate getFormstate(){return this.formstate;}
	public void setFormstate(Formstate formstate){
		this.formstate=formstate;
	}
}
