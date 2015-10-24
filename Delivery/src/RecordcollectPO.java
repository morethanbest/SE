import java.io.Serializable;

public class RecordcollectPO  implements Serializable{
	long id;
	long collectiontime;
	double collectionsum;
	String collectionman;
	long[] allordercode;
	Formstate documentstate;
	
	public RecordcollectPO(long id,long collectiontime,double collectionsum,String collectionman,long[] allordercode){
		this.id=id;
		this.collectionman=collectionman;
		this.collectionsum=collectionsum;
		this.collectiontime=collectiontime;
		this.allordercode=allordercode;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
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

	public void setAllordercode(long[] allordercode) {
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
	public long[] getAllordercode(){
		return this.allordercode;
	}
}
