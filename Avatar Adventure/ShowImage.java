// ShowImage.java
// This program loads an image from a file and displays it to the screen.
// The shift and space keys will clear the screen.


import java.awt.*;			// for classes Image, Graphics, Color
import java.awt.event.*;	// for classes KeyListener, MouseListener
import javax.swing.*;		// for class JFrame

////////////////////////////////////////////////////////
// Add imports for classes File, IOExcaption, ImageIO
// 
import java.io.*; // for classes file, IOException
import javax.imageio.*;
public class ShowImage {
 
	private JFrame frame;
	private DrawingArea canvas;		// JPanel to draw images
	////////////////////////////////////////////////////////
	// Declare image object
	private Image image;
	
	private int xpos, ypos;
	private boolean keyClear;
		
	private int sizeX = 217, sizeY = 301; // Calvin
	////////////////////////////////////////////////////////
	// Provide Filename
	private String imageName = "calvin.jpg";
	
	public ShowImage ( )   {
		xpos = ypos = 220;		// center the picture in the frame
		keyClear = true;
	}
	
	public static void main (String[] args) {
		ShowImage si = new ShowImage();
		si.Run();
	}
 
	public void Run( )  {
		// Create the JPanel canvas
		canvas = new DrawingArea ( );
		canvas.setBackground( Color.gray );
		
		// Get the Image from a file
		GetMyImage();

		// Create the JFrame and add the JPanel
		frame = new JFrame("ShowImage");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add( canvas );
		frame.addKeyListener(canvas);
		frame.setBackground(Color.gray);
		frame.setSize(800, 800);
		frame.setLocation(300, 0);
		frame.setVisible(true);
	}

	public void GetMyImage() {
		///////////////////////////////////////////////////
		// Create a try-catch block for loading the image
		try
		{
			image = ImageIO.read(new File(imageName));
		}
		catch(IOException e)
		{
			System.err.println("ERROR: File not found " + imageName);
			System.exit(1);
		}
	}
	
	// canvas 
	class DrawingArea extends JPanel implements MouseListener, KeyListener {
		public DrawingArea ( )   {
			addMouseListener (this);
			addKeyListener (this);
		}

		public void paintComponent ( Graphics g ) {
			if (keyClear) super.paintComponent ( g );	// blank the canvas
			///////////////////////////////////////////////////////////
			// Draw the image that was loaded
			else g.drawImage( image, xpos, ypos, sizeX, sizeY, this);
			keyClear = false;
		}

		// Mouse methods
		public void mousePressed ( MouseEvent e )   {
			xpos = e.getX ( ) - 135;
			ypos = e.getY ( ) - 90;
			repaint ( );
		}
		public void mouseClicked ( MouseEvent e )    {}
		public void mouseReleased ( MouseEvent e )    {}
		public void mouseEntered ( MouseEvent e )    {}
		public void mouseExited ( MouseEvent e )    {}
		
		// Key methods
		public void keyPressed (KeyEvent e) {
			int code = e.getKeyCode();
			// pressing space or shift will clear the screen
			if (code == 32 || code == 16) {
				keyClear = true;
				repaint();
			}
		}
		public void keyTyped (KeyEvent e) {}
		public void keyReleased (KeyEvent e) {}
	}
}
