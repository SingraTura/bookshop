package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controllersParaUiGraphic.ControllerParaUiMainGraphic;
import control.paraUis.ParaUiAddBook;

public class EventOpenAddBook implements ActionListener{
	ControllerParaUiMainGraphic controllerParaUiMainGraphic;
	public EventOpenAddBook(ControllerParaUiMainGraphic controllerParaUiMainGraphic) {
		super();
		this.controllerParaUiMainGraphic=controllerParaUiMainGraphic;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ParaUiAddBook paraUiAddBook =new ParaUiAddBook(this.controllerParaUiMainGraphic);
		paraUiAddBook.setVisible(true);
	}
}
