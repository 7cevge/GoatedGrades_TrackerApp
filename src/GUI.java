import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUI {
	public GUI() {
		JFrame frame = new JFrame();

		/*
		 * if want custom title bar, need frame to be undecorated and make a panel to do
		 * the same thing the title bar would
		 */
		
		// frame.setUndecorated(true);

		frame.setTitle("GradeTrackerApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(500, 500);
		frame.setLayout(null);
		
		ImageIcon appIcon = new ImageIcon("./graphics/temporaryIcon.jpg");
		frame.setIconImage(appIcon.getImage());

		frame.getContentPane().setBackground(new Color(0x336699));
		
		JLabel label1 = new JLabel();
		ImageIcon label1Img = new ImageIcon("./graphics/temporaryIcon.jpg");
		Border label1Border = BorderFactory.createLineBorder(new Color(0xff00ff));
		
		label1.setText("label1 text");
		label1.setIcon(label1Img);
		label1.setIconTextGap(15);
		
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.CENTER);
		label1.setBackground(new Color(0x000077));
		label1.setForeground(new Color(0x993300));
		label1.setOpaque(true);
		label1.setBorder(label1Border);
		label1.setBounds(25,25,400,400);
		
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalTextPosition(JLabel.BOTTOM);
		label1.setFont(new Font("MV Boli", Font.BOLD, 50));
		
		
		frame.add(label1);
		//frame.pack();
		frame.setVisible(true);
	}
}
