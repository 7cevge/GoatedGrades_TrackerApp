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

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(900, 700);
		frame.setLayout(null);

		frame.getContentPane().setBackground(new Color(0x336699));

		JLabel iconTitle = new JLabel();
		ImageIcon icon = new ImageIcon(new ImageIcon("./graphics/temporaryIcon.jpg").getImage()
				.getScaledInstance(25, 25, Image.SCALE_DEFAULT));

		iconTitle.setText("Grade Tracker App - Alpha");
		iconTitle.setIcon(icon);
		iconTitle.setIconTextGap(15);

		iconTitle.setHorizontalAlignment(JLabel.LEFT);
		iconTitle.setVerticalAlignment(JLabel.CENTER);
		iconTitle.setForeground(new Color(0xFFFFFF));
		iconTitle.setOpaque(false);

		iconTitle.setHorizontalTextPosition(JLabel.RIGHT);
		iconTitle.setVerticalTextPosition(JLabel.CENTER);
		iconTitle.setFont(new Font("MV Boli", Font.BOLD, 15));

		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(0x000000));
		titleBar.setBounds(0, 0, 1500, 30);
		titleBar.setLayout(new FlowLayout());

		titleBar.add(iconTitle);
		frame.add(titleBar);
		// frame.pack();
		frame.setVisible(true);
	}
}
