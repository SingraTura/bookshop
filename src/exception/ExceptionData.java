package exception;

public class ExceptionData extends Exception {
	private static final long serialVersionUID = 1L;
	private String msg;
	public ExceptionData(String msg) {
		super(msg);
		this.msg=msg;
	}
	public String getMsg() {
		return msg;
	}
}
