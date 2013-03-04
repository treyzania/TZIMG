package com.treyzania.tzimg.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.treyzania.tzimg.InterfaceResources;

public class ImageWriter {

	public static void writeImage() {
		
		System.out.println("Writing image...");
		InterfaceResources.setState("Writing image");
		
		// Initialize the non-streams-related values.
		String text = CResources.text;
		String fileName = CResources.outputLocation + ".tzimg";
		
		// Initialize the streams-related objects.
		File file = new File(fileName);
		FileOutputStream fos = null;
		
		// Set the output stream.
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			TZIMGConverter.kill(e);
		}
		
		for (int i = 0; i < text.length(); i++) {
			
			System.out.println("Writing byte " + (i + 1) + "/" + text.length() + "...");
			
			try {
				fos.write(text.charAt(i));
			} catch (IOException e) {
				TZIMGConverter.kill(e);
			}
			
		}
		
		System.out.println("Done!  The file conversion is complete!");
		
	}
	
}
