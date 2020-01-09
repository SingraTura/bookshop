package events;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
}
