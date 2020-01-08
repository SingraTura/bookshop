package command.commandGetter;



public class GetterDataTableHistory extends GetterDataTable implements Getteable{

	public static final String COMMAND_NAME = "GetterDataTableHistory";

	@Override
	protected void loaderTable(String[][] dataTableBookAuxiliar, int i, String[] attributesBook) {
		dataTableBookAuxiliar[i][0] = attributesBook[0];
		dataTableBookAuxiliar[i][1] = attributesBook[1];
		dataTableBookAuxiliar[i][2] = attributesBook[2];
		dataTableBookAuxiliar[i][3] = attributesBook[3];
		dataTableBookAuxiliar[i][4] = attributesBook[4];
	}

}
