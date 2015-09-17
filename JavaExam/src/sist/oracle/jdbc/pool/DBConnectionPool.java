/**
 * 
 */
package sist.oracle.jdbc.pool;


import java.util.*; 
import java.sql.*; 
import java.util.Date; 

// Connection Pool�� �����ϴ� Ŭ���� 
class DBConnectionPool {
	// ���� ��� ���� Connection ����
	private int checkedOut;
	
	// Free Connection List
	private Vector<Connection> freeConnections = new Vector<Connection>();
	
	// Connection �ִ� ����
	private int maxConn;
	
	// Connection �ʱ� ����
	private int initConn;
	
	// Waiting time (pool�� connection�� ������ ��ٸ��� �ִ�ð�)
	private int maxWait;
	
	// Connection Pool Name
	private String name;
	
	// DB Password
	private String password;
	
	// DB URL
	private String URL;
	
	// DB UserID
	private String user;
	
	// Constructor
	public DBConnectionPool(String name, 
			String URL, 
			String user, 
			String password, 
			int maxConn, 
			int initConn, 
			int waitTime) {
			
		this.name = name;
		this.URL = URL;
		this.user = user;
		this.password = password;
		this.maxConn = maxConn;
		this.maxWait = waitTime;
		
		for (int i = 0; i < initConn; i++) {
			freeConnections.addElement(newConnection());
		}
	}
	
	// Connection �ݳ�
	// @param con : �ݳ��� Connection
	public synchronized void freeConnection(Connection con) {
		freeConnections.addElement(con);
		checkedOut--;
		// Connection�� ��� ���� ����ϰ� �ִ� thread�� �˸�
		notifyAll();
	}
	
	// Connection �� ����
	public synchronized Connection getConnection() {
		Connection con = null;
		// Connection�� Free List�� ������ List�� ó�� ���� ����
		if (freeConnections.size() > 0) {
			con = (Connection) freeConnections.firstElement();
			freeConnections.removeElementAt(0);
			
			try {
				// DBMS�� ���� Connection�� close �Ǿ����� �ٽ� �䱸
				if (con.isClosed()) {
					Log.err("Removed bad connection from " + name);
					con = getConnection();
				}
			} // ����� Connection �߻��ϸ� �ٽ� �䱸
			catch (SQLException e) {
				Log.err(e, "Removed bad connection from " + name);
				//con = getConnection();
			}
		} // Connection�� Free List�� ������ ���� ����
		else if (maxConn == 0 || checkedOut < maxConn) {
			con = newConnection();
		}
		
		if (con != null) {
			checkedOut++;
		}
		
		return con;
	}
	
	// Connection�� ����
	// @param timeout : Connection�� ��� ���� �ִ� ��ٸ� �ð�
	public synchronized Connection getConnection(long timeout) {
		long startTime = new Date().getTime();
		Connection con;
		while ((con = getConnection()) == null) {
			try {
				wait(timeout * maxWait);
			} catch (InterruptedException e) {}
			if ((new Date().getTime() - startTime) >= timeout) {
				// ��ٸ� �ð� �ʰ�
				return null;
			}
		}
		
		return con;
	}
	
	// Connection ����
	private Connection newConnection() {
		Connection con = null;
		try {
			if (user == null) {
				con = DriverManager.getConnection(URL);
			} else {
				con = DriverManager.getConnection(URL, user, password);
			}
			Log.out("Created a new connection in pool " + name);
		} catch (SQLException e) {
			StringBuffer sb = new StringBuffer();
			sb.append("Can't create a new connection for ");
			sb.append(URL);
			sb.append(" user: ");
			sb.append(user);
			sb.append(" passwd: ");
			sb.append(password);
			Log.err(e, sb.toString());
			return null;
		}
		
		return con;
	}
	
}