/**
 * 
 */
package sist.oracle.jdbc.pool;


import java.sql.*;
import java.util.*;


public class DBConnectionPoolManager {
	// DBConnectionPoolManager �� �̱��� ������ �����ϱ� ����(�ν��Ͻ��� �ϳ��� ����) static ���� ����
	static private DBConnectionPoolManager instance;
	private Vector<String> drivers = new Vector<String>();
	private Hashtable<String, DBConnectionPool> pools = new Hashtable<String, DBConnectionPool>();
	
	// DBConnectionPoolManager�� instance�� ����
	// @return DBConnectionManger
	static synchronized public DBConnectionPoolManager getInstance() {
		if (instance == null) {
			instance = new DBConnectionPoolManager();
		}
		
		return instance;
	}
	
	// Default Constructor
	private DBConnectionPoolManager() {}
	
	// ���� Connection�� Free Connection List�� ����
	// @param name : Pool Name
	// @param con : Connection
	public void freeConnection(String name, Connection con) {
		DBConnectionPool pool = (DBConnectionPool) pools.get(name);
		if (pool != null) {
			pool.freeConnection(con);
		}
		
		Log.out("One Connection of " + name + " was freed");
	}
	
	// Open Connection�� ����. ���� ���� Ŀ�ؼ��� ���� �ִ� Ŀ�ؼ� ������
	// ��� ���� �ƴ� ���� ���ο� Ŀ�ؼ��� ����. ���� ���� Ŀ�ؼ��� ����
	// �ִ� Ŀ�ؼ� ������ ��� ���� �� �⺻ ��� �ð��� ��ٸ�
	// @param name : Pool Name
	// @return Connection : The connection or null
	public Connection getConnection(String name) {
		DBConnectionPool pool = (DBConnectionPool) pools.get(name);
		if (pool != null) {
			return pool.getConnection(10);
		}
		return null;
	}
	
	// Connection Pool�� ����
	// @param poolName : ������ Pool Name
	// @param url : DB URL
	// @param user : DB UserID
	// @param password : DB Password
	private void createPools(String poolName, 
			String url, 
			String user,
			String password, 
			int maxConn, 
			int initConn, 
			int maxWait) {
			
		DBConnectionPool pool = new DBConnectionPool(poolName, url, user, password, maxConn, initConn, maxWait);
		pools.put(poolName, pool);
		Log.out("Initialized pool " + poolName);
	}
	
	// �ʱ�ȭ �۾�
	public void init(String poolName, 
			String driver, 
			String url,
			String user, 
			String passwd, 
			int maxConn, 
			int initConn, 
			int maxWait) {
			
		loadDrivers(driver);
		createPools(poolName, url, user, passwd, maxConn, initConn, maxWait);
	}
	
	// JDBC Driver Loading
	// @param driverClassName : ����ϰ��� �ϴ� DB�� JDBC ����̹�
	private void loadDrivers(String driverClassName) {
		try {
			Class.forName(driverClassName);
			drivers.addElement(driverClassName);
			Log.out("Registered JDBC driver " + driverClassName);
		} catch (Exception e) {
			Log.err(e, "Can't register JDBC driver: " + driverClassName);
		}
	}
	
	public Hashtable<String,DBConnectionPool> getPools() {
		return pools;
	}
	
	public int getDriverNumber() {
		return drivers.size();
	}
	
}