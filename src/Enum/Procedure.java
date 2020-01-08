package Enum;

public enum Procedure {
	
	addBook(			"{call addBook(?, ?, ?, ?, ?, ?, ?, ?, ?)}",	"SetterModifyBook"),
	updateBook(			"{call updateBook(?, ?, ?, ?, ?, ?, ?, ?, ?)}", "SetterModifyBook"),
	deleteBook(			"{call deleteBook(?)}", 						"SetterDeleteElementByKey"),
	getBook(			"{call getDataBook(?, ?)}",						"GetterBookData"),
	getAllBook(			"{call getAllBook(?)}",							"GetterDataTableBook"),
	getHistory(			"{call getHistory(?)}",							"GetterDataTableHistory"),
	
	addAuthor(			"{call addAuthor(?, ?, ?, ?)}",					"SetterAddAuthor"),
	
	removeTheme(		"{call removeTheme(?)}", 						"SetterModifyAtributte"),
	removeFormat(		"{call removeFormat(?)}", 						"SetterModifyAtributte"),
	removeState(		"{call removeState(?)}", 						"SetterModifyAtributte"),
	addTheme(			"{call addTheme(?)}", 							"SetterModifyAtributte"),
	addFormat(			"{call addFormat(?)}", 							"SetterModifyAtributte"),
	addState(			"{call addState(?)}", 							"SetterModifyAtributte"),
	
	getAllTheme(		"{call getAllTheme(?)}",						"GetterAllFieldsWithoutFilter"),
	getAllState(		"{call getAllState(?)}",						"GetterAllFieldsWithoutFilter"),
	getAllFormat(		"{call getAllFormat(?)}",						"GetterAllFieldsWithoutFilter"),
	getAllAuthor(		"{call getAllAuthor(?)}",						"GetterAllFieldsWithoutFilter"),
	
	getAmountBook(		"{call getAmountBook(?, ?)}",					"GetterOneFieldWithFilter"),
	updateAmountBook(	"{call updateAmountBook(?, ?)}",				"SetterModifyBookAtributte")		
	
	;
	
	private String value;
	private String validateName;
	Procedure(String value, String validateName) {
		this.value = value;
		this.validateName = validateName;
	}
	public String getSintax() {
		return this.value;
	}
	public String getValidateName() {
		return this.validateName;
	}
}
