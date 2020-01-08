package control.paraUis;


import events.EventOpenGestorBook;
import events.EventOpenHistory;
import control.controllersParaUiGraphic.ControllerParaUiMainGraphic;
import events.EventOpenAddAuthor;
import events.EventOpenAddBook;
import events.UpdateTable;
import view.UILibrary;

public class ParaUiMain extends UILibrary{
	private static final long serialVersionUID = 1L;
	
	public ParaUiMain()
	{
		super();
		ControllerParaUiMainGraphic controllerParaUiMainGraphic = new ControllerParaUiMainGraphic(this.getTableBook(), this.getScrollPaneTable(), this.getTextFilter());
		this.createListener(controllerParaUiMainGraphic);
	}
	
	private void createListener(ControllerParaUiMainGraphic controllerParaUiMainGraphic) {
		UpdateTable updateTable=new UpdateTable(controllerParaUiMainGraphic);
		updateTable.createTable();
		this.getBtnFilet().addActionListener(updateTable);
		this.getBtnHistory().addActionListener(new EventOpenHistory());
		this.getMenuBook_addNewBook().addActionListener(new EventOpenAddBook(controllerParaUiMainGraphic));
		this.menuAuthor_addNewAuthor.addActionListener(new EventOpenAddAuthor());
		this.getMenuBook_gestorBook().addActionListener(new EventOpenGestorBook(controllerParaUiMainGraphic,updateTable));
		
		
	}
}
