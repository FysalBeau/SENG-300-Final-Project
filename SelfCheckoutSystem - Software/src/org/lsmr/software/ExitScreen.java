package org.lsmr.software;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.lsmr.selfcheckout.devices.TouchScreen;

public class ExitScreen {
	
	private JPanel screen;
	//private JPanel scanningScreen;
	private JFrame frame;
	
	public ExitScreen(int screenWidth, int screenHeight, JFrame frame) {
		this.frame = frame;
		//this.scanningScreen = scanningScreen;
		
		screen = new JPanel();

		screen.setSize(screenWidth, screenHeight);

		screen.setLayout(null);
		

		Path currentRelativePath = Paths.get("SENG300GroupProjectI3-main/SelfCheckoutSystem - Software/src/org/lsmr/software/GUI_Images/entry.jpg");
		String path = currentRelativePath.toAbsolutePath().toString();
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel leftLabel = new JLabel();
		
		
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		int leftPanelWidth = screenWidth/2;
		int leftPanelHeight = screenHeight;
		int rightPanelWidth = screenWidth/2;
		int rightPanelHeight = screenHeight;
		int rightPanelX = (int)screenWidth/2;
		
		leftPanel.setBounds(0, 0, leftPanelWidth, leftPanelHeight);
		rightPanel.setBounds(rightPanelX, 0, rightPanelWidth, rightPanelHeight);
		
		screen.add(leftPanel);
		screen.add(rightPanel);

		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
		leftPanel.add(Box.createVerticalGlue());
		leftPanel.add(leftLabel);
		leftPanel.add(Box.createVerticalGlue());
		leftLabel.setMinimumSize(new Dimension(leftPanelWidth, leftPanelHeight));
		leftLabel.setPreferredSize(new Dimension(leftPanelWidth, leftPanelHeight));
		leftLabel.setMaximumSize(new Dimension(leftPanelWidth, leftPanelHeight));
		leftLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Image image = img.getScaledInstance(leftPanelWidth, leftPanelHeight,
		        Image.SCALE_SMOOTH);
		leftLabel.setIcon(new ImageIcon(image));
		
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
		
		JLabel openLabel = new JLabel("Thank you for Shopping at CO-OP!");
		
		openLabel.setForeground(Color.BLACK);
		openLabel.setFont(new Font("Serif", Font.BOLD, (int)(rightPanelHeight*0.045)));
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.exit(0);
		    }
		});
		
		rightPanel.add(Box.createRigidArea(new Dimension(0, (int)(rightPanelHeight*0.35))));
		rightPanel.add(openLabel);
		rightPanel.add(Box.createRigidArea(new Dimension(0, (int)(rightPanelHeight*0.20))));
		rightPanel.add(continueButton);
		
		
		
		openLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		continueButton.setMinimumSize(new Dimension((int)(rightPanelWidth*0.5), (int)(rightPanelHeight*0.15)));
		continueButton.setPreferredSize(new Dimension((int)(rightPanelWidth*0.5), (int)(rightPanelHeight*0.15)));
		continueButton.setMaximumSize(new Dimension((int)(rightPanelWidth*0.5), (int)(rightPanelHeight*0.15)));
		
		continueButton.setFont(new Font("Arial", Font.PLAIN, (int)(rightPanelHeight*0.015)));
	}
	
	public JPanel getScreen() {
		return screen;
	}
}

