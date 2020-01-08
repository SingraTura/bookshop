package command.commandSetter;

import java.util.ArrayList;
import java.util.HashMap;

import accessData.SetterDAO;

public class SetterAddAuthor implements Setteable{
	public static final String COMMAND_NAME = "SetterAddAuthor";
	@Override
	public Boolean execute(HashMap<String, String> data) {
		ArrayList<String> dataAuthor = new ArrayList<String>();
		dataAuthor.add(data.get("Name"));
		dataAuthor.add(data.get("Surname"));
		dataAuthor.add(data.get("Nationality"));
		dataAuthor.add(data.get("Theme"));
		return setterInstance().call(data.get("procedure"), dataAuthor);
	}
	@Override
	public SetterDAO setterInstance() {
		return SetterDAO.instance();
	}
}
