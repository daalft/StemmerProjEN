package gui;

import java.awt.Dimension;

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
public class ThankYou extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel tylabel;
	private JLabel infotextn4;
	private JLabel infotextn3;
	private JLabel infotextn2;
	private JLabel infotextn1;
	private JLabel infotextnote;
	private JLabel infotext4;
	private JLabel infotext5;
	private JLabel infotext3;
	private JLabel infotext2;
	private JLabel infotext1;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ThankYou());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ThankYou() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(500, 400));
			this.setLayout(null);
			{
				tylabel = new JLabel();
				this.add(tylabel);
				tylabel.setText("Thank you!");
				tylabel.setBounds(193, 30, 165, 30);
				tylabel.setFont(new java.awt.Font("Segoe UI",1,16));
			}
			{
				infotext1 = new JLabel();
				this.add(infotext1);
				infotext1.setText("Hopefully you've enjoyed this little introduction");
				infotext1.setBounds(12, 94, 476, 16);
			}
			{
				infotext2 = new JLabel();
				this.add(infotext2);
				infotext2.setText("and have learnt something new.");
				infotext2.setBounds(12, 116, 403, 16);
			}
			{
				infotext3 = new JLabel();
				this.add(infotext3);
				infotext3.setText("For further information, please look at the section ");
				infotext3.setBounds(12, 155, 476, 16);
			}
			{
				infotext5 = new JLabel();
				this.add(infotext5);
				infotext5.setText("To start again, please click \"Restart\"");
				infotext5.setBounds(12, 350, 476, 16);
			}
			{
				infotext4 = new JLabel();
				this.add(infotext4);
				infotext4.setText("\"Further Information\" in the menu.");
				infotext4.setBounds(12, 177, 471, 16);
			}
			{
				infotextnote = new JLabel();
				this.add(infotextnote);
				infotextnote.setText("Note");
				infotextnote.setBounds(12, 223, 47, 16);
				infotextnote.setForeground(new java.awt.Color(0,0,255));
			}
			{
				infotextn1 = new JLabel();
				this.add(infotextn1);
				infotextn1.setText("The stemmer and lemmatizer used");
				infotextn1.setBounds(50, 223, 422, 16);
			}
			{
				infotextn2 = new JLabel();
				this.add(infotextn2);
				infotextn2.setText("in this program are relatively inaccurate but fast.");
				infotextn2.setBounds(50, 245, 408, 16);
			}
			{
				infotextn3 = new JLabel();
				this.add(infotextn3);
				infotextn3.setText("Good lemmatizers need a huge information database.");
				infotextn3.setBounds(50, 267, 393, 16);
			}
			{
				infotextn4 = new JLabel();
				this.add(infotextn4);
				infotextn4.setText("Given the size of this program, I have opted for the faster variant.");
				infotextn4.setBounds(50, 289, 427, 16);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
