import java.io.Serializable;

public class CommodityPO  implements Serializable{
	long id;
	long ordercode;
	long intime;
	long blocknum;
	long linenum;
	long shelfnum;
	long locationnum;
	long outtime;
	public CommodityPO(long id,long ordercode, long intime, long blocknum, long linenum, long shelfnum, long locationnum) {
		this.id=id;
		this.ordercode = ordercode;
		this.intime = intime;
		this.blocknum = blocknum;
		this.linenum = linenum;
		this.shelfnum = shelfnum;
		this.locationnum = locationnum;
		this.outtime=0;
	}
	public long getId() {
		return id;
	}
	public long getOuttime() {
		return outtime;
	}
	public void setOuttime(long outtime) {
		this.outtime = outtime;
	}
	public long getOrdercode() {
		return ordercode;
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
	
	
}
