package gen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

import logic.LemmaMe;
import logic.StemMe;

public class SentenceGenerator {

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
