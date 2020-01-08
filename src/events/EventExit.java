package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.paraUis.ParaUiAddAuthor;
import control.paraUis.ParaUiAddBook;
import control.paraUis.ParaUiMain;

public class EventExit  implements ActionListener{
	ParaUiAddAuthor paraUiAddAuthor;
	ParaUiAddBook paraUiAddBook;
	ParaUiMain paraUiMain;
	public EventExit(ParaUiAddBook paraUi)
	{
		paraUiAddAuthor=null;
		paraUiMain=null;
		paraUiAddBook=paraUi;
	}
	public EventExit(ParaUiAddAuthor paraUi)
	{
		paraUiAddAuthor=paraUi;
		paraUiMain=null;
		paraUiAddBook=null;
	}
	public EventExit(ParaUiMain paraUi)
	{
		paraUiAddAuthor=null;
		paraUiMain=paraUi;
		paraUiAddBook=null;
	}
	@Override
	public void actionPerformed(ActionEvent pressButton) {
		if(paraUiAddAuthor!=null) paraUiAddAuthor.dispose();
		if(paraUiAddBook!= null) paraUiAddBook.dispose();
		if(paraUiMain!=null) System.exit(0);
	}
}
