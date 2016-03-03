/**
 * @author Ryan Luchs
 * This program makes an awesome rainbowy grid of text!
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 * @author Ryan Luchs
 *
 */
public class Rainbow extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1;
	
	private int x = 10; private int y = 10; 
	private JLabel[] tiles =  new JLabel[x*y];
	
	private Random gen = new Random();
	public static final Color RAINBOW[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};
	
	private JPanel gridPanel;
	private JPanel controlPanel;
	
	private JTextField setGridText;
	private JButton changeText;
	private JButton changeColors;
	
	public Rainbow() {
		super("Rainbow");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		gridPanel = new JPanel();
		controlPanel = new JPanel();
		
		// Setup Grid
		gridPanel.setLayout(new GridLayout(x,y));
		for(int i = 0; i < x*y; i++) {
			tiles[i] =  new JLabel("Why?!");
			tiles[i].setForeground(RAINBOW[gen.nextInt(7)]);
			tiles[i].setFont(new Font("Monospace", Font.BOLD, 12));
			gridPanel.add(tiles[i]);
		}
		add(gridPanel, BorderLayout.CENTER);
		
		// Setup Controls
		controlPanel.setLayout(new FlowLayout());
		
		setGridText = new JTextField("aeiou", 10);
		controlPanel.add(setGridText);
		
		changeText = new JButton("Change Text");
		changeText.addActionListener(this);
		controlPanel.add(changeText);
		
		changeColors = new JButton("Change Colors");
		changeColors.addActionListener(this);
		controlPanel.add(changeColors);
		
		add(controlPanel, BorderLayout.SOUTH);
		
		setSize(getPreferredSize());
		pack();
		//setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button  = (JButton)e.getSource();
		if(button.getText().equals("Change Colors")) {
			sparkle();
			changeColors.setBackground(RAINBOW[gen.nextInt(7)]);
		} else {
			for(int i = 0; i < x*y; i++) {
				tiles[i].setText(setGridText.getText());
			}
		}
	}
	
	public void sparkle() {
		for(int i = 0; i < x*y; i++) {
			tiles[i].setForeground(RAINBOW[gen.nextInt(7)]);
			//tiles[i].setPreferredSize(new Dimension(12 * setGridText.getText().length(), 15));
			//System.out.println("Set #: " + i);
		}
	}

//	public static void main(String[] args) {
//		Rainbow r = new Rainbow();
//		
//		for(long i = 0; i < 999999999999L; i++) {
//			r.sparkle();
//		}
//	}
	
	public static void main(String[] args) {
		new Rainbow();
	}
}
