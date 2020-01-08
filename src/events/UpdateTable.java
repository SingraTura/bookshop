package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import Enum.Procedure;
import command.commandGetter.CommandManagerGetter;
import control.controllersParaUiGraphic.ControllerParaUiMainGraphic;

public class UpdateTable implements ActionListener{
	
	private ControllerParaUiMainGraphic controllerParaUiMainGraphic;
	public UpdateTable(ControllerParaUiMainGraphic controllerParaUiMainGraphic)
	{
		this.controllerParaUiMainGraphic=controllerParaUiMainGraphic;
	}
	private String[] createTittles() {
		String[] tittles= {"Tittle", "ISBN", "Author", "Format", "Gender", "State", "NºPages", "Price", "Amount"};
		return tittles;
	}
	public void createTable() {
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("key", controllerParaUiMainGraphic.getTextFilter());
		data.put("procedure", Procedure.getAllBook.getSintax());
		String[][]table= (String[][]) CommandManagerGetter.getIntance().getCommand(Procedure.getAllBook.getValidateName()).execute(data);
		this.controllerParaUiMainGraphic.createTable(this.createTittles(), table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		createTable();
	}
}
