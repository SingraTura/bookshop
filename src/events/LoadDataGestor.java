package events;

import java.util.HashMap;

import Enum.Procedure;
import command.commandGetter.CommandManagerGetter;
import command.commandGetter.Getteable;
import control.controllersParaUiGraphic.ControllerParaUiGestorBookGraphic;

public class LoadDataGestor {
	ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic;
	
	public LoadDataGestor(
			ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic) {
		super();
		this.controllerParaUiGestorBookGraphic = controllerParaUiGestorBookGraphic;
	}
	
	@SuppressWarnings("unchecked")
	public void event() {
		String isbn=this.controllerParaUiGestorBookGraphic.getISBN();
		HashMap<String, String> order = new HashMap<String, String>();
		order.put("procedure", Procedure.getBook.getSintax());
		order.put("ISBN", isbn);
		Getteable getteable = CommandManagerGetter.getIntance().getCommand(Procedure.getBook.getValidateName());
		HashMap<String, String> dataBook = (HashMap<String, String>) getteable.execute(order);
		
		order.put("procedure", Procedure.getAmountBook.getSintax());
		getteable = CommandManagerGetter.getIntance().getCommand(Procedure.getAmountBook.getValidateName());
		dataBook.put("Amount", String.valueOf(getteable.execute(order)));
		
		this.controllerParaUiGestorBookGraphic.loadTexts(dataBook);
	}
    
}
