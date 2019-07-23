package paintApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Paint App v1.2
public class PaintApp {
	
	public static final int WIDTH = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2),
							HEIGHT = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
	
	private JFrame frame;
	private DrawArea da;
	private Color color = Color.BLACK;
	private int size = 10;

	public static void main(String[] args) {
		new PaintApp();
	}
	
	public PaintApp() {
		frame = new JFrame("Paint App");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(new BorderLayout());
		
		String[] colors = {"Black", "White", "Red", "Orange", "Yellow", "Green", "Blue", "Purple"};
		JComboBox<String> colorChooser = new JComboBox<String>(colors);
		colorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(colorChooser.getSelectedIndex()) {
					case 0:
						color = Color.BLACK;
						break;
					case 1:
						color = Color.WHITE;
						break;
					case 2:
						color = Color.RED;
						break;
					case 3:
						color = Color.ORANGE;
						break;
					case 4:
						color = Color.YELLOW;
						break;
					case 5:
						color = Color.GREEN;
						break;
					case 6:
						color = Color.BLUE;
						break;
					case 7:
						color = Color.MAGENTA;
						break;
				}
				//da.repaint();
			}
		});
		
		TextField sizeField = new TextField(size + "");
		sizeField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size = Integer.parseInt(sizeField.getText());
			}
		});
		
		JButton undobtn = new JButton("Undo");
		undobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				da.undo();
			}
		});
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				da.clear();
			}
		});
		
		JPanel top = new JPanel(new FlowLayout());
		
		top.add(undobtn);	
		top.add(new JLabel("Color:"));
		top.add(colorChooser);
		top.add(new JLabel("Size"));
		top.add(sizeField);
		top.add(clearbtn);
		
		frame.add(top, BorderLayout.NORTH);
		frame.add(da = new DrawArea(this), BorderLayout.CENTER);
		frame.setBackground(Color.WHITE);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getSize() {
		return size;
	}
}
