package po;
import java.io.Serializable;
import java.util.List;

public class RecordcollectPO  implements Serializable{
	String id;
	long collectiontime;
	double collectionsum;
	String collectionman;
	List<String> allordercode;
	Formstate documentstate;
	
	public RecordcollectPO(String id,long collectiontime,double collectionsum,String collectionman,List<String> allordercode,Formstate formstate){
		this.id=id;
		this.collectionman=collectionman;
		this.collectionsum=collectionsum;
		this.collectiontime=collectiontime;
		this.allordercode=allordercode;
		this.documentstate=formstate;
	}
	public String getId() {
		return id;
	}

	public void setId(String id){this.id=id;}
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

	public void setFormstate(Formstate state){this.documentstate=state;}

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
