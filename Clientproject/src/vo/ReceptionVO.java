package vo;

public class ReceptionVO {
	String codeofreceiving;
	String receiver;
	long receivingtime;
	public String getCodeofreceiving() {
		return codeofreceiving;
	}
	public String getReceiver() {
		return receiver;
	}
	public long getReceivingtime() {
		return receivingtime;
	}
	public ReceptionVO(String codeofreceiving, String receiver,
			long receivingtime) {
		super();
		this.codeofreceiving = codeofreceiving;
		this.receiver = receiver;
		this.receivingtime = receivingtime;
	}
}
