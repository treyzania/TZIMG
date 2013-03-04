package com.treyzania.tzimg;

public class InterfaceResources {

	// Master resources.
	public static int mode; // 0 for waiting, 1 for conversion, 2 for viewing.
	public static int fileSize;
	public static int pixelCount;
	public static String currentState;
	
	// Conversion resources.
	public static int conv_loadingImage;
	public static int conv_isolatingPixels;
	public static int conv_encodingPixels;
	public static int conv_finalizingImage;
	
	// Viewing resources.
	public static int view_loadingImage;
	public static int view_splittingPixels;
	public static int view_convertingPixels;
	public static int view_consilidatingPixels;
	
	public static void initialize() {
		mode = 0;
	}
	
	public static void setState(String state) {
		currentState = state;
	}
	
}
