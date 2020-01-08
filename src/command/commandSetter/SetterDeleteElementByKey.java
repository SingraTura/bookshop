package command.commandSetter;

import java.util.ArrayList;
import java.util.HashMap;

import accessData.SetterDAO;

public class SetterDeleteElementByKey implements Setteable{
	public static final String COMMAND_NAME = "SetterDeleteElementByKey";
	@Override
	public Boolean execute(HashMap<String, String> order) {
		ArrayList<String> key = new ArrayList<String>();
		key.add(order.get("key"));
		return setterInstance().call(order.get("procedure"), key);
	}

	@Override
	public SetterDAO setterInstance() {
		return SetterDAO.instance();
	}
}
