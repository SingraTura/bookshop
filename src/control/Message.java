package control;

public enum Message {
	amountNotValid("Amound is not valid"),
	priceNotValid("Price is not valid"),
	numberPagesNotValid("Number pages is not valid"),
	isbnNotValid("ISBN is not valid"),
	tittleNotValid("Tittle is not valid"),
	nullField("Fill all fields please"),
	bookSuccessful("Book was added successful"),
	amoundSuccessful("Amound was updated successful")
	;
	
	
	public String msg;
	private Message(String msg)
	{
		this.msg=msg;
	}
}
