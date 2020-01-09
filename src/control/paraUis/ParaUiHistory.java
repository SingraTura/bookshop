package control.paraUis;

import java.util.HashMap;

import javax.swing.table.JTableHeader;

import Enum.Procedure;
import command.commandGetter.CommandManagerGetter;
import events.EventFilterDateHistory;
import events.TableCreator;
import view.ModeloPersonalizado;
import view.TableHeadGestor;
import view.UIHistory;

public class ParaUiHistory extends UIHistory{
	private static final long serialVersionUID = 1L;
	public ParaUiHistory() {
		TableCreator tableCreator = new TableCreator(getTableBook(), getScrollPaneTable());
		this.getBtnFilter().addActionListener(new EventFilterDateHistory(tableCreator,this.getDateBegin(), this.getDateEnd()));
		this.createTable(tableCreator);
	}
	public String[] createTittles() {
		String[] tittles = {"Tittle", "ISBN", "Operation", "Changes","Total", "Date"};
		return tittles;
	}
	public void createTable(TableCreator creatorTable)
	{
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("key", "");
		data.put("procedure", Procedure.getHistory.getSintax());
		String[][]tableData= (String[][]) CommandManagerGetter.getIntance().getCommand(Procedure.getHistory.getValidateName()).execute(data);
		
		creatorTable.createTable( this.createTittles(), tableData);
	   
	    
	}
}
