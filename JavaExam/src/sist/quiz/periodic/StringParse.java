/**
 * 
 */
package sist.quiz.periodic;

import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class StringParse {
	
/*
No PaIN, No CaNDy. 
ReVOLuTION IS HeRe.
He KNOWS ThAt SHe IS NiCe.
PSY NeVEr LiKEs SWISS SOCCEr.
HIS BODy LiNe IS WOW!
NOBPdy LiKEs U.
WOW, SHe HAs NO PaNTiEs.
He LiKEs PaSTa.
I Am VIP.

그 중 최고로 긴 문장... 

As YOU KNOW MoNaCO'S PrInCess IS CuTE, WHOSE HoBBY IS LiSTeNInG PINK'S Cd.

다음은 전화영샘이 수업하시고 얻은 결과물

I Am SUPEr PSYCo. 
He IS CLONe. 
I Am SAm. 
He LiKEs MoNeY. 
CF IS FUN. 
I Am KINd. 
He LiVEs In AmErICa. ( He LiVEs In UFO.) 
He HAs WHITe BaNaNa. 
LuCY In THe SKY WITh BeAt. 
SHe WaS NICe TeAcHEr.
출처:주기율표 원소기호로 문장만들기
*/
	
	 
	static String[] pt = {
			"H" ,  "He",  "Li",  "Be", "B" , "C" , "N" , "O",  "F" ,  "Ne",
			"Na",  "Mg",  "Al",  "Si", "P" , "S" , "Cl", "Ar", "K" ,  "Ca",
			"Sc",  "Ti",  "V" ,  "Cr", "Mn", "Fe", "Co", "Ni", "Cu",  "Zn",
			"Ga",  "Ge",  "As",  "Se", "Br", "Kr", "Rb", "Sr", "Y" ,  "Zr", 
			"Nb",  "Mo",  "Tc",  "Ru", "Rh", "Pd", "Ag", "Cd", "In",  "Sn",
			"Sb",  "Te",  "I",   "Xe", "Cs", "Ba", "La", "Ce", "Pr",  "Nd",
			"Pm",  "Sm",  "Eu",  "Gd", "Tb", "Dy", "Ho", "Er", "Tm",  "Yb",
			"Lu",  "Hf",  "Ta",  "W" , "Re", "Os", "Ir", "Pt", "Au",  "Hg",
			"Tl",  "Pb",  "Bi",  "Po", "At", "Rn", "Fr", "Ra", "Ac",  "Th",
			"Pa",  "U" ,  "Np",  "Pu", "Am", "Cm", "Bk", "Cf", "Es",  "Fm",
			"Md",  "No",  "Lr",  "Rf", "Db", "Sg", "Bh", "Hs", "Mt",  "Ds",
			"Rg",  "Cn",  "Uut", "Fl", "Uup","Lv", "Uus","Uuo" 
	};
	 
	
	
	public void testMethod() {
		PeriodicTable[] pt = PeriodicTable.values();
		
		for(PeriodicTable pv : pt) {
			System.out.println(pv + ", " + pv.getValue());
		}
	}
	
	public boolean findTable(String s) {
		boolean bool = false;
		int idx = 1;
		
		for(String ss : pt) {
			if(ss.toUpperCase().equals(s.toUpperCase())) { 
				bool = true; 
				System.out.println(s + " : " + ss + "(" + idx + ")");
				break;
			}
			idx++;
		}
		return bool;
	}
	
	public boolean divWord(String s, int step) {
		int len = s.length();
		int sp, ep;
		int cnt=0;
		sp = ep = 0;
		
		for(int i = 0; i < len; i++) {
			sp = i;
			ep = sp+step;
			if(ep <= len) {
				if(findTable(s.substring(sp, ep))) {
					cnt++;
				} else {
					ep = sp+step+1;
					if(ep <= len) {
						if(findTable(s.substring(sp, ep))) {
							cnt=cnt+2;
						}else {
							ep = sp+step+1;
							if(ep <= len) {
								if(findTable(s.substring(sp, ep))) {
									cnt=cnt+3;
								}		
							}
						}
					}
				}
				//System.out.println(s + "=>" + s.substring(sp, ep));
				sp = ep;
			}
		}
		
		System.out.println("len =" + len + ", " + cnt);
		
		if(len == cnt) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		StringParse sp = new StringParse();
		
		//sp.testMethod();
		//String str = "I Am SUPEr PSYCo";
		String str = "ReVOLuTION IS HeRe";
		
		String words[] = str.split(" ");
		
		for(String ds : words) 
			System.out.println(ds);
		System.out.println("================================================");
		/*
		for(String s : pt) {
			String pattern = "[" + s + "]+";
			//Pattern p = Pattern.compile("(aa|aab?)+");
			Pattern p = Pattern.compile(pattern);
			if (p.matcher(str).matches()) {
				System.out.println(s);
			} else {
				System.out.println("xxx => " + s);
			}
		}
		*/
		
		/*
		for(String t : words) {
			if(t.length() == 1 || t.length() == 2) {
				sp.findTable(t);
			} else {
				if(sp.divWord(t, 1)) {
					System.out.println("Ok");
				} else {
					System.out.println("No Good");
				}
			}
		}
		*/
		int idx = 0;
		for(String s : pt) {
		   idx++;
		   for(String w : words) {
				if(s.toUpperCase().equals(w.substring(0, s.length()).toUpperCase())) {
					System.out.println(s + "(" + idx + ")");
				}
			}
		}
		
	}
}
