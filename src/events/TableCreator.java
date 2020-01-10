package events;


import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Enum.Procedure;
import command.commandGetter.CommandManagerGetter;
import view.ModeloPersonalizado;
import view.TableHeadGestor;

public class TableCreator {
	private JTable table;
	private JScrollPane scroll;
	public TableCreator(JTable table, JScrollPane scroll) {
		this.scroll=scroll;
		this.table=table;
	}
	
	public void createTable(String[] tittle, String[][]dataTable)
	{
		table.setModel(new DefaultTableModel(dataTable, tittle));
		JTableHeader jtableHeader = table.getTableHeader();
	    jtableHeader.setDefaultRenderer(new TableHeadGestor());
	    table.setTableHeader(jtableHeader); 
	    scroll.setViewportView(table);
	    
	}
	public String[][] getDataTableHistory() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("key", "");
		data.put("procedure", Procedure.getHistory.getSintax());
		String[][] tableData = (String[][]) CommandManagerGetter.getIntance()
				.getCommand(Procedure.getHistory.getValidateName()).execute(data);
		
		return tableData;
	}
	public String[] createTittlesHistory() {
		String[] tittles = {"Tittle", "ISBN", "Operation", "Changes","Total", "Date"};
		return tittles;
	}
}
