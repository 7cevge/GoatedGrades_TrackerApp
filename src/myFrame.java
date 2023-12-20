import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class myFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	myFrame(String titleText, String iconPath) {
		this.setUndecorated(false); // for custom title bar
		this.setResizable(true);
		this.setSize(900, 700);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0x333333));

		JLabel iconTitle = new JLabel();
		ImageIcon icon = new ImageIcon(new ImageIcon(iconPath).getImage()
				.getScaledInstance(20, 20, Image.SCALE_DEFAULT));

		iconTitle.setText(titleText);
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
		titleBar.setBounds(0, 0, 500, 24);
		titleBar.setLayout(new BorderLayout());

		titleBar.add(iconTitle);
		this.add(titleBar, BorderLayout.PAGE_START);
		// frame.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
