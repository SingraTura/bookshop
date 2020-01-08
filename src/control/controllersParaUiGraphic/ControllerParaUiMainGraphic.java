package control.controllersParaUiGraphic;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import view.TableHeadGestor;

public class ControllerParaUiMainGraphic {
	private JTable tableBook;
	private JScrollPane scrollPaneTable;
	private JTextField text;
	
	public ControllerParaUiMainGraphic(JTable tableBook, JScrollPane scrollPaneTable, JTextField text) {
		super();
		this.scrollPaneTable =scrollPaneTable;
		this.tableBook=tableBook;
		this.text = text;
	}
	
	public void createTable(String [] tittles, String[][] data)
	{
		tableBook.setModel(new DefaultTableModel(data, tittles));
		JTableHeader jtableHeader = tableBook.getTableHeader();
	    jtableHeader.setDefaultRenderer(new TableHeadGestor());
	    tableBook.setTableHeader(jtableHeader); 
	    scrollPaneTable.setViewportView(tableBook);
	}
	public JTable getTableBook() {
		return this.tableBook;
	}
	public String getTextFilter() {
		return this.text.getText();
	}
}
