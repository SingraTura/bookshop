package command.commandGetter;

import java.util.HashMap;

import Enum.DataBaseNameField;
import Enum.Procedure;
import accessData.GetterDAO;

public class GetterBookData implements Getteable{
	public static final String COMMAND_NAME = "GetterBookData";
	private String SEPARATOR_ATRIBUTE = GetterDAO.SEPARATOR_ATRIBUTE;
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, String> execute(HashMap<String, String> order) {
		String aux = getterInstance().call(Procedure.getBook.getSintax(),order.get("ISBN"));
		return (HashMap<String, String>) translate(aux);
	}
	@Override
	public Object translate(String book){
		HashMap<String, String> dataBookMap = new HashMap<String, String>();
		String dataBook[] = book.split(SEPARATOR_ATRIBUTE);
		dataBookMap.put("Tittle",dataBook[DataBaseNameField.tittle.getValue()]);
		dataBookMap.put("ISBN",dataBook[DataBaseNameField.isbn.getValue()]);
		dataBookMap.put("Theme",dataBook[DataBaseNameField.theme.getValue()]);
		dataBookMap.put("Format",dataBook[DataBaseNameField.format.getValue()]);
		dataBookMap.put("State",dataBook[DataBaseNameField.state.getValue()]);
		dataBookMap.put("Author",dataBook[DataBaseNameField.author.getValue()]);
		dataBookMap.put("NumberOfPages", dataBook[DataBaseNameField.numPag.getValue()]);
		dataBookMap.put("Price", dataBook[DataBaseNameField.price.getValue()]);
		return dataBookMap;
	}
	@Override
	public GetterDAO getterInstance() {
		return GetterDAO.instance();
	}
}
