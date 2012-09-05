package gen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import stemmer.EnglishStemmer;

import edu.washington.cs.knowitall.morpha.MorphaStemmer;

public class SentenceGenerator {
	class LemmaMe {

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
	class StemMe {

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
				sb.append(st.getCurrent()).append(" ");
			}
			return sb.toString();
		}
		
		
	}
	private LemmaMe lm;
	private StemMe sm;
	private boolean more;
	private final static String path = "./sentences.txt";
	
	public SentenceGenerator () {
		more = true;
		sm = new StemMe();
		lm = new LemmaMe();
	}
	
	public void run () throws IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter(new File(path)));
		while (more) {
			String s = JOptionPane.showInputDialog("Enter sentence");
			StringBuilder sb = new StringBuilder();
			if (s == null)
				break;
			sb.append(s).append("#");
			sb.append(sm.stemToString(s)).append("#");
			sb.append(lm.lemmatizeToString(s)).append("\n");
			br.write(sb.toString());
		}
		br.close();
		JOptionPane.showMessageDialog(null, "End writing!");
	}
	
	public static void main(String[] args) {
		try {
			new SentenceGenerator().run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
