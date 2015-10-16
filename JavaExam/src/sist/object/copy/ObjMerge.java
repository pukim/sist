/**
 * http://www.coderanch.com/t/450842/java/java/merging-data-values-similar-objects
 */
package sist.object.copy;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Administrator
 *
 */
class EmpObj {
	private String empno;
	private String ename;
	private int    sal;
	private String deptno;
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
	public String toString() {
		return this.getClass().getName() + " => " + empno + " : " + ename;
	}
	
}

class DeptObj {
	private String deptno;
	private String dname;
	
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String toString() {
		return this.getClass().getName() + " => " +  deptno + " : " + dname;
	}
}

public class ObjMerge {
	
	public void setData(Object o) {
		if(o instanceof EmpObj) {
			((EmpObj) o).setEmpno("15001");
			((EmpObj) o).setEname("sist");
			((EmpObj) o).setSal(30000);
			((EmpObj) o).setDeptno("0100");
		} 
		
		if(o instanceof DeptObj) {
			((DeptObj) o).setDeptno("0100");
			((DeptObj) o).setDname("research");
		}
	}
	
	
	public void getFields(Object o) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = o.getClass().getDeclaredFields();
		Object someObj;
		
		if(o instanceof EmpObj) {
			someObj = (EmpObj)o;
		} else {
			someObj = (DeptObj)o;
		}
		
		if(fields.length > 0) {
			for(Field f : fields) {
				f.setAccessible(true);
				Object value = f.get(someObj);
				System.out.println(f + ", ==> " + f.getName() + " : " + value );
			}
		} else {
			System.out.println("not foudn fields.");
		}
	}
	
	public void getMethodAndValue(Object o) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Object someObj;
		
		if(o instanceof EmpObj) {
			someObj = (EmpObj)o;
		} else {
			someObj = (DeptObj)o;
		}
		
		for (Method method : someObj.getClass().getDeclaredMethods()) {
		    if (Modifier.isPublic(method.getModifiers())
		        && method.getParameterTypes().length == 0
		        && method.getReturnType() != void.class
		        && (method.getName().startsWith("get") || method.getName().startsWith("is"))
		    ) {
		        Object value = method.invoke(someObj);
		        if (value != null) {
		            System.out.println(method.getName() + "=" + value);
		        }
		    }
		}
	}
	
	public Map<String, Object> getNonNullProperties(final Object thingy) {
	    final Map<String, Object> nonNullProperties = new TreeMap<String, Object>();
	    try {
	        final BeanInfo beanInfo = Introspector.getBeanInfo(thingy
	                .getClass());
	        for (final PropertyDescriptor descriptor : beanInfo
	                .getPropertyDescriptors()) {
	            try {
	                final Object propertyValue = descriptor.getReadMethod()
	                        .invoke(thingy);
	                if (propertyValue != null) {
	                    nonNullProperties.put(descriptor.getName(),
	                            propertyValue);
	                }
	            } catch (final IllegalArgumentException e) {
	                // handle this please
	            } catch (final IllegalAccessException e) {
	                // and this also
	            } catch (final InvocationTargetException e) {
	                // and this, too
	            }
	        }
	    } catch (final IntrospectionException e) {
	        // do something sensible here
	    }
	    return nonNullProperties;
	}
	
	public static void main(String[] args) {
		
		ObjMerge om = new ObjMerge();
		
		EmpObj  emp  = new EmpObj();
		DeptObj dept = new DeptObj();
		
		om.setData(emp);
		om.setData(dept);
		
		System.out.println(emp);
		System.out.println(dept);
		
		try {
			om.getFields(emp);
			System.out.println("====================================================");
			//om.getFields(dept);
			om.getMethodAndValue(dept);
		} catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
}
