package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.controllersParaUiGraphic.ControllerParaUiGestorBookGraphic;

public class EventEditBook implements ActionListener {
	private ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic;
	private Boolean eventActivo;
	private UpdateTable updateTable;

	public EventEditBook(ControllerParaUiGestorBookGraphic controllerParaUiGestorBookGraphic, UpdateTable updateTable) {
		super();
		this.controllerParaUiGestorBookGraphic = controllerParaUiGestorBookGraphic;
		this.eventActivo = true;
		this.updateTable = updateTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.eventActivo) {
			this.controllerParaUiGestorBookGraphic.loadComboBoxes();
			this.controllerParaUiGestorBookGraphic.setEditableFields(eventActivo);
			this.eventActivo = false;
			this.controllerParaUiGestorBookGraphic.getBtnEdit().setText("Confirm");
		} else {
			UpdateBook ub = new UpdateBook(this.controllerParaUiGestorBookGraphic, this.updateTable);
			ub.eventUpdateBook();
			this.controllerParaUiGestorBookGraphic.setEditableFields(eventActivo);
			this.eventActivo = true;
			this.controllerParaUiGestorBookGraphic.getBtnEdit().setText("Edit");

		}

	}

}
