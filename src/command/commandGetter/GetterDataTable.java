package command.commandGetter;

import java.util.HashMap;

import accessData.GetterDAO;

public abstract class GetterDataTable implements Getteable{
	
	public static final String COMMAND_NAME = "GetterDataTable";
	private String SEPARATOR_OBJECT = GetterDAO.SEPARATOR_OBJECT;
	private String SEPARATOR_ATRIBUTE = GetterDAO.SEPARATOR_ATRIBUTE;
	
	@Override
	public Object execute(HashMap<String, String> order) {
		String aux = getterInstance().call(order.get("procedure"));
		return translate(aux, order.get("key"));
	}
	private String[][] translate (String datas, String filter) {
		String datasArray[] = datas.split(SEPARATOR_OBJECT);
		int numberOfFields =datasArray[0].split(SEPARATOR_ATRIBUTE).length;
		String[][] dataTable = new String[0][numberOfFields];
		String[][] dataTableAuxiliar = new String[dataTable.length+1][numberOfFields];
		Boolean containsFilter;
		int i=0;
		for (String data : datasArray) {
			
				String attributesData[] = data.split(SEPARATOR_ATRIBUTE);
				loaderTable(dataTableAuxiliar, i, attributesData);
				containsFilter=false;
				for (int j = 0; j < numberOfFields; j++) {
					if(dataTableAuxiliar[i][j].contains(filter)) containsFilter=true;
				}
				if(containsFilter) {
					dataTable=dataTableAuxiliar;
					dataTableAuxiliar = new String[dataTable.length+1][numberOfFields];
					dataTableAuxiliar=this.copyTable(dataTable,dataTableAuxiliar);
					i++;
				}
		}
		return dataTable;
	}
	protected abstract void loaderTable(String[][] dataTableAuxiliar, int i, String[] attributesData);
	
	private String[][] copyTable(String[][] dataTable, String[][] dataTableAuxiliar) {
		for (int i = 0; i < dataTable.length; i++) {
			for (int j = 0; j < dataTable[i].length; j++) {
				dataTableAuxiliar[i][j]=dataTable[i][j];
				}
		}
		return dataTableAuxiliar;
	}
	@Override
	public GetterDAO getterInstance() {
		return GetterDAO.instance();
	}
	@Override
	public Object translate(String data) {
		return null;
	}
}
