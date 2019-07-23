package paintApp;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

// Paint App v1.1
public class DrawArea extends JPanel {
	
	private PaintApp app;
	
	private ArrayList<Dot> drawings = new ArrayList<Dot>();
	
	// Mouse Start and End Points used to draw shape
	private Point clicked;
	
	public DrawArea(PaintApp app) {
		
		this.app = app;
		MouseAdapter ma = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				clicked = e.getPoint();
				repaint();
			}
			public void mouseDragged(MouseEvent e) {
				clicked = e.getPoint();
				repaint();
			}
		};
		
		addMouseListener(ma);
		addMouseMotionListener(ma);
	}
	
	public void clear() {
		drawings.clear();
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (clicked != null) {
			drawings.add(new Dot(app.getColor(), clicked, app.getSize()));			
			
			for (int i = 0; i < drawings.size(); i++) {
				drawings.get(i).paintComponent(g);
			}
			
			clicked = null;
		}
	}
}
