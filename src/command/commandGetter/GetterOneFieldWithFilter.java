package command.commandGetter;

import java.util.HashMap;

import accessData.GetterDAO;

public class GetterOneFieldWithFilter implements Getteable{
	public static final String COMMAND_NAME="GetterOneFieldWithFilter";
	@Override
	public Object execute(HashMap<String, String> order) {
		String aux = getterInstance().call(order.get("procedure"),order.get("ISBN"));
		if(aux == null) return null;
		return (Integer) translate(aux);
	}

	@Override
	public GetterDAO getterInstance() {
		return GetterDAO.instance();
	}

	@Override
	public Object translate(String data) {
		
		return Integer.valueOf(data);
	}

}
