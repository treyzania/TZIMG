package com.treyzania.tzimg.viewer;

import java.awt.image.BufferedImage;

public class VResources {

	public static long startLoadTime;
	public static long finishLoadTime;
	public static long totalLoadDuration;
	
	public static String fileLocation;
	public static String imageData;
	public static Pixel[] pixels;
	public static BufferedImage image;
	
	public static int i_width;
	public static int i_height;
	public static String i_location;
	public static boolean i_locIsURL;
	public static long i_convTime;
	public static long i_convDuration;
	
	public static void intialize() {
		
		fileLocation = TZIMGViewer.arguments[0];
		startLoadTime = System.currentTimeMillis();
		
	}
	
}
