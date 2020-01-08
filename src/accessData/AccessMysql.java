package accessData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AccessMysql {
	public static final String NAME_BASE = "databookshop";
	private static AccessMysql accessMysql;
    private static Connection connection = null;

    private String DRIVER ;
    private String URL ;
    private String bbdd;
    private String user;
    private String password;

    
    public static AccessMysql instance() {
        if( accessMysql != null){
            	try {
					getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
                createInstance();
        }else{
            createInstance();
        }
        return accessMysql;
    }

    private static void createInstance()  {
        accessMysql = new AccessMysql();
    }

    private AccessMysql()  {
    	loadData();
        this.URL = this.URL.replace("bbdd",bbdd);
        try {
			Class.forName(this.DRIVER);
	        setConnection(DriverManager.getConnection(this.URL, this.user, this.password));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
       }

	private void loadData() {
		try (InputStream input = new FileInputStream("db.properties")) {

			Properties prop = new Properties();

			prop.load(input);

			this.user = prop.getProperty("db.user");
			this.password = prop.getProperty("db.password");
			this.URL = prop.getProperty("db.url");
			this.bbdd = prop.getProperty("db.nameDB");
			this.DRIVER = prop.getProperty("db.driver");
			
			System.out.println(this.user);
			System.out.println(this.password);
			System.out.println(this.URL);
			System.out.println(this.bbdd);
			System.out.println(this.DRIVER);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		AccessMysql.connection = connection;
	}
	
}




