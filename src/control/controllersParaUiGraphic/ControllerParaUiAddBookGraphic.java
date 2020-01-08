package control.controllersParaUiGraphic;

import java.util.HashMap;

import control.paraUis.ParaUiAddBook;

public class ControllerParaUiAddBookGraphic {
	private ParaUiAddBook paraUiAddBook;
	public ControllerParaUiAddBookGraphic(ParaUiAddBook paraUiAddBook)
	{
		super();
		this.paraUiAddBook=paraUiAddBook;
	}
	
	public HashMap<String, String> createMapBook()
	{
		String tittle= this.paraUiAddBook.getTextTittle().getText();
		String author= this.paraUiAddBook.getCmbAuthor().getSelectedItem().toString();
		String theme= this.paraUiAddBook.getCmbGender().getSelectedItem().toString();
		String numPages= this.paraUiAddBook.getTextNumPag().getText();
		String iSBN= this.paraUiAddBook.getTextISBN().getText();
		String format= this.paraUiAddBook.getCmbFormat().getSelectedItem().toString();
		String state= this.paraUiAddBook.getCmbState().getSelectedItem().toString();
		String price= this.paraUiAddBook.getTextPrice().getText();
		
		HashMap<String, String> bookHashMap = new HashMap<String, String>();
		

		bookHashMap.put("ISBN", iSBN);
		bookHashMap.put("Tittle", tittle);
		bookHashMap.put("Firstname", author.split(" ")[0]);
		bookHashMap.put("Lastname", author.split(" ")[1]);
		bookHashMap.put("NumPages", numPages);
		bookHashMap.put("Format", format);
		bookHashMap.put("State", state);
		bookHashMap.put("Theme", theme);
		bookHashMap.put("Price", price);
		
		return bookHashMap;
	}
	
	public void clear() {
		this.paraUiAddBook.getTextTittle().setText("");
		this.paraUiAddBook.getTextISBN().setText("");
		this.paraUiAddBook.getTextNumPag().setText("");
		this.paraUiAddBook.getTextPrice().setText("");
	}
}
