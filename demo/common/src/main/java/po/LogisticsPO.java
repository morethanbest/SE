package po;

import java.io.Serializable;
import java.util.List;

public class LogisticsPO  implements Serializable{
	long id;
	String state;
	List<String> history;
	String ordernum;
	public LogisticsPO(long id,String state, List<String> history, String ordernum) {
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
	public List<String> getHistory() {
		return history;
	}
	public void setHistory(List<String> history) {
		this.history = history;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	
}
