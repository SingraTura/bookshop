package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.paraUis.ParaUiHistory;

public class EventOpenHistory implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ParaUiHistory pa=new ParaUiHistory();
		pa.setVisible(true);
	}

}
