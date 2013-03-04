package com.treyzania.tzimg.converter;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class CResources {

	public static long startTime;
	public static long endTime;
	
	public static String imageLocation;
	public static boolean isURL;
	
	public static String outputLocation;
	
	public static ImageIcon inputImage;
	public static BufferedImage bufferedImage;
	
	public static Color[][] pixels;
	public static int pixelCount;
	
	public static String[] lines;
	public static String text;
	
	public static void initialize() {
		
		startTime = System.currentTimeMillis();
		
		imageLocation = TZIMGConverter.arguments[0];
		isURL = Boolean.parseBoolean(TZIMGConverter.arguments[1]);
		
		outputLocation = Long.toString(System.currentTimeMillis());
		
	}
	
}
