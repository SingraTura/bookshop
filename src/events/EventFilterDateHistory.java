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
	public EventFilterDateHistory(TableCreator tableCreator, JDateChooser beginDate, JDateChooser endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.tableCreator = tableCreator;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.beginDate.getDate() != null) { 
			String [] tittles= this.tableCreator.createTittlesHistory();
			String[][] dataTableWithoutFilter = this.tableCreator.getDataTableHistory();
			this.CAMPOS=dataTableWithoutFilter[0].length;
			String[][] dataTable = this.getValidData(dataTableWithoutFilter);
			this.tableCreator.createTable(tittles,dataTable);
		} else {
			ParaUiWindowError err = new ParaUiWindowError("Seleccione una fecha de inicio");
			err.setVisible(true);
		}

	}

	private String[][] getValidData(String[][] tableData) {
		String[][] validData = new String[1][this.CAMPOS];
		for (int i = 0; i < tableData.length; i++) {
			Date normalDate = castingDate(tableData, i);
			if (compareDate(normalDate)) {
				validData = cloneData(validData, tableData, i);
			}
		}
		return validData;
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
	
	
	private boolean compareDate(Date normalDate) {
		boolean afterBeginDate = normalDate.after(this.beginDate.getDate());
		boolean beforeEndDate = normalDate.before(this.endDate.getDate());
		
		return  afterBeginDate && beforeEndDate;
	}
	
}
