package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.paraUis.ParaUiAddAuthor;

public class EventOpenAddAuthor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		ParaUiAddAuthor paraUiAddAuthor=new ParaUiAddAuthor();
		paraUiAddAuthor.setVisible(true);
	}
}
