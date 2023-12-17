import java.awt.*;
import javax.swing.*;

public class GUI {
	public GUI() {
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(150,150,50,150));
		panel.setLayout(new GridLayout(0,1));
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("test");
		frame.pack();
		frame.setVisible(true);
	}
}
