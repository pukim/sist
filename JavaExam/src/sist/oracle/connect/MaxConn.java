/**
 *  oracle jdbc debugging :
 *  http://javaeesupportpatterns.blogspot.kr/2011/02/enabling-oracle-jdbc-driver-debug.html
 */
package sist.oracle.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List; 

public class MaxConn {
	public static void main(String[] args) {
		String DB_URL = "jdbc:oracle:thin:@211.63.89.161:1521:orcl";
		String DB_USER = "scott";
		String DB_PASSWORD = "tiger";

		//Connection conn = null;
		Statement stmt  = null;
		ResultSet rs    = null;

		List<Connection> cp = new ArrayList<Connection>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			while(true) {
			// 데이터베이스의 연결을 설정한다.
				Connection  conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				cp.add(conn);
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Connected : " + cp.size());
				
				// Connection를 닫는다.
				for(Connection con : cp) {
					con.close();
				}
			} catch ( SQLException e ) {}
		}
	} // main()의 끝
} // 클래스의 끝