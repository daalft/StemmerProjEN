package gui;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

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
public class Welcome extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel welcomeLabel;
	private JTextArea jTextArea1;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Welcome());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public Welcome() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setLayout(null);
			setPreferredSize(new Dimension(500, 400));
			{
				welcomeLabel = new JLabel();
				this.add(welcomeLabel, "North");
				BoxLayout welcomeLabelLayout = new BoxLayout(welcomeLabel, javax.swing.BoxLayout.X_AXIS);
				welcomeLabel.setLayout(welcomeLabelLayout);
				welcomeLabel.setText("Welcome");
				welcomeLabel.setFont(new java.awt.Font("Segoe UI",1,16));
				welcomeLabel.setBounds(204, 11, 196, 20);
			}
			{
				jTextArea1 = new JTextArea();
				this.add(jTextArea1, "Center");

				jTextArea1.setBounds(12, 37, 476, 351);
				jTextArea1.setBackground(new java.awt.Color(212,208,200));
				jTextArea1.setEditable(false);
				jTextArea1.setLineWrap(true);
				jTextArea1.setWrapStyleWord(true);
				jTextArea1.setOpaque(false);
				//jTextArea1.setEnabled(false);
				StringBuilder sb = new StringBuilder();
				sb.append("\nThis program is intended to make people understand how Stemmers and ");
				sb.append("Lemmatizers work by first giving the user the possibility to input ");
				sb.append("text and see what the stemmed or lemmatized result is.\n\n");
				sb.append("During this step, the user should get an insight into what either of ");
				sb.append("these programs do.\n\n\n");
				sb.append("In the next step, the user is presented with test data and is ");
				sb.append("encouraged to input what they think the relevant program would output.\n\n\n");
				sb.append("This way, users hopefully get an insight into how these programs function, what their utility is and in what way a Stemmer and a Lemmatizer are different from each other.");
				sb.append("\n\n\nTo navigate through the program, use the \"Next\" button at the bottom.\n\n\n\nHave fun!");
				jTextArea1.setText(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
