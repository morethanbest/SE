package po;

public class CommodityLocation {
	long blocknum;
	long linenum;
	long shelfnum;
	long locationnum;
	public CommodityLocation(long blocknum, long linenum, long shelfnum, long locationnum) {
		this.blocknum = blocknum;
		this.linenum = linenum;
		this.shelfnum = shelfnum;
		this.locationnum = locationnum;
	}
	public long getBlocknum() {
		return blocknum;
	}
	public void setBlocknum(long blocknum) {
		this.blocknum = blocknum;
	}
	public long getLinenum() {
		return linenum;
	}
	public void setLinenum(long linenum) {
		this.linenum = linenum;
	}
	public long getShelfnum() {
		return shelfnum;
	}
	public void setShelfnum(long shelfnum) {
		this.shelfnum = shelfnum;
	}
	public long getLocationnum() {
		return locationnum;
	}
	public void setLocationnum(long locationnum) {
		this.locationnum = locationnum;
	}
	
}
