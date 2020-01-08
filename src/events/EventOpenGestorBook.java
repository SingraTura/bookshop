package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import Enum.Procedure;
import command.commandGetter.CommandManagerGetter;
import control.controllersParaUiGraphic.ControllerParaUiMainGraphic;
import control.paraUis.ParaUiGestorBook;
import control.paraUis.ParaUiWindowError;

public class EventOpenGestorBook implements ActionListener{
	
	private ControllerParaUiMainGraphic controllerParaUiMainGraphic;
	private UpdateTable updataTable;
	
	public EventOpenGestorBook(ControllerParaUiMainGraphic controllerParaUiMainGraphic, UpdateTable updateTable) {
		super();
		this.controllerParaUiMainGraphic = controllerParaUiMainGraphic;
		this.updataTable=updateTable;
	}
	private String getISBNSelectedRow() {
		HashMap<String, String>nulo = new HashMap<String, String>();
		nulo.put("key", "");
		nulo.put("procedure", Procedure.getAllBook.getSintax());
		String[][]data= (String[][]) CommandManagerGetter.getIntance().getCommand(Procedure.getAllBook.getValidateName()).execute(nulo);
		
		String aux=null;
		try {
			aux=data[this.controllerParaUiMainGraphic.getTableBook().getSelectedRow()][1];
		} catch (Exception e) {
			ParaUiWindowError a = new ParaUiWindowError("Seleccione un libro");
			a.setVisible(true);
		}
		
		return aux;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(getISBNSelectedRow()!=null)
		{
			ParaUiGestorBook paraUiGestorBook = new ParaUiGestorBook(getISBNSelectedRow(), updataTable);
			paraUiGestorBook.setVisible(true);
		}
		
	}
	
	
	
	
}
