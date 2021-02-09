// Sai Harsha Maliereddy
// Use MouseEvents, MouseListeners, and MouseMotionListeners to implement a drawing program.
// This program draws lines based mouse events. The color of the line can be 
// choosen based on the buttons user clicks.Youc an reset the lines if RESET buttin is pressed.



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draw 
{

	JFrame frame;		// Instance variable for JFrame	
	Draw_lines panel;  // instance variable for Draw_lnes panel
	
	public Draw() 
	{
	}
	
	public static void main(String[] args) 
	{
		Draw create = new Draw();
		create.Run();
	}

       // Creates Frame and Jpanel. Add content listener and listens to mouse events	
	public void Run() 
	{
		frame = new JFrame("Draw");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		panel = new Draw_lines();
		frame.getContentPane().add(panel, BorderLayout.CENTER);	
	
		frame.addMouseListener(panel);
		frame.addMouseMotionListener(panel);
		frame.setSize(500, 600);
		frame.setVisible(true);		
		frame.setResizable(false);
	} // end Run

} // end class Draw 

// Panel class to create panel and buttons. Listens to mouse actions and draws
// lines in panel. It also resets the lines drawn
class Draw_lines extends JPanel implements MouseListener, MouseMotionListener 
{
	private boolean dragging;
	private int xStart, yStart;// start positions of line
	private int width, height; // width and height of buttons
	private int xEnd, yEnd;    // end positions of line
	private String button;
	public int xPos = 0, yPos = 0; // X and Y Positions of mouse
	
	public Draw_lines() 
	{
	
		xStart = yStart = 0;
		xEnd = yEnd = 0;
		width = 100;
		height = 120;
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	// Draws the buttons and lines.
	public void paintComponent(Graphics g) 
	{
		Draw_lines line = new Draw_lines();
		
		super.paintComponent(g);	
			
		setBackground(Color.lightGray);
			
		g.setColor(Color.black);
		g.fillRect(0, 2, width - 5,height);
		
		g.setColor(Color.red);
		g.fillRect(width, 2, width - 5,height);
		
		g.setColor(Color.blue);
		g.fillRect(width * 2, 2, width - 5,height);
		
		g.setColor(Color.gray);
		g.fillRect(width * 3, 2, width - 5,height);
		
		g.setColor(Color.green);
		g.fillRect(width * 4, 2, width - 5,height);
		
		g.setColor(Color.white);
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g.drawString("RESET",20,60);
		g.drawString("RED",130,60);
		g.drawString("BLUE",220,60);
		g.drawString("GRAY",320,60);
		g.drawString("GREEN",410,60);

	
	} // end paintComponent
	
	// Mouse events are captured
	public void mousePressed (MouseEvent e) 
	{
		xStart = xEnd = e.getX();
		yStart = yEnd = e.getY();
		
		
		if(yStart <= 100)
		   yStart = 101;
	
	} 
	
	// Sets the color depending on the button presssed.
	public void mouseReleased (MouseEvent e) {
		Graphics g = getGraphics();
		
		g.setColor(Color.RED);
		
		
		if((xPos <= 95) && (xPos >= 0) && (yPos <= 120) && (yPos >= 2))
		{
			g.setColor(Color.black);
			repaint();
		}
		
		if((xPos <= 195) && (xPos >= 100) && (yPos <= 120) && (yPos >= 2))
		{
			
			g.setColor(Color.red);
		}
	
		if((xPos <= 295) && (xPos >= 200) && (yPos <= 120) && (yPos >= 2))
		{
			g.setColor(Color.blue);	
		}
		
		if((xPos <= 395) && (xPos >= 300) && (yPos <= 120) && (yPos >= 2))
		{
			g.setColor(Color.gray);
			
		}
		
		if((xPos <= 495) && (xPos >= 400) && (yPos <= 120) && (yPos >= 2))
		{
			g.setColor(Color.green);
		}	
		
		// Makes sure the lines are not drawn through buttons.
		if(yStart <= 120)
		{
	
		      yStart = 121;
		}
	        if(yEnd <= 120)
	        {
	        	
		      yEnd = 121;
		}
		
		g.drawLine(xStart, yStart, xEnd, yEnd);

	}
	
	public void mouseClicked (MouseEvent e)
	{
	 xPos = e.getX();
	 yPos = e.getY();
	 
	 if((xPos <= 95) && (xPos >= 0) && (yPos <= 120) && (yPos >= 2))
	 {			
		repaint();
	 }
	 	 
	}
	public void mouseEntered (MouseEvent e) {}
	public void mouseExited (MouseEvent e) {}
	public void mouseMoved (MouseEvent e) {}
	
	public void mouseDragged (MouseEvent e) 
	{
		xStart = e.getX();
		yStart = e.getY();
				
//		repaint();	
		
	} // end mouseDragged
	

} // end class Create_lines


