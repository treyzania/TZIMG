package com.treyzania.tzimg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.treyzania.tzimg.converter.TZIMGConverter;
import com.treyzania.tzimg.viewer.TZIMGViewer;
import com.treyzania.tzimg.viewer.VResources;

public class InterfacePanel extends JPanel implements ActionListener, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2831015889691680883L;

	JTextField inputBox;
	JButton button;
	JCheckBox mode;
	
	public InterfacePanel() {
		
		inputBox = new JTextField();
		inputBox.setText("File location:");
		inputBox.setBounds(4, 64, 128, 16);
		inputBox.setVisible(true);
		
		button = new JButton();
		button.setText("Run");
		button.setBounds(138, 64, 32, 16);
		button.setVisible(true);
		
		mode = new JCheckBox();
		mode.setText("Is converting? (check for yes)");
		mode.setBounds(4, 78, 8, 8);
		mode.setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		
		// Setup graphics.
		Graphics2D g2d = (Graphics2D) g;
		super.paint(g2d);
		
		// Draw the state.
		g2d.drawString("State: " + InterfaceResources.currentState, 4, countLines(0));
		
		// Do whatever.
		if (InterfaceResources.mode == 0) {
			this.paint_nothing(g2d);
		} else if (InterfaceResources.mode == 1) {
			this.paint_conv(g2d);
		} else if (InterfaceResources.mode == 2) {
			this.paint_view(g2d);
		}
		
	}
	
	public void paint_nothing(Graphics2D g2d) {
		
		
		
	}
	
	public void paint_conv(Graphics2D g2d) {
		
	}
	
	public void paint_view(Graphics2D g2d) {
		
		// Draw the image.
		g2d.drawImage(VResources.image, 0, 256, null);
		
		// Draw the meta.
		g2d.drawString("Image dimensions: " + VResources.i_width + "x" + VResources.i_height, 4, countLines(2));
		g2d.drawString("Image location type: " + VResources.i_locIsURL, 4, countLines(3));
		g2d.drawString("Image location: " + VResources.i_location, 4, countLines(4));
		g2d.drawString("Image conversion time: " + VResources.i_convTime, 4, countLines(5));
		g2d.drawString("Image conversion duration: " + VResources.i_convDuration, 4, countLines(6));
		g2d.drawString("Image load time (raw): " + VResources.totalLoadDuration, 4, countLines(7));
		g2d.drawString("Image load time: " + String.format("%d minutes, %d seconds", TimeUnit.MILLISECONDS.toMinutes(VResources.totalLoadDuration), TimeUnit.MILLISECONDS.toSeconds(VResources.totalLoadDuration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(VResources.totalLoadDuration))), 4, countLines(8));
		
	}
	
	
	public void drawBar(Graphics2D g2d, int x, int y, int current, int max, int width, int height) {
		
		// Calculate distance.
		int distance = (current / max) * width;
		int percent = (int) Math.floor(current / max);
		
		// Draw.
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, width, height);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(x + 1, y + 1, distance, height - 1);
		g2d.setColor(Color.BLACK);
		g2d.drawString(percent + "%", x, y - 5);
		
	}
	
	public int countLines(int line) {
		return 16 + (16 * line);
	}

	@Override
	public void run() {
		
		while (true) {
			
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == this.button) {
			
			if (mode.isSelected()) {
				
				boolean isURL = true;
				
				try {
					new URL(inputBox.getText());
				} catch (Exception e) {
					isURL = false;
				}
				
				
				TZIMGConverter.main(new String[] { inputBox.getText(), Boolean.toString(isURL) });
				
			} else {
				
				TZIMGViewer.main(new String[] {inputBox.getText()});
				
			}
			
		}
		
	}
	
}
