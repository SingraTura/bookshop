package control.paraUis;


import events.EvenGetBestSeller;
import events.EventFilterDateHistory;
import events.TableCreator;
import view.UIHistory;

public class ParaUiHistory extends UIHistory{
	private static final long serialVersionUID = 1L;
	public ParaUiHistory() {
		TableCreator tableCreator = new TableCreator(getTableBook(), getScrollPaneTable());
		this.getBtnFilter().addActionListener(new EventFilterDateHistory(tableCreator,this.getDateBegin(), this.getDateEnd()));
		this.getBtnBestSeller().addActionListener(new EvenGetBestSeller(tableCreator,this.getDateBegin(), this.getDateEnd()));
		this.createTable(tableCreator);
	}
	public void createTable(TableCreator creatorTable)
	{
		String[] tittle = creatorTable.createTittlesHistory();
		String[][] dataTable = creatorTable.getDataTableHistory();
		creatorTable.createTable(tittle, dataTable);
	   
	    
	}
}
