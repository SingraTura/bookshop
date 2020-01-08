package accessData;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SetterDAO{
	private static SetterDAO setterController;
	private  SetterDAO () {
		AccessMysql.instance();
	}
	public static SetterDAO instance() {
		if (setterController == null) setterController=new SetterDAO();
		return setterController;
	}
	
	public Boolean call(String procedure, ArrayList<String> dataBook) {
		CallableStatement call;
		try {
			call = (CallableStatement) AccessMysql.getConnection().prepareCall(procedure);
			for (int i = 0; i < dataBook.size(); i++) {
				call.setString(i+1, dataBook.get(i));
				System.out.print(dataBook.get(i) + " ");
			}
			call.execute();
			return true;
	        
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
