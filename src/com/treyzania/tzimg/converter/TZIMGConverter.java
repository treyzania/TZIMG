package com.treyzania.tzimg.converter;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class TZIMGConverter {

	public static String[] arguments;
	
	public static void main(String[] args) {
		
		arguments = args;
		
		// Copy over the location data.
		CResources.initialize();
		
		// Load, then convert the image.
		ImageLoader.loadImage();
		ImageLoader.bufferImage();
		
		// Encode the image.
		ImageEncoder.isolatePixels();
		ImageEncoder.countPixels();
		ImageEncoder.encode();
		ImageEncoder.finalizeImage();
		
		// Write the pixel array as the new format.
		ImageWriter.writeImage();
		
	}
	
	public static void kill(Exception e) {
		
		System.err.println("Error!  Conversion aborted!  Just wait 5 seconds while reading the stack trace!");
		
		if (e.getClass() == MalformedURLException.class) {
			
			System.err.println("You didn't provide a properly formed URL!");
			
		} else if (e.getClass() == FileNotFoundException.class) {
			
			System.err.println("For some reason, I couldn't find the ouput file!");
			
		} else {
			
			System.err.println("This one's tricky, but here's what I know...!\n" + e.getMessage());
			
		}
		
		try {
			Thread.sleep(5000); // Sleep for 5 seconds.
		} catch (InterruptedException ie) {}
		System.exit(1);
		
	}
	
}
