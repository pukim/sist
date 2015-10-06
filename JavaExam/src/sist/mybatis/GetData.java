/**
 * 
 */
package sist.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
	

	public ArrayList getEmp(String val) {
		SqlSession session = sqlSessionFactory.openSession();
		
		ArrayList result = null;
		
		try {
			result = (ArrayList)session.selectList("getEmpList");
		} catch(Exception e) {
	        session.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		
		return result;
	}
	
	public HashMap getMap(String val) {
        SqlSession session = sqlSessionFactory.openSession();
		
		HashMap result = null;
		HashMap param  = new HashMap();
		String emp_no  = val;
		
		param.put("emp_no", val);
		
		try {
			//result = (HashMap)session.selectMap("sample.getEmp", emp_no);
			result = (HashMap)session.selectMap("sample.getEmp", param, "emp_no");
		
		} catch(Exception e) {
	        session.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		
		return result;
		
	}
	
}
