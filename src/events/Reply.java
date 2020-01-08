package events;

public class Reply {
	private boolean result;
	private String reply;
	
	public Reply (boolean result, String reply)
	{
		super();
		this.setReply(reply);
		this.setResult(result);
	}

	public boolean isResult() {
		return result;
	}

	private void setResult(boolean result) {
		this.result = result;
	}

	public String getReply() {
		return reply;
	}

	private void setReply(String reply) {
		this.reply = reply;
	}

	
}
