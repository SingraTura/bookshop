package command.commandSetter;

import java.util.ArrayList;
import java.util.HashMap;

import accessData.SetterDAO;

public class SetterModifyBookAtributte implements Setteable{
	public static final String COMMAND_NAME = "SetterModifyBookAtributte";
	@Override
	public Boolean execute(HashMap<String, String> data) {
		ArrayList<String> dataBook = loadData(data);
		return setterInstance().call(data.get("procedure"), dataBook);
	}
	private ArrayList<String> loadData(HashMap<String, String> data) {
		ArrayList<String> dataBook = new ArrayList<String>();
		dataBook.add(data.get("ISBN"));
		dataBook.add(data.get("Amount"));
		return dataBook;
	}
	@Override
	public SetterDAO setterInstance() {
		return SetterDAO.instance();
	}
}
