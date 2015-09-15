/**
 * 
 */
package sist.mybatis;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * @author owner
 *
 */
public class GetData {
	private SqlSessionFactory sqlSessionFactory;
	
	public GetData() {
		sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	}
	

	public HashMap getEmp(String val) {
		SqlSession session = sqlSessionFactory.openSession();
		HashMap hm = new HashMap();
		
		try {
			hm = (HashMap)session.selectMap("sample.getEmp", val);
		} catch(Exception e) {
	        session.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		System.out.println("date " + hm);
		return hm;
	}
}
