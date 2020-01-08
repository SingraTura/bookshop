package command.commandGetter;


import Enum.DataBaseNameField;
import Enum.TableNameField;

public class GetterDataTableBook extends GetterDataTable implements Getteable {

	public static final String COMMAND_NAME = "GetterDataTableBook";
	@Override
	protected void loaderTable(String[][] dataTableBookAuxiliar, int i, String[] attributesBook) {
		dataTableBookAuxiliar[i][TableNameField.tittle.getValue()]=attributesBook[DataBaseNameField.tittle.getValue()];
		dataTableBookAuxiliar[i][TableNameField.isbn.getValue()]=attributesBook[DataBaseNameField.isbn.getValue()];
		dataTableBookAuxiliar[i][TableNameField.author.getValue()]=attributesBook[DataBaseNameField.author.getValue()];
		dataTableBookAuxiliar[i][TableNameField.format.getValue()]=attributesBook[DataBaseNameField.format.getValue()];
		dataTableBookAuxiliar[i][TableNameField.theme.getValue()]=attributesBook[DataBaseNameField.theme.getValue()];
		dataTableBookAuxiliar[i][TableNameField.state.getValue()]=attributesBook[DataBaseNameField.state.getValue()];
		dataTableBookAuxiliar[i][TableNameField.numPag.getValue()]=attributesBook[DataBaseNameField.numPag.getValue()];
		dataTableBookAuxiliar[i][TableNameField.price.getValue()]=attributesBook[DataBaseNameField.price.getValue()];
		dataTableBookAuxiliar[i][TableNameField.amount.getValue()]=attributesBook[DataBaseNameField.amount.getValue()];
		
	}

}
