/**
 *  oracle jdbc debugging :
 *  http://javaeesupportpatterns.blogspot.kr/2011/02/enabling-oracle-jdbc-driver-debug.html
 */
package sist.oracle;

import java.sql.*; 

public class GetEmp {
	public static void main(String[] args) {
	//	String DB_URL = "jdbc:oracle:thin:@211.63.89.161:1521:orcl";
		String DB_URL = "jdbc:oracle:thin:@211.63.89.210:1521:orcl2";
		String DB_USER = "scott";
		String DB_PASSWORD = "tiger";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String query = "SELECT * FROM emp";
		try {
			// ����̹��� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		}

		try {
			// �����ͺ��̽��� ������ �����Ѵ�.
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// Statement�� �����´�.
			stmt = conn.createStatement();

			// SQL���� �����Ѵ�.
			rs = stmt.executeQuery(query);

			while (rs.next()) { 
				String empno = rs.getString(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				String mgr = rs.getString(4);
				String hiredate = rs.getString(5);
				String sal = rs.getString(6);
				String comm = rs.getString(7);
				String depno = rs.getString(8);
				// ����� ����Ѵ�.
				System.out.println( 
					empno + " : " + ename + " : " + job + " : " + mgr
					+ " : " + hiredate + " : " + sal + " : " + comm + " : "
				+ depno); 
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			try {
				// ResultSet�� �ݴ´�.
				rs.close();
				// Statement�� �ݴ´�.
				stmt.close();
				// Connection�� �ݴ´�.
				conn.close();
			} catch ( SQLException e ) {}
		}
	} // main()�� ��
} // Ŭ������ ��