package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import Enum.Procedure;
import command.commandSetter.CommandManagerSetter;
import control.controllersParaUiGraphic.ControllerParaUiAddAutorGraphic;

public class EventAddAuthor implements ActionListener{

	private ControllerParaUiAddAutorGraphic ControllerParaUiAddAutorGraphic;
	
	public EventAddAuthor(ControllerParaUiAddAutorGraphic controllerParaUiAddAutorGraphic) {
		this.ControllerParaUiAddAutorGraphic=controllerParaUiAddAutorGraphic;
	}

	@Override
	public void actionPerformed(ActionEvent pressButton) {
		HashMap<String,String>order=ControllerParaUiAddAutorGraphic.createMapAuthor();
		
		order.put("procedure", Procedure.addAuthor.getSintax());
		CommandManagerSetter.getIntance().getCommand(Procedure.addAuthor.getValidateName()).execute(order);
		ControllerParaUiAddAutorGraphic.clear();
	}
}
