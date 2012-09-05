package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import logic.StemMe;


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
public class StemLearn extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StemMe sm;
	private JTextArea input;
	private JLabel infohint;
	private JLabel infotext4;
	private JLabel infotext3;
	private JLabel infotexttitle;
	private JButton stemButton;
	private JLabel infotext2;
	private JLabel infotext1;
	private JTextArea output;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new StemLearn());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public StemLearn() {
		super();
		initGUI();
		sm = new StemMe();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(500, 400));
			this.setLayout(null);
			{
				input = new JTextArea();
				this.add(input);
				input.setText("Input");
				input.setBounds(12, 124, 476, 88);
				input.addFocusListener(new FocusListener() {

					@Override
					public void focusGained(FocusEvent arg0) {
						// TODO Auto-generated method stub
						resetFields();
					}

					@Override
					public void focusLost(FocusEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
			}
			{
				output = new JTextArea();
				this.add(output);
				output.setText("Output");
				output.setBounds(12, 256, 476, 88);
				output.setEditable(false);
			}
			{
				infotext1 = new JLabel();
				this.add(infotext1);
				infotext1.setText("Enter text here");
				infotext1.setBounds(12, 102, 476, 16);
			}
			{
				infotext2 = new JLabel();
				this.add(infotext2);
				infotext2.setText("This is the stemmed result");
				infotext2.setBounds(12, 234, 476, 16);
			}
			{
				stemButton = new JButton();
				this.add(stemButton);
				stemButton.setText("Stem!");
				stemButton.setBounds(12, 356, 477, 33);
				stemButton.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) {
					
							stemAction();
						
					}
				});
			}
			{
				infotexttitle = new JLabel();
				this.add(infotexttitle);
				infotexttitle.setText("Step 1 - Stemmer");
				infotexttitle.setBounds(12, 12, 476, 22);
				infotexttitle.setFont(new java.awt.Font("Segoe UI",1,16));
			}
			{
				infotext3 = new JLabel();
				this.add(infotext3);
				infotext3.setText("In this step, you can input text (without punctuation) and see the stemmed result.");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void resetFields () {
		input.setText("");
		output.setText("");
	}
	
	private void stemAction ()  {
		StringBuilder sb = new StringBuilder();
		for (String s : sm.stem(input.getText())) {
			sb.append(s).append(" ");
		}
		output.setText(sb.toString());
	}
}
