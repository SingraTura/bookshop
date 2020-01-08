package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import Enum.Procedure;
import command.commandSetter.CommandManagerSetter;
import control.controllersParaUiGraphic.ControllerParaUiGestorBookGraphic;
import control.paraUis.ParaUiWindowError;
import exception.ExceptionData;

public class UpdateBook implements ActionListener {
	private ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic;
	private UpdateTable updateTable;
	private Validator validator;
	public UpdateBook(
			ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic, UpdateTable updateBook) {
		super();
		this.controllerParaUiGestorBookGraphic = controllerParaUiGestorBookGraphic;
		this.updateTable = updateBook;
		this.validator = new Validator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		eventUpdateBook();

	}
	public void eventUpdateBook () {
		HashMap<String, String> book = this.controllerParaUiGestorBookGraphic.createMapBook();
		try {
			if (this.validator.valiteDateBook(book).isResult()) {
				book.put("procedure", Procedure.updateBook.getSintax());
				CommandManagerSetter.getIntance().getCommand(Procedure.updateBook.getValidateName()).execute(book);
				updateTable.createTable();
				this.controllerParaUiGestorBookGraphic.dispose();

			}
		} catch (ExceptionData err) {
			ParaUiWindowError paraUiWindowError = new ParaUiWindowError(err.getMsg());
			paraUiWindowError.setVisible(true);
		}
	}
}
