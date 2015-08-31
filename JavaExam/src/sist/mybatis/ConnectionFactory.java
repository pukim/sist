/**
 * 
 */
package sist.mybatis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
/**
 * @author owner
 *
 */
public class ConnectionFactory {
	 private static SqlSessionFactory sqlSessionFactory;
     
	    static{
	        try{
	            String resource = "sist/mybatis/SqlMapConfig.xml";
	            Reader reader = Resources.getResourceAsReader(resource);
	            if(sqlSessionFactory == null){
	                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
//	              sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
	            }
	        }catch(FileNotFoundException e){
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public static SqlSessionFactory getSqlSessionFactory() {
	        return sqlSessionFactory;
	    }

}
