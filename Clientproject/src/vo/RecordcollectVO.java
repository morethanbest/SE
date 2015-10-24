package vo;

import java.util.List;

public class RecordcollectVO {
	
	long collectiontime;
	double collectionsum;
	String collectionman;
	List<String> allordercode;
	public RecordcollectVO(long collectiontime, double collectionsum,
			String collectionman, List<String> allordercode) {
		super();
		this.collectiontime = collectiontime;
		this.collectionsum = collectionsum;
		this.collectionman = collectionman;
		this.allordercode = allordercode;
	}
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
}
