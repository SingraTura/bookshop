package command.commandGetter;

import java.util.ArrayList;
import java.util.HashMap;

import accessData.GetterDAO;

public class GetterAllFieldsWithFilter implements Getteable{
	public static final String COMMAND_NAME = "GetterAllFieldsWithFilter";
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<String> execute(HashMap<String, String> order) {
		String aux = getterInstance().call(order.get("procedure"), order.get("key"));
		return (ArrayList<String>) translate(aux);
	}
	
	@Override
	public GetterDAO getterInstance() {
		return GetterDAO.instance();
	}

	@Override
	public Object translate(String data) {
		String[] convert = data.split(GetterDAO.SEPARATOR_OBJECT);
		ArrayList<String> retorno = new ArrayList<String>();
		for (String string : convert) {
			retorno.add(string);
		}
		return retorno;
	}
	
}
