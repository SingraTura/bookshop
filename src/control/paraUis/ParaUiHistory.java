package control.paraUis;

import java.util.HashMap;

import javax.swing.table.JTableHeader;

import Enum.Procedure;
import command.commandGetter.CommandManagerGetter;
import view.ModeloPersonalizado;
import view.TableHeadGestor;
import view.UIHistory;

public class ParaUiHistory extends UIHistory{
	private static final long serialVersionUID = 1L;
	public ParaUiHistory() {
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("key", "");
		data.put("procedure", Procedure.getHistory.getSintax());
		String[][]table= (String[][]) CommandManagerGetter.getIntance().getCommand(Procedure.getHistory.getValidateName()).execute(data);
		this.createTable(this.createTittles(), table);
	}
	public String[] createTittles() {
		String[] tittles = {"Tittle", "ISBN", "Operation", "Changes","Total", "Date"};
		return tittles;
	}
	public void createTable(String [] tittles, String[][] data)
	{
		ModeloPersonalizado model = new ModeloPersonalizado(data, tittles);
		
		getTableBook().setModel(model);
		
		JTableHeader jtableHeader = getTableBook().getTableHeader();
	    jtableHeader.setDefaultRenderer(new TableHeadGestor());
	    getTableBook().setTableHeader(jtableHeader); 
	    
	    getScrollPaneTable().setViewportView(getTableBook());
	    
	    
	}
}
