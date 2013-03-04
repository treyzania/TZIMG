package com.treyzania.tzimg.converter;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import com.treyzania.tzimg.InterfaceResources;

public class ImageLoader {

	public static void loadImage() {
		
		System.out.println("Input Location: " + CResources.imageLocation);
		System.out.println("Image Type: " + (!CResources.isURL ? "LOCAL" : "REMOTE"));
		System.out.println("Ouput Location: " + CResources.outputLocation + ".tzimg");
		System.out.println("Loading image...");
		InterfaceResources.setState("Loading image");
		
		// Initialize the image.
		ImageIcon ii = null;
		
		// Check to see if it's a URL.
		if (CResources.isURL) {
			
			URL url = null;
			
			try {
				url = new URL(CResources.imageLocation);
			} catch (MalformedURLException e) {
				TZIMGConverter.kill(e);
			}
			
			ii = new ImageIcon(url);
			
		} else if (!CResources.isURL) {
			
			ii = new ImageIcon(CResources.imageLocation);
			
		}
		
		// Store the filled image.
		CResources.inputImage = ii;
		
		System.out.println("Image loaded!  Converting...");
		
	}
	
	public static void bufferImage() {
		
		InterfaceResources.setState("Buffering image");
		
		// Retrieve the image.
		ImageIcon icon = CResources.inputImage;
		
		// Initialize the buffer.
		BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		
		// Fill the buffer. (Thanks to "http://bit.ly/VVt4rc"!)
		Image image = icon.getImage();
		Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
		g.drawImage(image, 0, 0, null);
		
		// Store the buffer.
		CResources.bufferedImage = bufferedImage;
		
	}
	
}
