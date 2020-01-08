package control.paraUis;

import Enum.Procedure;
import control.controllersParaUiGraphic.ControllerParaUiAddBookGraphic;
import control.controllersParaUiGraphic.ControllerParaUiMainGraphic;
import events.EventAddBook;
import events.EventExit;
import events.EventOpenAddAuthor;
import events.EventOpenGestorAtribbute;
import events.LoadComboBox;
import view.UILibraryAddBook;

public class ParaUiAddBook extends UILibraryAddBook{
	private static final long serialVersionUID = 1L;
	public ParaUiAddBook(ControllerParaUiMainGraphic controllerParaUiMainGraphic) {
		super();
		ControllerParaUiAddBookGraphic controllerParaUiAddBookGraphic = new ControllerParaUiAddBookGraphic(this);
		this.loadComboBoxes();
		this.loadEvent(controllerParaUiAddBookGraphic, controllerParaUiMainGraphic);
	}
	private void loadEvent(ControllerParaUiAddBookGraphic controllerParaUiAddBookGraphic, ControllerParaUiMainGraphic controllerParaUiMainGraphic) {
		this.getBtnAddBook().addActionListener(new EventAddBook(controllerParaUiAddBookGraphic,controllerParaUiMainGraphic));
		this.getBtnClose().addActionListener(new EventExit(this));
		this.getBtnAddAuthor().addActionListener(new EventOpenAddAuthor());
		this.getBtnAddFormat().addActionListener(new EventOpenGestorAtribbute("Format", 
				Procedure.getAllFormat.getSintax(),
				Procedure.addFormat.getSintax(),
				Procedure.removeFormat.getSintax()));
		this.getBtnAddState().addActionListener(new EventOpenGestorAtribbute("State", 
				Procedure.getAllState.getSintax(),
				Procedure.addState.getSintax(),
				Procedure.removeState.getSintax()));
		this.getBtnAddTheme().addActionListener(new EventOpenGestorAtribbute("Theme", 
				Procedure.getAllTheme.getSintax(),
				Procedure.addTheme.getSintax(),
				Procedure.removeTheme.getSintax()));
		
	}
	private void loadComboBoxes() {
		LoadComboBox loader = new LoadComboBox();
		loader.event(this.getCmbAuthor(),Procedure.getAllAuthor.getSintax());
		loader.event(this.getCmbGender(),Procedure.getAllTheme.getSintax());
		loader.event(this.getCmbFormat(),Procedure.getAllFormat.getSintax());
		loader.event(this.getCmbState(),Procedure.getAllState.getSintax());
	}
}
