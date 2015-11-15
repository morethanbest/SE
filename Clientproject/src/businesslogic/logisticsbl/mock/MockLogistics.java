package businesslogic.logisticsbl.mock;

import java.util.List;

public class MockLogistics {
	String state;
	List<String> history;
	String ordernum;
	public MockLogistics(String state, List<String> history, String ordernum) {
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
