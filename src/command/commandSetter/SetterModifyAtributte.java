package command.commandSetter;

import java.util.ArrayList;
import java.util.HashMap;

import accessData.SetterDAO;

public class SetterModifyAtributte implements Setteable{

	public static final String COMMAND_NAME = "SetterModifyAtributte";
	@Override
	public Boolean execute(HashMap<String, String> order) {
		ArrayList<String> key = new ArrayList<String>();
		key.add(order.get("name"));
		return setterInstance().call(order.get("procedure"), key);
	}

	@Override
	public SetterDAO setterInstance() {
		return SetterDAO.instance();
	}

}
