package paintApp;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JPanel;

// Paint App v1.2
public class DrawArea extends JPanel {
	
	//private ArrayList<Dot> drawings = new ArrayList<Dot>();
	
	private Stack<Stroke> strokes = new Stack<Stroke>();
	
	private Stroke currentStroke;
	
	// Mouse Start and End Points used to draw shape
	private Point clicked;
	
	public DrawArea(PaintApp app) {
		
		MouseAdapter ma = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				clicked = e.getPoint();
				currentStroke = new Stroke(new Dot(app.getColor(), clicked, app.getSize()));
				repaint();
			}
			public void mouseDragged(MouseEvent e) {
				clicked = e.getPoint();
				currentStroke.add(new Dot(app.getColor(), clicked, app.getSize()));
				repaint();
			}
			public void mouseReleased(MouseEvent e) {
				strokes.push(currentStroke.clone());
				currentStroke.clear();
				repaint();
			}
		};
		
		addMouseListener(ma);
		addMouseMotionListener(ma);
	}
	
	public void undo() {
		if (strokes.size() > 0) {
			strokes.pop();
			repaint();
		}
	}
	
	public void clear() {
		strokes.clear();
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (clicked != null) {
			currentStroke.paintComponent(g);
		}
		
		for (int i = 0; i < strokes.size(); i++) {
			strokes.get(i).paintComponent(g);
		}
		
		clicked = null;
	}
}
