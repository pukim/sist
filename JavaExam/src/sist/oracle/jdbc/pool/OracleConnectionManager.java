/**
 * 
 */
package sist.oracle.jdbc.pool;


public class OracleConnectionManager extends ConnectionManager {

	public OracleConnectionManager() {
		super("oracle");
		String JDBCDriver = "oracle.jdbc.driver.OracleDriver";
		// ����Ŭ�� JDBC thin driver
		String JDBCDriverType = "jdbc:oracle:thin";
		String url = JDBCDriverType + ":@" + dbServer + ":" + port + ":" + dbName;
		connMgr = DBConnectionPoolManager.getInstance();
		connMgr.init(poolName, JDBCDriver, url, userID, passwd, maxConn, initConn, maxWait);
	}
}