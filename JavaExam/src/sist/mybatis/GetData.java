/**
 * 
 */
package sist.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.*;
/**
 * @author owner
 *
 */
public class GetData {
	private SqlSessionFactory sqlSessionFactory;
	
	public GetData() {
		sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
	}
	

	public void getEmp() {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.selectMap("sample", "");
		} catch(Exception e) {
	        session.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
}
