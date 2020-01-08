package events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import control.Message;
import exception.ExceptionData;

public class Validator {

	public Reply valiteDateBook(HashMap<String, String> datos) throws ExceptionData {
		Reply retorno = new Reply(true, Message.bookSuccessful.msg);

		ArrayList<Reply> arrayListHelp = new ArrayList<Reply>();

		arrayListHelp.add(this.validateTittle(datos.get("Tittle")));
		arrayListHelp.add(this.validateISBN(datos.get("ISBN")));
		arrayListHelp.add(this.validateNPages(datos.get("NumPages")));
		arrayListHelp.add(this.validatePrice(datos.get("Price")));

		for (Reply reply : arrayListHelp) {
			if (!reply.isResult())
				throw new ExceptionData(reply.getReply());
		}
		return retorno;
	}

	public Reply validateGestor(String amount) throws ExceptionData {
		Reply retorno = new Reply(true, Message.amoundSuccessful.msg);
		if (!this.validateAmount(amount).isResult())
			throw new ExceptionData(this.validateAmount(amount).getReply());
		return retorno;
	}

	public Reply validateAmount(String amount) {
		return new Reply(Pattern.matches("^[0-9]{1,100}$", amount), Message.amountNotValid.msg);
	}

	private Reply validatePrice(String price) {
		return new Reply(Pattern.matches("^\\d+$", price), Message.priceNotValid.msg);
	}

	private Reply validateNPages(String nPages) {
		return new Reply(Pattern.matches("^\\d+$", nPages), Message.numberPagesNotValid.msg);
	}

	private Reply validateISBN(String isbn) {
		return new Reply(Pattern.matches("\\d{13}", isbn), Message.isbnNotValid.msg);
	}

	private Reply validateTittle(String tittle) {
		return new Reply(Pattern.matches("[0-9A-Za-z\\s]{1,300}", tittle), Message.tittleNotValid.msg);
	}
}
