package logic;

import java.util.ArrayList;

import edu.washington.cs.knowitall.morpha.MorphaStemmer;

public class LemmaMe {

	private ArrayList<String> a;
	
	public LemmaMe () {
		a = new ArrayList<String>();
	}
	
	public ArrayList<String> lemmatize (String s) {
		String[] sp = s.split(" ");
		MorphaStemmer ms = new MorphaStemmer();
		for (String p : sp) {
			a.add(ms.morpha(p.toLowerCase()));
		}
		return a;
	}
	
	public String lemmatizeToString (String s) {
		String[] sp = s.split(" ");
		StringBuilder sb = new StringBuilder();
		MorphaStemmer ms = new MorphaStemmer();
		for (String p : sp) {
			sb.append(ms.morpha(p.toLowerCase())).append(" ");
		}
		return sb.toString();
	}
	
}
