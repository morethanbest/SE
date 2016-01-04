package presentation.exception;

public class NumberLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NumberLimitException(int limit){
		super("输入框数字个数限制：" + limit);
	}

}
