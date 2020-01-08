package control.paraUis;



import Enum.Procedure;
import control.controllersParaUiGraphic.ControllerParaUiAddAutorGraphic;
import events.EventAddAuthor;
import events.EventExit;
import events.LoadComboBox;
import view.UIAddAuthor;

public class ParaUiAddAuthor extends UIAddAuthor{
	private static final long serialVersionUID = 1L;
	public ParaUiAddAuthor()
	{
		super();
		ControllerParaUiAddAutorGraphic controlGraphic= new ControllerParaUiAddAutorGraphic(this);
		this.initComponent();
		this.loadEvents(controlGraphic);
	}

	private void loadEvents(ControllerParaUiAddAutorGraphic controlGraphic) {
		this.getBtnAdd().addActionListener(new EventAddAuthor(controlGraphic));
		this.getBtnCancel().addActionListener(new EventExit(this));
	}
	private void initComponent() {
		(new LoadComboBox()).event(this.getCmbGenderAuthor(),Procedure.getAllTheme.getSintax());
	}

	
}
