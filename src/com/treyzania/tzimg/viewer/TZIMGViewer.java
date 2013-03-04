package com.treyzania.tzimg.viewer;

import java.awt.Color;

import javax.swing.JFrame;

public class TZIMGViewer {

	public static String[] arguments;
	public static JFrame window;
	
	public static void main(String[] args) {
		
		arguments = args;
		
		VResources.intialize();
		
		// Initialize the window.
		window = new JFrame();
		window.setBackground(Color.BLACK);
		window.setVisible(false);
		window.setFocusable(true);
		window.setEnabled(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Load the image.
		DataLoader.loadData();
		
		// Decode the image.
		ImageDecoder.decode();
		ImageDecoder.bufferPixels();
		
		VResources.finishLoadTime = System.currentTimeMillis();
		VResources.totalLoadDuration = VResources.finishLoadTime - VResources.startLoadTime;
		
		// Load the window.
		//window.add(new ImagePanel());
		//window.setBounds(0, 0, 512 + 128, 512);
		//window.setVisible(true);
		
		System.out.println("Done!  The image was completely loaded!  (Total load time: " + VResources.totalLoadDuration + ")");
		
		//try {
		//	Thread.sleep(10000);
		//} catch (InterruptedException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
	}
	
}
