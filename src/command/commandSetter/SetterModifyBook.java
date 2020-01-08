package command.commandSetter;

import java.util.ArrayList;
import java.util.HashMap;

import accessData.SetterDAO;

public class SetterModifyBook implements Setteable{
	public static final String COMMAND_NAME = "SetterModifyBook";
	@Override
	public Boolean execute(HashMap<String, String> data) {
		ArrayList<String> dataBook = loadData(data);
		return setterInstance().call(data.get("procedure"), dataBook);
	}
	private ArrayList<String> loadData(HashMap<String, String> data) {
		ArrayList<String> dataBook = new ArrayList<String>();
		dataBook.add(data.get("ISBN"));
		dataBook.add(data.get("Tittle"));
		dataBook.add(data.get("Firstname"));
		dataBook.add(data.get("Lastname"));
		dataBook.add(data.get("NumPages"));
		dataBook.add(data.get("Format"));
		dataBook.add(data.get("State"));
		dataBook.add(data.get("Theme"));
		dataBook.add(data.get("Price"));
		return dataBook;
	}
	@Override
	public SetterDAO setterInstance() {
		return SetterDAO.instance();
	}
	
}
