package com.treyzania.tzimg.viewer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423823015572224594L;

	Thread repainter;
	
	public ImagePanel() {
		
		repainter = new Thread();
		repainter.start();
		
	}
	
	public void paint(Graphics g) {
		
		// Initialize the graphics.
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.BLACK);
		
		// Clear the canvas.
		super.paint(g2d);
		
		// Draw the image.
		g2d.drawImage(VResources.image, 0, 256, null);
		
		// Draw the meta.
		g2d.drawString("Image dimensions: " + VResources.i_width + "x" + VResources.i_height, 4, countLines(0));
		g2d.drawString("Image location type: " + VResources.i_locIsURL, 4, countLines(1));
		g2d.drawString("Image location: " + VResources.i_location, 4, countLines(2));
		g2d.drawString("Image conversion time: " + VResources.i_convTime, 4, countLines(3));
		g2d.drawString("Image conversion duration: " + VResources.i_convDuration, 4, countLines(4));
		g2d.drawString("Image load time (raw): " + VResources.totalLoadDuration, 4, countLines(5));
		g2d.drawString("Image load time: " + String.format("%d minutes, %d seconds", TimeUnit.MILLISECONDS.toMinutes(VResources.totalLoadDuration), TimeUnit.MILLISECONDS.toSeconds(VResources.totalLoadDuration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(VResources.totalLoadDuration))), 4, countLines(6));
		
		
	}

	private int countLines(int lines){
		return 16 + 16 * lines;
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			repaint();
			
		}
		
	}
	
	
	
}
