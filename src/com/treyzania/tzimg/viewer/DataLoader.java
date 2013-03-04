package com.treyzania.tzimg.viewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataLoader {

	public static void loadData() {
		
		System.out.println("Loading image...");
		
		// Initialize values.
		char[] data = null;
		File file = new File(VResources.fileLocation);
		FileInputStream fis = null;
		
		long fileLength = file.length();
		data = new char[(int) fileLength];
		
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < fileLength; i++) {
			
			System.out.println("Loading byte: " + (i + 1) + "/" + fileLength + "...");
			
			try {
				data[i] = (char) fis.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		String dataString = new String(data);
		
		VResources.imageData = dataString;
		System.out.println("Image loaded!");
		
	}
	
}
