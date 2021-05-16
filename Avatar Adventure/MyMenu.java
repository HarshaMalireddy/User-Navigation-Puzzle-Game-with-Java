// MyMenu.java
// This program is an example of swing menus.


// Topics:
//	1. Create a menu


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyMenu {
	private JFrame frame;
	private MyDrawingPanel canvas;
	private String color, shape, fillOutline, shape2;
	
	
	public MyMenu() {
		color = "Blue";
		shape2 = "Circle";
	}
	
	public static void main (String[] args) {
		MyMenu mm = new MyMenu();
		mm.Run();
	}
	
	public void Run() {
		// Initialize and set up the JFrame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(440, 470);

		// Initialize the drawing canvas
		canvas = new MyDrawingPanel();
		
		//////////////////////////////////////////////////////////////
		// Set up color menu and menu items
		JMenu shapeColorsMenu = new JMenu("COLOR");
		JMenuItem blue = new JMenuItem("Blue");
		JMenuItem red = new JMenuItem("Red");
		JMenuItem green = new JMenuItem("Green");
		shapeColorsMenu.add(blue);
		shapeColorsMenu.add(red);
		shapeColorsMenu.add(green);
		ChangeColor ccListener = new ChangeColor();
		blue.addActionListener(ccListener);
		red.addActionListener(ccListener);
		green.addActionListener(ccListener);
	
		// Shape 
		
		JMenu changeShape = new JMenu("Shape");
		JMenuItem circle = new JMenuItem("Circle");
		JMenuItem oval = new JMenuItem("Oval");
		changeShape.add(circle);
		changeShape.add(oval);
		
		ChangeShape shapeListener = new ChangeShape();

		circle.addActionListener(shapeListener);
		oval.addActionListener(shapeListener);
		
		//////////////////////////////////////////////////////////////
		// Set up menu bar
		JMenuBar menus = new JMenuBar();
		menus.add(shapeColorsMenu);
		menus.add(changeShape);
		
		//////////////////////////////////////////////////////////////
		// add the menu bar to the frame
		frame.getContentPane().add(menus, BorderLayout.NORTH);
		
		
		// add the JPanel to the frame
		frame.getContentPane().add(canvas, BorderLayout.CENTER);

		// make the frame visible
		frame.setVisible(true);
	}
	
	class MyDrawingPanel extends JPanel {
		public MyDrawingPanel() {
			setBackground(Color.white);
		}
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g); 
			if (color.equals("Blue")) g.setColor(Color.blue);
			else if (color.equals("Red")) g.setColor(Color.red);
			else g.setColor(Color.green);	// color is "Green"
			//g.fillRect(40, 35, 350, 350);
		
			if(shape2.equals("Circle"))
			g.fillOval(20, 20, 20, 20);
			
			if(shape2.equals("Oval"))
			g.fillOval(10, 15, 20, 25);
		
		
		}
	}	// end class MyDrawingPanel
	
	class ChangeColor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			color = e.getActionCommand();
			canvas.repaint();

			
		}
	}
	
	class ChangeShape implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			shape2 = e.getActionCommand();
			canvas.repaint();


		}
	}
	
}
