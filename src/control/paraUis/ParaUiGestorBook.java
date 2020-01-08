package control.paraUis;

import control.controllersParaUiGraphic.ControllerParaUiGestorBookGraphic;
import events.EventEditBook;
import events.LoadDataGestor;
import events.UpdateAmount;
import events.UpdateTable;
import view.UIBookGestor;

public class ParaUiGestorBook extends UIBookGestor{
	private static final long serialVersionUID = 1L;
	public ParaUiGestorBook(String isbn, UpdateTable updateTable) {
		super();
		ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic = new ControllerParaUiGestorBookGraphic(this,isbn);
	    this.initComponent(controllerParaUiGestorBookGraphic);
		this.loadEvents( controllerParaUiGestorBookGraphic, updateTable);
	}

	private void loadEvents(
			ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic, UpdateTable updateTable) {
		this.getBtnAdd().addActionListener(new UpdateAmount(controllerParaUiGestorBookGraphic, true,updateTable));
		this.getBtnDelete().addActionListener(new UpdateAmount(controllerParaUiGestorBookGraphic, false,updateTable));
		this.getBtnEdit().addActionListener(new EventEditBook(controllerParaUiGestorBookGraphic, updateTable));
	}

	private void initComponent(
			ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic) {
		(new LoadDataGestor(controllerParaUiGestorBookGraphic)).event();
		
	}

	
}
