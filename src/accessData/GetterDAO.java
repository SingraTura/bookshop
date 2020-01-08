package accessData;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class GetterDAO {
	private static GetterDAO getterController;
	public final static String SEPARATOR_OBJECT = "@";
	public final static String SEPARATOR_ATRIBUTE = "%";
	private GetterDAO () {
		AccessMysql.instance();
	}
	public static GetterDAO instance() {
		if(getterController == null) getterController = new GetterDAO();
		return getterController;
	}
	public String call(String procedure) {
    	CallableStatement cstmt;
		try {
			cstmt = (CallableStatement) AccessMysql.getConnection().prepareCall(procedure);
	        cstmt.registerOutParameter(1, Types.VARCHAR);
	        cstmt.execute();
			return cstmt.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }
	public String call(String procedure, String key) {
    	CallableStatement cstmt;
    	
		try {
			cstmt = (CallableStatement) AccessMysql.getConnection().prepareCall(procedure);
			cstmt.setString(1, key);
			cstmt.registerOutParameter(2, Types.VARCHAR);
	        cstmt.execute();
			return cstmt.getString(2);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
