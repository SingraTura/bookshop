package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.paraUis.ParaUiGestorAtribbute;

public class EventOpenGestorAtribbute implements ActionListener {
	String nameAtribbute, procedureGet, procedureSetAdd, procedureSetRemove;
	public EventOpenGestorAtribbute(String nameAtribbute, String procedureGet, String procedureSetAdd, String procedureSetRemove ) {
		this.nameAtribbute=nameAtribbute;
		this.procedureGet=procedureGet;
		this.procedureSetAdd= procedureSetAdd;
		this.procedureSetRemove = procedureSetRemove;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ParaUiGestorAtribbute p = new ParaUiGestorAtribbute(nameAtribbute, procedureGet, procedureSetAdd, procedureSetRemove);
		p.setVisible(true);
	}

}
