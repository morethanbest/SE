package vo;

import po.Formstate;

import java.util.List;

public class RecordcollectVO {
	String id;
	long collectiontime;
	double collectionsum;
	String collectionman;
	List<String> allordercode;
	Formstate formstate;
	public RecordcollectVO(String id,long collectiontime, double collectionsum,
			String collectionman, List<String> allordercode, Formstate formstate) {
		this.id=id;
		this.collectiontime = collectiontime;
		this.collectionsum = collectionsum;
		this.collectionman = collectionman;
		this.allordercode = allordercode;
		this.formstate=formstate;
	}
	public String getid(){return id;}
	public long getCollectiontime() {
		return collectiontime;
	}
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
}
