package conn;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Conn {

	public static Connection getConnection() throws Exception{
		Context initCtx=new InitialContext();
		Context envCtx=(Context)initCtx.lookup("java:comp/env");
		
		DataSource ds=(DataSource)envCtx.lookup("jdbc/skhuclub");
		
		return ds.getConnection();
	}
}
