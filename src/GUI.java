import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class GUI {
	public GUI() {
		JFrame frame = new JFrame();

		frame.setUndecorated(false); // for custom title bar
		frame.setResizable(true);
		frame.setSize(900, 700);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0x333333));

		JLabel iconTitle = new JLabel();
		ImageIcon icon = new ImageIcon(new ImageIcon("./graphics/temporaryIcon.jpg").getImage()
				.getScaledInstance(20, 20, Image.SCALE_DEFAULT));

		iconTitle.setText("Grade Tracker App - Alpha");
		iconTitle.setIcon(icon);
		iconTitle.setIconTextGap(8);

		iconTitle.setHorizontalAlignment(JLabel.LEFT);
		iconTitle.setVerticalAlignment(JLabel.CENTER);
		
		iconTitle.setOpaque(true); // transparent background

		iconTitle.setHorizontalTextPosition(JLabel.RIGHT); // text alignment in respect to image
		iconTitle.setVerticalTextPosition(JLabel.CENTER);
		iconTitle.setFont(new Font("MV Boli", Font.BOLD, 12));
		iconTitle.setForeground(new Color(0xFFFFFF)); // set text color
		iconTitle.setBounds(5, 0, 250, 20);

		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(0x000000));
		titleBar.setBounds(0, 0, 900, 24);
		titleBar.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 2));

		titleBar.add(iconTitle);
		frame.add(titleBar);
		// frame.pack();
		frame.setVisible(true);
	}
}
