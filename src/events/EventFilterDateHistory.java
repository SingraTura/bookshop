package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.toedter.calendar.JDateChooser;

import Enum.Procedure;
import command.commandGetter.CommandManagerGetter;
import control.paraUis.ParaUiWindowError;

public class EventFilterDateHistory implements ActionListener {
	JDateChooser beginDate;
	private JDateChooser endDate;
	private TableCreator tableCreator;
	private int CAMPOS;
	public EventFilterDateHistory(TableCreator tableCreator, JDateChooser jDateChooser, JDateChooser jDateChooser2) {
		this.beginDate = jDateChooser;
		this.endDate = jDateChooser2;
		this.tableCreator = tableCreator;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.beginDate.getDate() != null) {
			String[][] tableData = getDataTable();
			this.CAMPOS=tableData[0].length;
			String[][] validData = new String[1][this.CAMPOS];
			
			for (int i = 0; i < tableData.length; i++) {
				Date normalDate = castingDate(tableData, i);
				if (compareDate(normalDate)) {
					validData = cloneData(validData, tableData, i);
				}
			}
			this.tableCreator.createTable(this.createTittles(), validData);
		} else {
			ParaUiWindowError err = new ParaUiWindowError("Seleccione una fecha de inicio");
			err.setVisible(true);
		}

	}
	private String[][] cloneData(String[][] validData, String[][] tableData, int index) {
		String[][] newData = new String[validData.length+1][this.CAMPOS];
		for (int j = 0; j < validData.length; j++) {
			for (int k = 0;  k < validData[j].length; k++) {
				newData[j][k] = validData[j][k];
			}
		}
		for(int i=0; i < this.CAMPOS; i++) {
			newData[newData.length-1][i]= tableData[index][i];
		}
		return newData;
	}
	private Date castingDate(String[][] tableData, int i) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date normalDate = null;
		try {
			normalDate = sdf.parse(tableData[i][5]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return normalDate;
	}
	private String[][] getDataTable() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("key", "");
		data.put("procedure", Procedure.getHistory.getSintax());
		String[][] tableData = (String[][]) CommandManagerGetter.getIntance()
				.getCommand(Procedure.getHistory.getValidateName()).execute(data);
		return tableData;
	}
	public String[] createTittles() {
		String[] tittles = {"Tittle", "ISBN", "Operation", "Changes","Total", "Date"};
		return tittles;
	}
	private boolean compareDate(Date normalDate) {
		return normalDate.after(this.beginDate.getDate()) && normalDate.before(this.endDate.getDate());
	}

}
