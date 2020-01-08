package control.paraUis;

import events.LoadComboBox;
import events.addAtribbute;
import view.UIAddAtribbutte;

public class ParaUiGestorAtribbute extends UIAddAtribbutte{
	private static final long serialVersionUID = 1L;
	public ParaUiGestorAtribbute(String nameAtribbute, String procedureGet, String procedureSetAdd, String procedureSetRemove) {
		super();
		
	    this.initComponent(nameAtribbute, procedureGet);
		this.loadEvents(procedureSetAdd, procedureSetRemove);
	}

	private void loadEvents(String procedureSetAdd, String procedureSetRemove) {
		this.getBtnAdd().addActionListener(new addAtribbute(procedureSetAdd, this.getTxtAtribbute()));
		this.getBtnRemove().addActionListener(new addAtribbute(procedureSetRemove, this.getCmbAtribbute()));
	}

	private void initComponent(String nameAtribbute, String procedureGet) {
		this.getLblAtribbute().setText(nameAtribbute);
		(new LoadComboBox()).event(this.getCmbAtribbute(), procedureGet);
	}
}
