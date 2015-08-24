package sist.token;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Token {
	public static void main(String[] args) {
		
		//String expression = "x=100*(200+300)/2";
		String []expression={ "ÁÖÁø¿Ï/say@nate.com/931205-2010452/02)457-1234",
				              "±è¼öºó/blue@nate.com/880207-2010152/051)257-1234",
			                  "ÃÖ¿µÃ¶/red@naver.com/580512-1019452/041)357-1234"};

		List<Model> lt = new ArrayList<Model>();
		for(String s : expression) {
		
			StringTokenizer st = new StringTokenizer(s, "/", false);
			
			while(st.hasMoreTokens()) {
				Model m = new Model();
				//System.out.println(st.nextToken());
				m.setData(st);
				lt.add(m);
			}
		}
		
		System.out.println(lt.size());
		for(Model m : lt) {
			System.out.println(m);
		}
		
		Model m = new Model();
		m.printManCount();
	}
}
