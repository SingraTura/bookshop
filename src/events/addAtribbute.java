package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import command.commandSetter.CommandManagerSetter;

public class addAtribbute implements ActionListener {
	String procedure;
	JComboBox<String> combo;
	JTextField txt;
	public addAtribbute(String procedureSetAdd, JComboBox<String> jComboBox) {
		this.procedure=procedureSetAdd;
		this.combo=jComboBox;
	}

	public addAtribbute(String procedureSetAdd, JTextField txtAtribbute) {
		this.procedure=procedureSetAdd;
		this.txt= txtAtribbute;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		HashMap<String,String> order = new HashMap<String,String>();
		order.put("procedure", procedure);
		if(txt!=null) {
			order.put("name", txt.getText());
		} else {
			order.put("name", combo.getSelectedItem().toString());
		}
		
		CommandManagerSetter.getIntance().getCommand("SetterModifyAtributte").execute(order);
	}

}
