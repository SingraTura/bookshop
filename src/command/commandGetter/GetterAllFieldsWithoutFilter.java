package command.commandGetter;

import java.util.ArrayList;
import java.util.HashMap;

import accessData.GetterDAO;

public class GetterAllFieldsWithoutFilter implements Getteable {

	public static final String COMMAND_NAME = "GetterAllFieldsWithoutFilter";
	private String SEPARATOR_OBJECT = GetterDAO.SEPARATOR_OBJECT;
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<String> execute(HashMap<String, String> order) {
		String aux = getterInstance().call(order.get("procedure"));
		return (ArrayList<String>) translate(aux);
	}

	@Override
	public GetterDAO getterInstance() {
		return GetterDAO.instance();
	}

	@Override
	public Object translate(String data) {
		String[] convert = data.split(SEPARATOR_OBJECT);
		ArrayList<String> retorno = new ArrayList<String>();
		for (String string : convert) {
			retorno.add(string);
		}
		return retorno;
	}

}
