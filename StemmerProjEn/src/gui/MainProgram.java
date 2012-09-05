package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class MainProgram extends JFrame {
	
	/**
	 * 
	 */
	private static String stemmer_url = "http://en.wikipedia.org/wiki/Stemming";
	private static String lemma_url = "http://en.wikipedia.org/wiki/Lemmatisation";
	private static final long serialVersionUID = 1L;
	private static JMenuBar menubar;
	private static JMenu file;
	private static JMenuItem close;
	private static JMenu help;
	private static JMenuItem about;
	private static JMenu further;
	private static JMenuItem furtherstem;
	private static JMenuItem furtherlemma;
	private JPanel cards, nextPane;
	private final static String WELCOME = "Welcome", LL = "LemmaLearn", LT = "LemmaTest", SL = "StemLearn", ST = "StemTest", TY = "ThankYou";
	private int count = 1;
	 
	private void addCompToPane(Container pane) throws IOException {
		//create top and bottom panel
		JPanel titlePane = new JPanel();
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Stemmer/Lemmatizer Learning Program");
		titleLabel.setFont(new java.awt.Font("Segoe UI",1,20));
		titlePane.add(titleLabel);
		nextPane = new JPanel(new CardLayout());
		JButton next = new JButton("Next");
		JPanel next1 = new JPanel(new BorderLayout());
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				advance();
			}
		});
		next1.add(next);
		JPanel next2 = new JPanel(new BorderLayout());
		JButton restart = new JButton("Restart");
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
			}
		});
		next2.add(restart);
		nextPane.add(next1, "Next1");
		nextPane.add(next2, "Next2");
		
		//create cards
		JPanel card0 = new JPanel();
		card0.add(new Welcome());
		JPanel card1 = new JPanel();
		card1.add(new StemLearn());
		JPanel card2 = new JPanel();
		card2.add(new StemTest());
		JPanel card3 = new JPanel();
		card3.add(new LemmaLearn());
		JPanel card4 = new JPanel();
		card4.add(new LemmaTest());
		JPanel card5 = new JPanel();
		card5.add(new ThankYou());

		//add cards to container
		cards = new JPanel(new CardLayout());
		cards.add(card0, WELCOME);
		cards.add(card1, SL);
		cards.add(card2, ST);
		cards.add(card3, LL);
		cards.add(card4, LT);
		cards.add(card5, TY);

		//add panels to pane
		pane.add(titlePane, BorderLayout.NORTH);
		pane.add(cards, BorderLayout.CENTER);
		pane.add(nextPane, BorderLayout.SOUTH);
	}
	
	private static void createAndShowGUI() throws IOException {
		//Create and set up the window.
		JFrame frame = new JFrame("Interactive Stemmer/Lemmatizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		MainProgram mainF = new MainProgram();
		mainF.addCompToPane(frame.getContentPane());

		//add menu bar and menu
		{
			menubar = new JMenuBar();
			frame.setJMenuBar(menubar);
			{
				file = new JMenu();
				menubar.add(file);
				file.setText("File");
				{
					close = new JMenuItem();
					file.add(close);
					close.setText("Close");
					close.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
				}
			}
			{
				help = new JMenu();
				menubar.add(help);
				help.setText("Help");
				{
					about = new JMenuItem();
					help.add(about);
					about.setText("About...");
					about.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							 JEditorPane ep = new JEditorPane("text/html", "<html><body>" //
							            + "Written and copyrighted by David Alfter.<br/>University of Trier<br/>2012<br/><br/>" //
							            +"Snowball Stemmer written and copyrighted by Dr. Martin Porter.<br/>2001<br/><br/>"
							            +"Snowball Stemmer (Java) written and copyrighted by Richard Boulton.<br/>2002<br/>"
							            +"Snowball Stemmer is covered by the <a href=\"http://www.opensource.org/licenses/bsd-license.html\">BSD License</a><br/><br/>"
							            +"Morpha Stemmer copyrighted by John A. Carroll.<br/>University of Sussex<br/>2003"
							            + "</body></html>");

							    // handle link events
							    ep.addHyperlinkListener(new HyperlinkListener()
							    {
							        @Override
							        public void hyperlinkUpdate(HyperlinkEvent e)
							        {
							            if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
							               browseTo(e.getURL().toString());
							        }
							    });
							    ep.setEditable(false);
							    ep.setBackground(new Color(212,208,200));
							JOptionPane.showMessageDialog(null, ep, "About", JOptionPane.PLAIN_MESSAGE);
						}
					});
				}
				{
					further = new JMenu();
					help.add(further);
					further.setText("Further Information");
					{
						furtherstem = new JMenuItem();
						further.add(furtherstem);
						furtherstem.setText("Stemming");
						furtherstem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								browseTo(stemmer_url);
							}
						});
					}
					{
						furtherlemma = new JMenuItem();
						further.add(furtherlemma);
						furtherlemma.setText("Lemmatisation");
						furtherlemma.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								browseTo(lemma_url);
							}
						});
					}
				}
			}
		}
		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	private static void browseTo (String url) {
		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

        if( !desktop.isSupported( java.awt.Desktop.Action.BROWSE ) ) {

            JOptionPane.showMessageDialog(null, "Please visit " + url + " for further information", "URL", JOptionPane.INFORMATION_MESSAGE);
        }

      

            try {

                java.net.URI uri = new java.net.URI( url );
                desktop.browse( uri );
            }
            catch ( Exception exc ) {

                System.err.println( exc.getMessage() );
            }
	}
	private void advance() {
		CardLayout cl = (CardLayout)(cards.getLayout());
		CardLayout cl2 = (CardLayout)(nextPane.getLayout());
		String name = "";
		switch (count) {
		case 0: name = WELCOME;
		count++;
			break;
		case 1: name = SL;
		count++;
			break;
		case 2: name = ST;
		count++;
			break;
		case 3: name = LL;
		count++;
			break;
		case 4: name = LT;
		count++;
			break;
		case 5: name = TY;
		cl2.last(nextPane);
		count = 1;
			break;
			default: break;
		}
		
		cl.show(cards, name);	
	}
	
	private void restart () {
		CardLayout cl = (CardLayout)(cards.getLayout());
		CardLayout cl2 = (CardLayout)(nextPane.getLayout());
		cl.first(cards);
		cl2.first(nextPane);
	}
	
	public static void main(String[] args) {
		//Schedule a job for the event dispatch thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
