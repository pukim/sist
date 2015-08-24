/**
 * 
 */
package sist.list;

/**
 * @author owner
 *
 */
public class FileLayout {
	String id;
	String code;
	String ip;
	String date;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String toString() {
		return this.id + "," + this.code;
	}
}
