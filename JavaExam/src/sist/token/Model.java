package sist.token;

import java.util.StringTokenizer;

public class Model {
	String name;
	String email;
	String jumin;
	String phone;
	
	static int manCnt;
	static int womanCnt;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
		manCount(jumin);
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setData(StringTokenizer st) {
		int tokenLen = st.countTokens();
		
		//System.out.println("token len : " + tokenLen);
		
		for(int i=0; i<tokenLen; i++) {
			switch(i) {
				case 0 : setName(st.nextToken()); break;
				case 1 : setEmail(st.nextToken()); break;
				case 2 : setJumin(st.nextToken()); break;
				case 3 : setPhone(st.nextToken()); break;
			}
		}
	}
	
	public void  manCount(String jumin) {
		String[] s = jumin.split("-");
		
		if(s.length == 2) {
			if(s[1].substring(0, 1).equals("2")) {
				womanCnt++;
			} else {
				manCnt++;
			}
		} else {
			System.out.println("something wrong.");
		}
	}
	
	public void printManCount() {
		System.out.println("man : " + manCnt + ", woman : " + womanCnt);
	}
	
	public String toString() {
		return getName() + ", " + getEmail() + ", " + getJumin() + ", " + getPhone();
	}
}
