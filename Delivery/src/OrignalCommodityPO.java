
public class OrignalCommodityPO {
	long id;
	long ordercode;
	long intime;
	long blocknum;
	long linenum;
	long shelfnum;
	long locationnum;
	long outtime;
	public OrignalCommodityPO(long id, long ordercode, long intime, long blocknum, long linenum, long shelfnum,
			long locationnum) {
		this.id = id;
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
	public long getOuttime() {
		return outtime;
	}
	
	
}
