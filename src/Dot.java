package paintApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

// Paint App v1.2
public class Dot extends Ellipse2D.Double{
	
	private Color color;
	//private Ellipse2D dot;
	
	public Dot(Color color, Point center, int size) {
		super(center.getX() - size / 2, center.getY() - size / 2, size, size);
		this.color = color;
	}
	
	public Ellipse2D getDot() {
		return this;
	}
	
	public void paintComponent(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.fill(this);
	}
}
