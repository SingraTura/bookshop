package events;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;

import command.commandGetter.CommandManagerGetter;

public class LoadComboBox {
	
	
	@SuppressWarnings("unchecked")
	public void event(JComboBox<String> combo, String procedure) {
		
		ArrayList<String> dataTest = new ArrayList<String>();
		HashMap<String,String> order = new HashMap<String, String>();
		order.put("procedure", procedure);
		
		
		dataTest=(ArrayList<String>) CommandManagerGetter.getIntance().getCommand("GetterAllFieldsWithoutFilter").execute(order);
		String[] data= new String[dataTest.size()];
		for (int i = 0; i < data.length; i++) {
			data[i]=dataTest.get(i);
		}
		this.addCombo(data,combo);
	}

	private void addCombo(String[] data,JComboBox<String> combo) {
		for (String dataValue : data) {
			combo.addItem(dataValue);
		}
	}

}
