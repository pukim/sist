/**
 * 
 */
package sist.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 */
public class CallProc {
	public static void main(String[] args) {
	//	String DB_URL = "jdbc:oracle:thin:@211.63.89.161:1521:orcl";
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl2";
		String DB_USER     = "scott";
		String DB_PASSWORD = "tiger";

		Connection conn      = null;
		CallableStatement cs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			cs = conn.prepareCall("{call Hell_world(?)}");
			cs.setString(1,  "Procedure call");
			
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			try {
				cs.close();
				conn.close();
			} catch ( SQLException e ) {}
		}
	}
}
