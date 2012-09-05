package gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.LemmaMe;


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

public class LemmaLearn extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LemmaMe lm;
	private JTextArea input;
	private JTextArea output;
	private JLabel infotext1;
	private JLabel infotext2;
	private JButton lemmaButton;
	@SuppressWarnings("unused")
	private JLabel infoinfo;
	@SuppressWarnings("unused")
	private JLabel infoinfo2;
	private JLabel infotexttitle;
	private JLabel infotext3;
	private JLabel infotext4;
	private JLabel infohint;
	StringBuilder sb_for_a;
	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new LemmaLearn());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public LemmaLearn() {
		super();
		initGUI();
		lm = new LemmaMe();
	}

	private void initGUI() {
		try {
			setPreferredSize(new Dimension(500, 400));
			this.setLayout(null);

			{
				input = new JTextArea();
				this.add(input);
				input.setText("Input");
				input.setBounds(12, 161, 476, 74);
				input.addFocusListener(new FocusListener() {

					@Override
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						resetFields();
					}

					@Override
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub

					}

				});
			}
			{
				output = new JTextArea();
				this.add(output);
				output.setText("Output");
				output.setBounds(12, 269, 476, 75);
				output.setEditable(false);
			}
			{
				infotext1 = new JLabel();
				this.add(infotext1);
				infotext1.setText("Enter text here");
				infotext1.setBounds(12, 139, 476, 16);
			}
			{
				infotext2 = new JLabel();
				this.add(infotext2);
				infotext2.setText("This is the lemmatized result");
				infotext2.setBounds(12, 247, 476, 16);
			}
			{
				lemmaButton = new JButton();
				this.add(lemmaButton);
				lemmaButton.setText("Lemmatize!");
				lemmaButton.setBounds(12, 356, 477, 33);
				lemmaButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub	
						lemmaAction();	
					}

				});
			}
			{
				infotexttitle = new JLabel();
				this.add(infotexttitle);
				infotexttitle.setText("Step 1 - Lemmatizer");
				infotexttitle.setBounds(12, 12, 476, 22);
				infotexttitle.setFont(new java.awt.Font("Segoe UI",1,16));
			}
			{
				infotext3 = new JLabel();
				this.add(infotext3);
				infotext3.setText("In this step, you can input text (without punctuation) and see the lemmatized result.");
				infotext3.setBounds(12, 46, 476, 16);
			}
			{
				infotext4 = new JLabel();
				this.add(infotext4);
				infotext4.setText("Try to figure out what changes. When you feel confident, advance to the next step.");
				infotext4.setBounds(12, 74, 476, 16);
			}
			{
				infohint = new JLabel();
				this.add(infohint);
				infohint.setText("Hint");
				infohint.setBounds(453, 17, 36, 16);
				infohint.setToolTipText("Try plurals and conjugated verb forms");
			}
			/* with the morpha stemmer, no need for that
			{
				infoinfo = new JLabel();
				this.add(infoinfo);
				infoinfo.setText("Information");
				infoinfo.setBounds(12, 102, 131, 16);
				infoinfo.setForeground(new java.awt.Color(0,0,255));
			}
			{
				infoinfo2 = new JLabel();
				this.add(infoinfo2);
				infoinfo2.setText("Lemmatization takes longer than stemming. Please be patient.");
				infoinfo2.setBounds(87, 102, 401, 16);
			}
			*/
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage() + "\n2nd");
		}
	}
	private void resetFields () {
		input.setText("");
		output.setText("");
	}

	private void lemmaAction () {
		input.setEnabled(false);
		lemmaButton.setEnabled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		String string = input.getText();	
		output.setText(lm.lemmatizeToString(string));
		setCursor(null);
		input.setEnabled(true);
		lemmaButton.setEnabled(true);
	}
}
