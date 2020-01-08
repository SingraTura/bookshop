package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import Enum.Procedure;
import command.commandSetter.CommandManagerSetter;
import control.controllersParaUiGraphic.ControllerParaUiGestorBookGraphic;
import control.paraUis.ParaUiWindowError;
import exception.ExceptionData;

public class UpdateAmount implements ActionListener {
	private ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic;
	private Validator validator;
	private Boolean option;
	private UpdateTable updateTable;

	public UpdateAmount(
			ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic, Boolean option,
			UpdateTable updateTable) {
		super();
		this.controllerParaUiGestorBookGraphic = controllerParaUiGestorBookGraphic;
		this.validator = new Validator();
		this.updateTable = updateTable;
		this.option = option;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			int amountInt=0;
			String amount = controllerParaUiGestorBookGraphic.getAmountAdd();
			if (validator.validateGestor(amount).isResult()) {
				amountInt = Integer.valueOf(amount);
			}
			if (!option) {
				amountInt = amountInt * -1;
			} 
			updateAmount(amountInt);
		} catch (ExceptionData e) {
			ParaUiWindowError paraUiWindowError = new ParaUiWindowError(e.getMsg());
			paraUiWindowError.setVisible(true);
		}
	}

	private void updateAmount(int amountInt) {
		int amountFinal = Integer.valueOf(controllerParaUiGestorBookGraphic.getAmount());
		amountFinal= amountFinal + amountInt;
		if(amountFinal<0) amountFinal=0;
		String finall = String.valueOf(amountFinal);
		HashMap<String, String> order = new HashMap<String, String>();
		order.put("ISBN", this.controllerParaUiGestorBookGraphic.getISBN());
		
		order.put("Amount", finall);
		order.put("procedure", Procedure.updateAmountBook.getSintax());
		
		CommandManagerSetter.getIntance().getCommand(Procedure.updateAmountBook.getValidateName()).execute(order);
		updateTable.createTable();
		this.controllerParaUiGestorBookGraphic.dispose();

	}

}
