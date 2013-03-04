package com.treyzania.tzimg.viewer;

import java.awt.Color;

public class Pixel {

	int x, y;
	Color color;
	
	public Pixel(String locString, String colorString) {
		
		String[] locData = locString.split(",");
		String[] colorData = colorString.split(",");
		
		x = Integer.parseInt(locData[0]);
		y = Integer.parseInt(locData[1]);
		
		int r = Integer.parseInt(colorData[0]);
		int g = Integer.parseInt(colorData[1]);
		int b = Integer.parseInt(colorData[2]);
		
		color = new Color(r, g, b);
		
	}
	
	public int getRGB() {
		return color.getRGB();
	}
	
}
