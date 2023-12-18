import java.awt.*;
import javax.swing.*;

public class GUI {
	public GUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(23,180,252));
		       frame.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);
		
		frame.setTitle("GradeTrackerApp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		ImageIcon appIcon = new ImageIcon("./graphics/temporaryIcon.jpg");
		frame.setIconImage(appIcon.getImage());
		
		frame.getContentPane().setBackground(new Color(0x336699));
		/*
		panel.setBorder(BorderFactory.createEmptyBorder(150,150,50,150));
		panel.setLayout(new GridLayout(0,1));
		
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		*/
	}
}
