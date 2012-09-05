package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class LemmaTest extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String path = "./sentences.txt";
	private JLabel infotexttitle;
	private JLabel infotext2;
	private JLabel infotext3;
	private JLabel infotext4;
	private JTextArea input;
	private JTextArea show;
	private JLabel infotext5;
	private JLabel infotext6;
	private JButton sButton;
	private JButton rButton;
	private Random r;
	private ArrayList<String> sentences;
	private String gold, sent;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new LemmaTest());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public LemmaTest() throws IOException {
		super();
		initGUI();
		r = new Random();
		sentences = new ArrayList<String>();
		readSentences(path);
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(500, 400));
			this.setLayout(null);
			{
				infotexttitle = new JLabel();
				this.add(infotexttitle);
				infotexttitle.setText("Step 2 - Lemmatizer");
				infotexttitle.setBounds(12, 12, 476, 22);
				infotexttitle.setFont(new java.awt.Font("Segoe UI",1,16));
			}
			{
				infotext2 = new JLabel();
				this.add(infotext2);
				infotext2.setText("In this step, you can test your newly gained knowledge.");
				infotext2.setBounds(12, 46, 476, 16);
			}
			{
				infotext3 = new JLabel();
				this.add(infotext3);
				infotext3.setText("Click \"New Sentence\" to get a sentence, then enter your guess and click \"Right ?\"");
				infotext3.setBounds(12, 74, 476, 16);
			}
			{
				infotext4 = new JLabel();
				this.add(infotext4);
				infotext4.setText("When you feel confident enough, press \"Next\"");
				infotext4.setBounds(12, 102, 476, 16);
			}
			{
				input = new JTextArea();
				this.add(input);
				input.setText("Your guess!");
				input.setBounds(12, 262, 476, 64);
				input.setEditable(false);
			}
			{
				show = new JTextArea();
				this.add(show);
				show.setText("Sentence will appear here.");
				show.setBounds(12, 165, 476, 63);
				show.setEditable(false);
			}
			{
				infotext5 = new JLabel();
				this.add(infotext5);
				infotext5.setText("Enter your guess here");
				infotext5.setBounds(12, 240, 113, 16);
			}
			{
				infotext6 = new JLabel();
				this.add(infotext6);
				infotext6.setText("Lemmatize this sentence");
				infotext6.setBounds(12, 143, 476, 16);
			}
			{
				sButton = new JButton();
				this.add(sButton);
				sButton.setText("New Sentence");
				sButton.setBounds(12, 347, 234, 42);
				sButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						newSentence();
					}
				});
			}
			{
				rButton = new JButton();
				this.add(rButton);
				rButton.setText("Right ?");
				rButton.setBounds(257, 347, 234, 42);
				rButton.setEnabled(false);
				rButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						correct();
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void readSentences (String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String l = "";
		while ((l = br.readLine())!= null) {
			sentences.add(l);
		}
		br.close();
	}
	
	private void newSentence () {
		String[] sp = sentences.get(r.nextInt(sentences.size())).split("#");
		sent = sp[0];
		gold = sp[2];
		show.setText(sent);
		input.setEditable(true);
		rButton.setEnabled(true);
		sButton.setEnabled(false);
		input.setText("");
		input.requestFocus();
	}
	
	private void correct () {
		if (input.getText().trim().equals(gold.trim())) {
			show.setText("Well done! That was the expected answer!");
			input.setText("");
		} else {
			show.setText("That was not the expected answer.\nThe expected answer was: " + gold);
			input.setText("");
		}
		input.setEditable(false);
		rButton.setEnabled(false);
		sButton.setEnabled(true);
		sButton.requestFocus();
	}

}
