/**
 * 파일 읽어 메모리에 적재
 * singleton pattern 
 */
package sist.exam2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class FileReadData {
	private static FileReadData instance;
	public List<HashMap<String,String>> fdata = new ArrayList<HashMap<String,String>>();
	
	private FileReadData() {
		instance = this;
	}
	
	private  FileReadData(String fname) {
		instance = this;
	}
	
	//
	public static FileReadData getInstance() {
		return instance;
	}
}
