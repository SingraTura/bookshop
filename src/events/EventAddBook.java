package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


import Enum.Procedure;
import command.commandSetter.CommandManagerSetter;
import control.controllersParaUiGraphic.ControllerParaUiAddBookGraphic;
import control.controllersParaUiGraphic.ControllerParaUiMainGraphic;
import control.paraUis.ParaUiWindowError;
import exception.ExceptionData;

public class EventAddBook implements ActionListener{
	private ControllerParaUiAddBookGraphic controllerParaUiAddBookGraphic;
	private ControllerParaUiMainGraphic controllerParaUiMainGraphic;
	public Validator validator = new Validator();
	
	public EventAddBook(
			ControllerParaUiAddBookGraphic controllerParaUiAddBookGraphic,
			ControllerParaUiMainGraphic controllerParaUiMainGraphic) {
		super();
		this.controllerParaUiAddBookGraphic = controllerParaUiAddBookGraphic;
		this.controllerParaUiMainGraphic = controllerParaUiMainGraphic;
	}
	
	private void createWindowError(ExceptionData e) {
		ParaUiWindowError paraUiWindowError = new ParaUiWindowError(e.getMsg());
		paraUiWindowError.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			HashMap<String, String>book=this.controllerParaUiAddBookGraphic.createMapBook();
			book.put("procedure", Procedure.addBook.getSintax());
			if (validator.valiteDateBook(book).isResult()) {
				CommandManagerSetter.getIntance().getCommand(Procedure.addBook.getValidateName()).execute(book);
				controllerParaUiAddBookGraphic.clear();
				(new UpdateTable(controllerParaUiMainGraphic)).createTable();;
			}
		} catch(ExceptionData err)
		{
			createWindowError(err);
		}
	}
}