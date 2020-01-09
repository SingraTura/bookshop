package command.commandGetter;



public class GetterDataTableHistory extends GetterDataTable implements Getteable{

	public static final String COMMAND_NAME = "GetterDataTableHistory";

	@Override
	protected void loaderTable(String[][] dataTableBookAuxiliar, int i, String[] attributesBook) {
		for (int j = 0; j < attributesBook.length; j++) {
			dataTableBookAuxiliar[i][j] = attributesBook[j];
		}
	}

}
