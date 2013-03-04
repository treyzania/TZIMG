package com.treyzania.tzimg;

import javax.swing.JFrame;

public class TZIMG {

	public static JFrame window;
	
	public static void main(String[] args) {
		
		InterfaceResources.initialize();
		InterfaceResources.setState("Waiting");
		
		window = new JFrame();
		window.setVisible(true);
		window.setTitle("TZIMG Converter & Viewer");
		window.setBounds(0, 0, 512 + 128, 512);
		window.setFocusable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(new InterfacePanel());
		
	}
	
}
