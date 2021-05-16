
/************************
 * Sai Harsha Malireddy                 
 * Pandora.java
 ***********************
// This program provides an example of different layouts:
// BorderLayout, FlowLayout, GridLayout, and CardLayout and null layout.
// Five Panels are implemented in 5 classes and used for card layout.
// Another 5 Buttons are used in Button panel to demonstrate other four Layouts

// VAriables
// 
// game : instance varibale for GamePrep.
*/ 
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.awt.Image.*;
import javax.imageio.*;
 
public class Pandora_2
{
    private MainPanel panel;
//  private ButtonPanel  buttonPanel;
    private JFrame frame;
     
    public static void main (String [] args)
    {
        Pandora_2 game = new Pandora_2();
        game.Run();
    }
     
    public void Run()
    {
        // Initialize and set up the JFrame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
 
        // Create the colors panel and buttons panel
        panel = new MainPanel(); 
	panel.setSize(500, 500);        
        // add the JPanels to the frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    } // end Run
     
    class MainPanel extends JPanel implements MouseListener, ActionListener
    {         
        private CardLayout cards; 
        public JPanel panel2;
        public JPanel imagePanel;   // Opening page
        public DisplayPanel displayPanel;  // Display Game
        public HelpPanel helpPanel;  //help info    
        public JButton startBtn, helpBtn, login;
         JTextField name;
        
//        public InfoPanel infoPanel;             
        public MainPanel()
        {      
            panel2 = new JPanel();	
            cards = new CardLayout();
            
            imagePanel = new JPanel();
            displayPanel = new DisplayPanel();
            helpPanel = new HelpPanel();
                       
            login = new JButton("Log in");
    	    name = new JTextField("Enter Name");    	             
//    	 String[] levels = { "L1"}; 
    	    JComboBox selectLevel = new JComboBox();
    	    helpBtn = new JButton("Help");
	    startBtn = new JButton("Start Game"); 
	    	
	    // Add Mouse Listeners
//	    imagePanel.setSize(50, 500);
	    helpBtn.addMouseListener(this);
	    startBtn.addMouseListener(this);
	    selectLevel.addActionListener(this);
	    login.addActionListener(this);
  	                
//	    this.setLayout(null);
	    panel2.setSize(500, 500);
//	    displayPanel.setSize(400, 500);
	    helpPanel.setSize(400, 500);
	    imagePanel.setSize(400, 500);

//            displayPanel.setBackground(Color.blue);           
            helpPanel.setBackground(Color.green);
            imagePanel.setBackground(Color.red);
          
//             displayPanel.addMouseListener(this);

            // Add Panels  
//            panel.setLayout(cards); // set cardLayout for color Panels
//           panel.setLayout( new BorderLayout());
//            panel.add(displayPanel, "Display Panel");
//            panel.add(helpPanel, "Help Panel ");
   
            
           	panel2.setBackground(Color.red); 
            	panel2.setLayout(cards);
		panel2.add(helpPanel);
		panel2.add(imagePanel);
		panel2.setVisible(true);
		
		JPanel panel1 = new JPanel(); 
	     	panel1.setLayout( new BorderLayout());
	     	panel1.setBackground(Color.blue);
	     	panel1.setSize(100, 500);

	     	panel1.setLayout( new GridLayout (5, 1));
	     	panel1.add(name);
	     	panel1.add(login);
	     	panel1.add(selectLevel);
	     	panel1.add(helpBtn);
	     	panel1.add(startBtn);
//            name.setBounds(400, 100, 50, 30);
///	    panel.add("East", panel1);
//	    panel.add("West", imagePanel);

            	panel1.setVisible(true);   
                     
//	    this.setSize(100, 500);
            // Add  display pane/ help panel and Info panels
//           this.setLayout( new GridLayout(1,2));
	   this.setLayout( new BorderLayout());	
           this.add(panel2, BorderLayout.WEST);       
           this.add(panel1, BorderLayout.EAST);           
           setVisible(true);
        } // end constructor
        public void mousePressed(MouseEvent evt){ }
        public void mouseEntered(MouseEvent evt) { }
        public void mouseExited(MouseEvent evt) { }
        public void mouseClicked(MouseEvent evt) 
        {
        	if(evt.getSource() == helpBtn)
    			{  	
    				System.out.println("HI");
    				helpPanel.setVisible(true);
    				displayPanel.setVisible(false);
//    				text.add(hPanel);
//    				text.setText("Hi Help");
				helpPanel.setBackground(Color.green);
				helpPanel.setSize(400, 500);
				this.add(helpPanel);
				helpPanel.setVisible(true);
			}
			
		if(evt.getSource() == startBtn)
    			{  	
    				System.out.println("Start Button");
    				displayPanel.setVisible(true);
    				helpPanel.setVisible(false);
    				
//    				text.add(hPanel);
//    				text.setText("Hi Help");
				displayPanel.setBackground(Color.blue);
//				imagePanel.setSize(400, 500);
				this.add(displayPanel);
				displayPanel.setVisible(true);
			}
			
	}
        public void mouseReleased(MouseEvent evt) {}      
        public void actionPerformed(ActionEvent av){}    
     }                     

    // Blue panel class
    class HelpPanel extends JPanel implements ActionListener, MouseListener
    {
    	
    /*	public void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    	//	g.drawString("WELCOME TO PANDORA ADVENTURE", 100, 50);
    	
    	JTextArea textArea = new JTextArea(" WELCOME TO PANDORA ADVENTURE");
    //	textArea.setEditable(false);
	//textArea.append(" WELCOME TO PANDORA ADVENTURE");
//	this.add(textArea);	
    	//	super.paintComponent();
    	}	
*/
    	
        public void mousePressed(MouseEvent evt){ }
        public void mouseEntered(MouseEvent evt) { }
        public void mouseExited(MouseEvent evt) { }
        public void mouseClicked(MouseEvent evt) { }
        public void mouseReleased(MouseEvent evt) { }      
        public void actionPerformed( ActionEvent av){}         
    } // end class panel1
    // Green Panel class      
    class DisplayPanel extends JPanel implements ActionListener, MouseListener
    {	  
    	    Image avatar, mountain;
    //	    DispalyPane
    	public void paintComponent(Graphics g)
		{
		super.paintComponent(g);		
		GetImage();
		g.drawImage(avatar, 30, 30, Color.BLUE, this);
		g.drawImage(mountain, 30, 130, Color.BLUE, this);
		}
    	     
    	    public void GetImage()
    	    {
    	    	    try
    	    	    {
    	    	    	    avatar 	 = ImageIO.read(new File("Avatar.jpg"));   		
    	    	    	    mountain = ImageIO.read(new File("Mountain.jpg"));
    	    	    }
    	    	    catch(IOException e)
    	    	    {
    	    
    	    	    }
    	    }
        public void mousePressed(MouseEvent evt){}
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseClicked(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}        
        public void actionPerformed(ActionEvent av){}        
    } // end class panel2
    // red panel class     
    // end class panel5
  }    
 // end GamePrep


 

