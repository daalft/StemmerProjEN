package logic;

import java.util.ArrayList;

import stemmer.EnglishStemmer;

public class StemMe {

	private ArrayList<String> a;
	
	public StemMe () {
		
	}
	
	public ArrayList<String> stem (String s) {
		a = new ArrayList<String>();
		EnglishStemmer st = new EnglishStemmer();
		for (String p : s.split(" ")) {
			st.setCurrent(p.toLowerCase());
			st.stem();
			a.add(st.getCurrent());
		}
		return a;
	}
	
	public String stemToString (String s)  {
		StringBuilder sb = new StringBuilder();
		EnglishStemmer st = new EnglishStemmer();
		for (String p : s.split(" ")) {
			st.setCurrent(p.toLowerCase());
			st.stem();
			sb.append(st.getCurrent());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		StemMe test =new StemMe();
		
			for (String s : test.stem("Never fearing the worst of fears from hedges")) {
				System.out.println(s);
			}
		
	}
}
