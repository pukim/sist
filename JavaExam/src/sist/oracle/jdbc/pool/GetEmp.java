/**
 * 
 */
package sist.oracle.jdbc.pool;


import java.sql.*;
 

public class GetEmp {
	public static void main(String[] args) {
		
		ConnectionManager conMgr = new OracleConnectionManager();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String query = "SELECT * FROM emp";

		try {
			// �����ͺ��̽��� ������ �����Ѵ�.
			conn = conMgr.getConnection();
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// ResultSet�� �ݴ´�.
				rs.close();
				// Statement�� �ݴ´�.
				stmt.close();
				// Connection �� Ǯ�� ���ͽ�Ų��.
				conMgr.freeConnection(conn);
			} catch (SQLException e) {}
		}
	} // main()�� ��
} // Ŭ������ ��