
/********************
 * Sai Harsha Malireddy
 * Quote.java
 *******************
// This program provides an example of different layouts:
// BorderLayout, FlowLayout, GridLayout, and CardLayout and null layout.
// Five Panels are implemented in 5 classes and used for card layout.
// Another 5 Buttons are used in Button panel to demonstrate other four Layouts

// VAriables
// bluePanel, Greenpanel,redPanell, pinkPanel, greenPanel : Instancevaariables for 5 panels
// gridBtn, borderBtn, floeBtn, cardBtn, nullBtn : Buttons to demonstare variouslayOuts
// game : instance varibale for GamePrep.
*/ 
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class GamePrep
{
    private CreatePanels create;
//  private ButtonPanel  buttonPanel;
    private JFrame frame;
     
    public static void main (String [] args)
    {
        GamePrep game = new GamePrep();
        game.Run();
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
        // frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    } // end Run
     
    class CreatePanels extends JPanel implements MouseListener, ActionListener
    {         
        private CardLayout cards;  // Layouts
        private GridLayout grid;
        private FlowLayout flow;
        private BorderLayout border;
        private JPanel panel;
        // Panels
        public BluePanel bluePanel;
        public GreenPanel greenPanel;
        public RedPanel redPanel;
        public PinkPanel pinkPanel;
        public YellowPanel yellowPanel;
        public ButtonPanel buttonPanel;
             
        public CreatePanels()
        {      
            panel = new JPanel();	
            cards = new CardLayout();
            grid = new  GridLayout();
            flow = new FlowLayout();
            border = new BorderLayout();
            buttonPanel = new ButtonPanel();

	    this.setLayout(grid);
	    panel.setSize(500,300);
            panel.setLayout(cards); // set cardLayout for color Panels
 
            bluePanel = new BluePanel();
            bluePanel.setBackground(Color.blue);           
            greenPanel = new GreenPanel();
            greenPanel.setBackground(Color.green);           
            redPanel = new RedPanel();
            redPanel.setBackground(Color.red);           
            pinkPanel = new PinkPanel();
            pinkPanel.setBackground(Color.pink);            
            yellowPanel = new YellowPanel();
            yellowPanel.setBackground(Color.yellow);
            // Buttons 
	
            bluePanel.addMouseListener(this);
            greenPanel.addMouseListener(this);
            redPanel.addMouseListener(this);
            pinkPanel.addMouseListener(this);
            yellowPanel.addMouseListener(this);
             // Add Panels             
            panel.add(bluePanel, "Blue Panel");
            panel.add(greenPanel, "Panel 2");
            panel.add(redPanel, "Panel 3");
            panel.add(pinkPanel, "Panel 4");
            panel.add(yellowPanel, "Panel 5");
            // Add  color panel and Button panels
            this.add(panel);
            this.add(buttonPanel);
        } // end constructor
        
        // implement mouse events
        public void mousePressed(MouseEvent evt)
        {        	
            cards.next(panel);
        }
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseClicked(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}
       public void actionPerformed(ActionEvent av){}
    } // end CreatePanels
    
 // Button Panel to demonstrate the various Layoutmanagers.
    class ButtonPanel extends JPanel implements ActionListener, MouseListener
    {
    	public JButton gridBtn, flowBtn, borderBtn, cardBtn, nullBtn;
    	public ButtonPanel()
    	{
    		// Buutona	
    	    gridBtn = new JButton("Grid");
	    flowBtn = new JButton("Flow"); 
	    borderBtn = new JButton("Border");
	    cardBtn = new JButton("Card");
	    nullBtn = new JButton("Null");	
	    // Add Mouse Listeners
	    gridBtn.addMouseListener(this);
	    flowBtn.addMouseListener(this);
	    borderBtn.addMouseListener(this);
	    cardBtn.addMouseListener(this);
	    nullBtn.addMouseListener(this);
	    
	    this.setLayout(new FlowLayout());
	    this.setSize(500, 200);
	    this.add(flowBtn);
            this.add(gridBtn);
            this.add(borderBtn);
            this.add(cardBtn);
            this.add(nullBtn);            
    	}
    	// Impement all mouse listener 
    	public void actionPerformed(ActionEvent av){};
    	public void mouseClicked(MouseEvent evt)
    	{ 
    		// to dispalay Border Layout.
    		if(evt.getSource() == borderBtn)
    		{  		
    			setLayout(new BorderLayout(3, 2));    			
    			add(flowBtn,BorderLayout.CENTER); 			
    			this.add(gridBtn,BorderLayout.NORTH);   			
    			this.add(borderBtn, BorderLayout.SOUTH);
    			this.add(cardBtn, BorderLayout.EAST);			
    			this.add(nullBtn, BorderLayout.WEST);
    			this.validate();
    		}
    		// To display Grid Layout
    		if(evt.getSource() == gridBtn)
    		{    		
    			this.setLayout(new GridLayout(2, 3,2,2));    			
    			this.add(flowBtn);
    			this.add(gridBtn);
    			this.add(borderBtn);
    			this.add(cardBtn);
    			this.add(nullBtn);
    			this.validate();
    		}
    		// To display Flow layout
    		if(evt.getSource() == flowBtn)
    		{   					
    			this.setLayout(new FlowLayout(5, 3, 2));
    			this.add(flowBtn);
    			this.add(gridBtn);
    			this.add(borderBtn);
    			this.add(cardBtn);
    			this.add(nullBtn);
    			this.validate();
    		}
    		// to display Null layout
    		if(evt.getSource() == nullBtn)
    		{
    			this.setLayout(null);
    			flowBtn.setBounds(20,20,100,30);
    			this.add(flowBtn);
    			gridBtn.setBounds(20,60,100,30);
    			this.add(gridBtn);
    			borderBtn.setBounds(20,100,100,30);
    			this.add(borderBtn);
    			 cardBtn.setBounds(20,140,100,30);
    			this.add(cardBtn);   
    			nullBtn.setBounds(20,180,100,30);
    			this.add(nullBtn);
    			this.validate();
    		}    		
    	}
    	// implement mouse events
   	public void mousePressed(MouseEvent evt)
        { this.setLayout(new BorderLayout());
        }
   
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}           
    } 
    // Blue panel class
    class BluePanel extends JPanel implements ActionListener, MouseListener
    {
        public void mousePressed(MouseEvent evt){ }
        public void mouseEntered(MouseEvent evt) { }
        public void mouseExited(MouseEvent evt) { }
        public void mouseClicked(MouseEvent evt) { }
        public void mouseReleased(MouseEvent evt) { }      
        public void actionPerformed( ActionEvent av){}         
    } // end class panel1
    // Green Panel class      
    class GreenPanel extends JPanel implements ActionListener, MouseListener
    {	  
        public void mousePressed(MouseEvent evt){}
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseClicked(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}        
        public void actionPerformed(ActionEvent av){}        
    } // end class panel2
    // red panel class     
    class RedPanel extends JPanel implements ActionListener, MouseListener
    {
        public void mousePressed(MouseEvent evt){}
        public void mouseEntered(MouseEvent evt) { }
        public void mouseExited(MouseEvent evt) { }
        public void mouseClicked(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) { }       
        public void actionPerformed(ActionEvent av){}         
    } // end class panel3
     
     // pink Panel class
    class PinkPanel extends JPanel implements ActionListener, MouseListener
    {
        public void mousePressed(MouseEvent evt){}
        public void mouseEntered(MouseEvent evt) { }
        public void mouseExited(MouseEvent evt) { }
        public void mouseClicked(MouseEvent evt) { }
        public void mouseReleased(MouseEvent evt) { }
        public void actionPerformed(ActionEvent av){}
    } // end class panel4
    
    // Yellow Panel class      
    class YellowPanel extends JPanel implements ActionListener, MouseListener
    {
        public void mousePressed(MouseEvent evt){ }
        public void mouseEntered(MouseEvent evt) { }
        public void mouseExited(MouseEvent evt) { }
        public void mouseClicked(MouseEvent evt) { }
        public void mouseReleased(MouseEvent evt) { }
             
    public void actionPerformed(ActionEvent av){}
    } // end class panel5
     
} // end GamePrep


 

