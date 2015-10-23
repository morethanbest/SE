import java.io.Serializable;

public class StockinPO  implements Serializable{
	long id;
	long ordercode;
	long intime;
	long blocknum;
	long linenum;
	long shelfnum;
	long locationnum;
	Formstate documentstate;
	public StockinPO(long id,long ordercode, long intime, long blocknum, long linenum, long shelfnum, long locationnum) {
		this.id=id;
		this.ordercode = ordercode;
		this.intime = intime;
		this.blocknum = blocknum;
		this.linenum = linenum;
		this.shelfnum = shelfnum;
		this.locationnum = locationnum;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public Formstate getDocumentstate() {
		return documentstate;
	}
	public void setDocumentstate(Formstate documentstate) {
		this.documentstate = documentstate;
	}
	public long getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(long ordercode) {
		this.ordercode = ordercode;
	}
	public void setIntime(long intime) {
		this.intime = intime;
	}
	public void setBlocknum(long blocknum) {
		this.blocknum = blocknum;
	}
	public void setLinenum(long linenum) {
		this.linenum = linenum;
	}
	public void setShelfnum(long shelfnum) {
		this.shelfnum = shelfnum;
	}
	public void setLocationnum(long locationnum) {
		this.locationnum = locationnum;
	}
	public long getIntime() {
		return intime;
	}
	public long getBlocknum() {
		return blocknum;
	}
	public long getLinenum() {
		return linenum;
	}
	public long getShelfnum() {
		return shelfnum;
	}
	public long getLocationnum() {
		return locationnum;
	}
	
}
