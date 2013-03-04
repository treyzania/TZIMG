package com.treyzania.tzimg.converter;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.treyzania.tzimg.InterfaceResources;

public class ImageEncoder {

	public static void isolatePixels() {
		
		System.out.println("Isolating pixels...");
		InterfaceResources.setState("Isolating pixels");
		
		// Initialize the values.
		BufferedImage image = CResources.bufferedImage;
		Color[][] pixels = null;
		int width = image.getWidth();
		int height = image.getHeight();
		pixels = new Color[width][width];
		
		// Loop through the pixels, moving them into the array.
		for (int x = 0; x < width; x++) {
			
			for (int y = 0; y < height; y++) {
				
				Color c = null;
				int pixelIntColor = image.getRGB(x, y);
				
				c = new Color(pixelIntColor);
				pixels[x][y] = c;
				
			}
			
		}
		
		// Store the array.
		CResources.pixels = pixels;
		
	}
	
	public static void countPixels() {
		
		System.out.println("Counting pixels...");
		InterfaceResources.setState("Counting pixels");
		
		BufferedImage bi = CResources.bufferedImage;
		CResources.pixelCount = bi.getWidth() * bi.getHeight();
		
		System.out.println("Found " + CResources.pixelCount + " pixels!");
		
	}
	
	public static void encode() {
		
		System.out.println("Encoding pixels...");
		InterfaceResources.setState("Encoding pixels");
		
		// Initialize the values.
		BufferedImage image = CResources.bufferedImage;
		String[] lines = new String[CResources.pixelCount + 1];
		Color[][] pixels = CResources.pixels;
		int width = image.getWidth();
		int height = image.getHeight();
		
		// Give the width and height.
		lines[0] = Integer.toString(width) + "," + Integer.toString(height);
		
		for (int x = 0; x < width; x++) {
			
			for (int y = 0; y < height; y++) {
				
				Color c = pixels[x][y];
				int place = (x * height) + y;
				
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				
				String locData = Integer.toString(x) + "," + Integer.toString(y);
				String colorData = Integer.toString(r) + "," + Integer.toString(g) + "," + Integer.toString(b);
				
				String line = locData + ":" + colorData;
				
				lines[place + 1] = line;
				
				System.out.println("Encoding pixel: " + x + ", " + y + " is (" + r + ", " + g + ", " + b + "), " + (place + 1) + "/" + CResources.pixelCount);
				
			}
			
		}
		
		// Store the list of lines.
		CResources.lines = lines;
		
	}
	
	public static void finalizeImage() {
		
		System.out.println("Finalizing image...");
		InterfaceResources.setState("Finalizing image");
		
		// Initialize the values.
		String[] lines = CResources.lines;
		String text = "";
		
		// Encode the dimensions.
		text = text + lines[0] + "|";
		
		// Encode the pixels
		for (int i = 1; i < lines.length; i++) {
			
			System.out.println("Finalizing pixel " + i + "/" + (lines.length - 1) + "...");
			
			text = text + lines[i];
			text = text + ";";
			
		}
		
		CResources.endTime = System.currentTimeMillis();
		
		// Encode other data.
		text = text + "|" + CResources.imageLocation + ";" + Boolean.toString(CResources.isURL); // Original location
		text = text + "|" + CResources.startTime + "," + (CResources.endTime - CResources.startTime); // Conversion time.
		
		CResources.text = text;
		
	}
	
}
