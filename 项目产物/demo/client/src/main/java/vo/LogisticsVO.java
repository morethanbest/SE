package vo;

import java.util.List;

public class LogisticsVO {
	String state;
	List<String> history;
	String ordernum;
	public LogisticsVO(String state, List<String> history, String ordernum) {
		super();
		this.state = state;
		this.history = history;
		this.ordernum = ordernum;
	}
	public String getState() {
		return state;
	}
	public List<String> getHistory() {
		return history;
	}
	public String getOrdernum() {
		return ordernum;
	}
}
