package paintApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

// Paint App v1.1
public class Dot {
	
	private Color color;
	private Ellipse2D dot;
	
	public Dot(Color color, Point center, int size) {
		this.color = color;
		
		dot = new Ellipse2D.Double(center.getX() - size / 2, center.getY() - size / 2, size, size);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(color);
		Graphics2D g2d = (Graphics2D) g;
		g2d.fill(dot);
	}
}
