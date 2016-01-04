package vo;

import java.util.List;

import po.Formstate;

public class RecordcollectExamVO {
	long id;	long collectiontime;
	double collectionsum;
	String collectionman;
	List<String> allordercode;
	Formstate documentstate;
	
	public RecordcollectExamVO(long id,long collectiontime,double collectionsum,String collectionman,List<String> allordercode){
		this.collectionman=collectionman;
		this.collectionsum=collectionsum;
		this.collectiontime=collectiontime;
		this.allordercode=allordercode;
		this.documentstate=Formstate.waiting;
	}

	public void setDocumentstate(Formstate documentstate){
		this.documentstate=documentstate;
	}
	
	public void setCollectiontime(long collectiontime) {
		this.collectiontime = collectiontime;
	}

	public void setCollectionsum(double collectionsum) {
		this.collectionsum = collectionsum;
	}

	public void setCollectionman(String collectionman) {
		this.collectionman = collectionman;
	}

	public void setAllordercode(List<String> allordercode) {
		this.allordercode = allordercode;
	}

	public Formstate getDocumentstate(){
		return this.documentstate;
	}
	public long getCollectiontime(){
		return this.collectiontime;
	}
	public double getCollectionsum(){
		return this.collectionsum;
	}
	public String getCollectionman(){
		return this.collectionman;
	}
	public List<String> getAllordercode(){
		return this.allordercode;
	}
}
