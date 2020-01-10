package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import control.paraUis.ParaUiWindowError;

public class EvenGetBestSeller implements ActionListener {
	TableCreator tableCreator;
	JDateChooser beginDate;
	JDateChooser endDate;
	private int CAMPOS;
	public EvenGetBestSeller(TableCreator tableCreator, JDateChooser dateBegin, JDateChooser dateEnd) {
		this.beginDate=dateBegin;
		this.endDate=dateEnd;
		this.tableCreator=tableCreator;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.beginDate.getDate() != null) { 
			String[][] dataTableWithoutFilter = this.tableCreator.getDataTableHistory();
			this.CAMPOS=dataTableWithoutFilter[0].length;
			String[][] dataTable = this.getValidData(dataTableWithoutFilter);
			this.getBestSeller(dataTable);
		} else {
			ParaUiWindowError err = new ParaUiWindowError("Seleccione una fecha de inicio");
			err.setVisible(true);
		}
	}
	private void getBestSeller(String[][] dataTable) {
		int max=0;
		String tittle=null;
		for (int i = 0; i < dataTable.length; i++) {
			for (int j = 0; j < dataTable[i].length; j++) {
				if(dataTable[i][j] != null)
				if(j == 2 && dataTable[i][j].equals("Amount decreased")) {
					if(Integer.valueOf(dataTable[i][j+1]) >= max) {
						max=Integer.valueOf(dataTable[i][j+1]);
						tittle=dataTable[i][0];
					};
				}
			}
		}
		ParaUiWindowError err = new ParaUiWindowError(tittle);
		err.setVisible(true);
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
