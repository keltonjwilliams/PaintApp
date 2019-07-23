package paintApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

// Paint App v1.2
public class Stroke extends ArrayList<Dot> {
	
	public Stroke(Dot dot) {
		super();
		super.add(dot);
	}
	
	public boolean add(Dot dot) {
		return super.add(dot);
	}
	
	public void clear() {
		super.clear();
	}
	
	public Stroke clone() {
		Stroke clone;
		Iterator<Dot> iterator = super.iterator();
		clone = new Stroke(iterator.next());
		while (iterator.hasNext()) {
			clone.add((Dot)iterator.next().getDot().clone());
		}
		return clone;
	}
	
	public ArrayList<Dot> getStroke() {
		return this;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		for (int i = 0; i < super.size(); i++) {
			super.get(i).paintComponent(g2d);
		}
	}
}
