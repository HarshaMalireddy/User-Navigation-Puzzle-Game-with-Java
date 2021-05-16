// MyFrame.java
// This program provides an example of different layouts:
// BorderLayout, FlowLayout, GridLayout, and CardLayout.



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePrep
{
	private CreatePanels create;
	private JFrame frame;
	
	public static void main (String [] args) 
	{
		MyFrame gpa = new MyFrame();
		gpa.Run();
	}
	
	public void Run() 
	{
		// Initialize and set up the JFrame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		// Create the colors panel and buttons panel
		create = new CreatePanels();
		
		// add the JPanels to the frame
		frame.getContentPane().add(create, BorderLayout.CENTER);
		
		/*
		Panel1 pane11 = new Panel1();
		Panel2 pane12 = new Panel2();
		Panel3 pane13 = new Panel3();
		Panel4 pane14 = new Panel4();
		Panel5 pane15 = new Panel5();
		* */
		frame.setVisible(true);
	} // end Run
	
	class CreatePanels extends JPanel implements MouseListener 
	{
		
		private CardLayout cards;
		public JPanel panel1, panel2, panel3, panel4, panel5;
		
		
		public CreatePanels() 
		{			
			cards = new CardLayout();
			this.setLayout(cards);

			panel1 = new JPanel();
			panel1.setBackground(Color.blue);
			panel2 = new JPanel();
			panel2.setBackground(Color.green);
			panel3 = new JPanel();
			panel3.setBackground(Color.red);
			panel4 = new JPanel();
			panel4.setBackground(Color.pink);
			panel5 = new JPanel();
			panel5.setBackground(Color.yellow);
		
			panel1.addActionListener(this);
			panel2.addActionListener(this);
			panel3.addActionListener(this);
			panel4.addActionListener(this);
			panel5.addActionListener(this);
			
			panel1.addMouseListener(this);
			panel2.addMouseListener(this);
			panel3.addMouseListener(this);
			panel4.addMouseListener(this);
			panel5.addMouseListener(this);
			
			
			this.add(panel1, "Panel 1");
			this.add(panel2, "Panel 2");
			this.add(panel3, "Panel 3");
			this.add(panel4, "Panel 4");
			this.add(panel5, "Panel 5");
		} // end constructor 
		 
		public void mousePressed(MouseEvent evt) 
		{
	
			cards.next(create);
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }
	} // end CreatePanels
	
	class panel1 extends JPanel implements ActionListener, MouseListener
	{
		public void mousePressed(MouseEvent evt) 
		{
			
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }
		
	} // end class panel1
	
	public void actionPerformed(ActionEvent evt)
	{
		
		
	} 
	
	class panel2 extends JPanel implements ActionListener, MouseListener
	{
		public void mousePressed(MouseEvent evt) 
		{
			
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }
		
	} // end class panel2
	
	public void actionPerformed()
	{
		
		
	} 
	
	class panel3 extends JPanel implements ActionListener, MouseListener
	{
		public void mousePressed(MouseEvent evt) 
		{
			
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }
		
	} // end class panel3
	
	public void actionPerformed(ActionEvent evt)
	{
		
		
	} 
	
	class panel4 extends JPanel implements ActionListener, MouseListener
	{
		public void mousePressed(MouseEvent evt) 
		{
			
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }


	} // end class panel4
	
	public void actionPerformed(ActionEvent evt)
	{
		
		
	} 

	
	class panel5 extends JPanel implements ActionListener, MouseListener
	{
		public void mousePressed(MouseEvent evt) 
		{
			
		}
		public void mouseEntered(MouseEvent evt) { }
		public void mouseExited(MouseEvent evt) { }
		public void mouseClicked(MouseEvent evt) { }
		public void mouseReleased(MouseEvent evt) { }


	} // end class panel5
	
		
	public void actionPerformed(ActionEvent evt)
	{
		
		
	} 

} // end GamePrep

