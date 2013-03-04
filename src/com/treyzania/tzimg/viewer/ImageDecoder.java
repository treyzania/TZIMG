package com.treyzania.tzimg.viewer;

import java.awt.image.BufferedImage;

public class ImageDecoder {

	public static void decode() {
		
		System.out.println("Decoding image...");
		// Get the image's data.
		String data = VResources.imageData;
		
		// Set up the master array.
		String[] sectors;
		
		// Set up the string values.
		String s_dimentions;
		String s_pixelBlob;
		String s_locationData;
		String s_conversionData;
		
		// Pixel blob buffer.
		String[] pixelBlob;
		
		// Set up final "single" values.
		int width;
		int height;
		Pixel[] pixels;
		String loc;
		boolean locIsURL;
		long conversionTime;
		long conversionDuration;
		
		/* Actually start decoding... 
		 * FORMAT: <size"w,h">|<pixels"x,y:r,g,b">|<location"loc,type(t:URL,f:local)">|<timeOfConversion>
		 */
		
		System.out.println("Decoding Image: Splitting data collecton... (Step 1/3)");
		// Split up the sectors.
		sectors = data.split("\\|");
		s_dimentions = sectors[0];
		s_pixelBlob = sectors[1];
		s_locationData = sectors[2];
		s_conversionData = sectors[3];
		
		System.out.println("Decoding Image: Refining meta collection... (Step 2/3)");
		// Get the size.
		String[] size = s_dimentions.split(",");
		width = Integer.parseInt(size[0]);
		height = Integer.parseInt(size[1]);
		
		// Isloate the pixel blob.
		pixelBlob = s_pixelBlob.split(";");
		
		// Get the location data.
		String[] locData = s_locationData.split(";");
		loc = locData[0];
		locIsURL = Boolean.parseBoolean(locData[1]);
		
		// Get the conversion data.
		String[] convData = s_conversionData.split(",");
		conversionTime = Long.parseLong(convData[0]);
		conversionDuration = Long.parseLong(convData[1]);
		
		System.out.println("Decoding Image: Organizing pixel blob... (Step 3/3)");
		// Split up the pixel blob.
		String[][] stringPixelArray = new String[pixelBlob.length][2];
		for (int i = 0; i < pixelBlob.length; i++) {
			System.out.println("Splitting off pixel " + (i + 1) + "/" + pixelBlob.length);
			
			String[] thePixel = pixelBlob[i].split(":");
			stringPixelArray[i] = thePixel;
		}
		
		pixels = new Pixel[pixelBlob.length];
		for (int i = 0; i < stringPixelArray.length; i++) {
			System.out.println("Converting pixel " + (i + 1) + "/" + pixelBlob.length);
			pixels[i] = new Pixel(stringPixelArray[i][0], stringPixelArray[i][1]);
		}
		
		// Carry over the data.
		VResources.i_width = width;
		VResources.i_height = height;
		VResources.pixels = pixels;
		VResources.i_location = loc;
		VResources.i_locIsURL = locIsURL;
		VResources.i_convTime = conversionTime;
		VResources.i_convDuration = conversionDuration;
		
	}
	
	public static void bufferPixels() {
		
		System.out.println("Consolidating pixels...");
		// Initialize the values.
		Pixel[] pixels = VResources.pixels;
		BufferedImage bi = new BufferedImage(VResources.i_width, VResources.i_height, BufferedImage.TYPE_INT_ARGB);
		
		// Convert
		for (Pixel pixel : pixels) {
			System.out.println("Painting pixel at " + pixel.x + "," + pixel.y + "...");
			bi.setRGB(pixel.x, pixel.y, pixel.getRGB());
		}
		
		VResources.image = bi;
		
	}
	
}
