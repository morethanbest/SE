import java.io.Serializable;

public class LogisticsPO  implements Serializable{
	long id;
	String state;
	String[] history;
	long ordernum;
	public LogisticsPO(long id,String state, String[] history, long ordernum) {
		this.id=id;
		this.state = state;
		this.history = history;
		this.ordernum = ordernum;
	}
	public long getId() {
		return id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String[] getHistory() {
		return history;
	}
	public void setHistory(String[] history) {
		this.history = history;
	}
	public long getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(long ordernum) {
		this.ordernum = ordernum;
	}
	
}
