
/********************
 * Sai Harsha Malireddy
 * Avatar.java 
 *******************
 This is a game in which you will have to move a person using only arrow keys, leading them to a certain spot(base).
 The person will stop onlyf when are opposed by an obect. Else, they will move off the screen and the level will be restarted.
 You will have to finad a route to lead the person to the base in a certain time limit. 
 Once this is achieved, you will proceed to the next level.
*/ 
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.Image.*;
import javax.imageio.*;
import java.awt.Graphics;

public class Avatar
{
    private MainPanel mainPanel;
    private JFrame frame;
    static Avatar game;
    
    public static void main (String [] args)
    {
        game = new Avatar();
        game.Run();
    }
     
    public void Run()
    {  
        // Initialize and set up the JFrame
        frame = new JFrame("Avatar Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
  
        mainPanel = new MainPanel();        
        mainPanel.setSize(800,800);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    } /// end Run
     
    
    class MainPanel extends JPanel implements MouseListener, ActionListener
    {         
        
    	    
    	// Layouts
    	private CardLayout cards;  
        
        // Panels
        private JPanel panel;
        public HelpPanel helpPanel;
        public HomePanel homePanel;
        public JPanel buttonPanel;
        public Level1 level1;
        public Level2 level2;
        public Level3 level3;
       
        // Components
        public JButton startBtn, helpBtn;
        JComboBox selectLevel;
        JTextField name;
    
        
        //Variables
        int red;  
        int green;  
        int blue;  
        
        public MainPanel()
        {   
            // Initalize Panels
            red = 70; //70
            green = 130; //130
            blue = 180;//180 
            Color myBlue = new Color(red,green,blue); 
            panel = new JPanel();	
            buttonPanel = new JPanel();
            level1 = new Level1();
            level2 = new Level2();
            level3 = new Level3();
            homePanel = new HomePanel();
            helpPanel = new HelpPanel();
            cards = new CardLayout();
            
            // Set Layouts
            this.setLayout(new BorderLayout()); 
            panel.setLayout(cards);
            buttonPanel.setLayout(new FlowLayout());
            homePanel.setLayout(new BorderLayout());
            helpPanel.setLayout(new BorderLayout());
            level1.setLayout(null);
            level2.setLayout(null);
            level3.setLayout(null);
 
            // Set Background
            homePanel.setBackground(Color.blue);           
            helpPanel.setBackground(Color.white);           
            buttonPanel.setBackground(Color.blue);
            level1.setBackground(myBlue);
            level2.setBackground(Color.yellow);
            level3.setBackground(Color.red);
           
            //Set Size
            panel.setSize(800, 700);
            homePanel.setSize(800,700);
            helpPanel.setSize(800,700);
            level1.setSize(800, 700);
            level2.setSize(800, 700);
            level3.setSize(800, 700);
            buttonPanel.setSize(800,100);
            
        
        //ButtonPanel
 
            // Initalize Buttons / TextField
            helpBtn = new JButton("Help");
            startBtn = new JButton("Start Game"); 
            name = new JTextField("Enter Name");
            selectLevel = new JComboBox();
            
             // Add Butttons/ TextField To ButtonPanel
            buttonPanel.add(helpBtn);
            buttonPanel.add(startBtn);
            buttonPanel.add(name);
            buttonPanel.add(selectLevel);
            selectLevel.addItem("Level 1");
            selectLevel.addItem("Level 2");
            selectLevel.addItem("Level 3");
            //homePanel.add(title);
            
            // Add ActionListener
            helpBtn.addActionListener(this);
            selectLevel.addActionListener(this);
            //startBtn.addActionListener(this);
            
            // Add Panels To Panel           
            panel.add(homePanel, "Home Panel");
            panel.add(helpPanel, "Help Panel");
            panel.add(level1, "Level 1");
            panel.add(level2, "Level 2");
            panel.add(level3, "Level 3");
            
            // Add To Frame
            this.add(panel, BorderLayout.CENTER);
            this.add(buttonPanel, BorderLayout.SOUTH);
            panel.addKeyListener(level1);
            //panel.addMouseListener(level1);
            
        }/// end constructor Main Panel
        
        // actionPerformed
        public void actionPerformed(ActionEvent evt)
        {
    		if(evt.getSource() == helpBtn) 
    		{	
    			helpPanel.setVisible(true);
    			homePanel.setVisible(false);
    			level1.setVisible(false);
    			level2.setVisible(false);
    			level3.setVisible(false);
    			
						
    		} /// end if
    		
    		else 
    		{
    		
    			JComboBox selectLevel = (JComboBox) evt.getSource();
    			Object obj = evt.getSource();
    			Object selected = selectLevel.getSelectedItem();
			
    			if("Level 1".equals(selected))
    			{
    				
    				level1.setVisible(true);
    				level1.setFocusable(true);
    				level1.requestFocus();
    				//level1.setRequestFocusEnabled(true);
    				level2.setVisible(false);
    				level3.setVisible(false);
    				helpPanel.setVisible(false);
    				homePanel.setVisible(false);
    			}
    			
    			if("Level 2".equals(selected)) 
				{
    				level2.setVisible(true);
    				level1.setVisible(false);
    				level3.setVisible(false);
    				helpPanel.setVisible(false);
    				homePanel.setVisible(false);
				}
			
    			if("Level 3".equals(selected)) 
				{
    				level3.setVisible(true);
    				level1.setVisible(false);
    				level2.setVisible(false);
    				helpPanel.setVisible(false);
    				homePanel.setVisible(false);
				}
    		} /// end else	
    	
    		/*else if(evt.getSource() == startBtn) 
    		{
    			level1.setVisible(true);
    			level2.setVisible(false);
    			level3.setVisible(false);
    			helpPanel.setVisible(false);
    			homePanel.setVisible(false);
    		}*/ 
        
        }/// end actionPerformed
    	
        
	// Implement MouseEvents
		public void mouseClicked(MouseEvent evt) {}	
		public void mousePressed(MouseEvent evt) {}
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}
      
    } /// end class MainPanel
    
    class HomePanel extends JPanel implements ActionListener, MouseListener
    {
    	Image title;

    		
       	public HomePanel()
       	{
       		
       		GetImage();
       		
       	} /// end HelpPanel
    	
    	
    	public void GetImage()
        {
        	try
            { 		
        		
        	    title = ImageIO.read(new File("Title.jpg"));
   
        	    	
        	}
        	catch(IOException e) 
        	{
        	   	System.err.println("Cannot get image");
        	}
        	
        } /// end GetImage 
       	
    	public void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		g.setColor(Color.black);
    		g.drawImage(title, 10 ,10 , 780, 700, this);
    	
    	} /// end paintComponent
    	   
    	  
    	public void mousePressed(MouseEvent evt){ }
        public void mouseEntered(MouseEvent evt) { }
        public void mouseExited(MouseEvent evt) { }
        public void mouseClicked(MouseEvent evt) { }
        public void mouseReleased(MouseEvent evt) { }      
        public void actionPerformed( ActionEvent av){}         

    } /// end class Homepanel

    // Instructions Panel
    class HelpPanel extends JPanel implements ActionListener, MouseListener
    {
    
       	JTextArea infoText;
   		
       	public HelpPanel()
       	{
       		infoText = new JTextArea();
       		this.add(infoText);
       	} /// end HelpPanel
   		
    	public void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		g.setColor(Color.black);
    		infoText.setText("The goal of the game is to navigate the human on the floating rock to his base - in the fewest moves possible using just the arrow keys for control. One key press will send the person moving in that direction, and it will keep moving in a straight line until a floating mountain causes it to come to rest or spawn in a different position. If the person goes off the board, you must start the level again. There is a time limit of 2 minutes to get to the base. If the base is not reached by that time, then the game will be over and you will have to restart the level.");
       		infoText.setLineWrap(true);
			infoText.setWrapStyleWord(true);
       		infoText.setEditable(false);
       		Font font = new Font("Serif", Font.ITALIC, 40);
       		infoText.setFont(font);
       		infoText.setForeground(Color.red);
       		this.add(infoText);
    	} /// end paintComponent
    	   
    	  
    	public void mousePressed(MouseEvent evt){ }
        public void mouseEntered(MouseEvent evt) { }
        public void mouseExited(MouseEvent evt) { }
        public void mouseClicked(MouseEvent evt) { }
        public void mouseReleased(MouseEvent evt) { }      
        public void actionPerformed( ActionEvent av){}         
    
    } /// end class HelpPanel

   
    /////// Range: x <= 750, y <= 600
    class Level1 extends JPanel implements KeyListener, ActionListener, MouseListener
    {	   
    	
    
   	Image mountain, person, base;
   	private int lev1_per_x_pos;
   	private int lev1_per_y_pos;
   	private int lev1_mtn1_x_pos;
   	private int lev1_mtn2_x_pos;
   	private int lev1_mtn3_x_pos;
   	private int lev1_mtn4_x_pos;
   	private int lev1_mtn5_x_pos;
   	//Y Position
   	private int lev1_mtn1_y_pos;
   	private int lev1_mtn2_y_pos;
   	private int lev1_mtn3_y_pos;
   	private int lev1_mtn4_y_pos;
   	private int lev1_mtn5_y_pos;
   	private int lev1_base_x_pos;
   	private int lev1_base_y_pos;
   	private int[] y_arr;
   	private int[] x_arr;
   	boolean a,b,c,d = true;
   	
   	
   	/**
   	 * put mtn x positions in array list
   	 * Move to the position of the x or the y co-ordinates of the mountains first based on the y or x comparisons
   	 */
   	
   	public Level1()
   	{
		
	
		lev1_per_x_pos = 400;
		lev1_per_y_pos = 400;
		
		x_arr = new int[6];
		x_arr[0] = lev1_mtn1_x_pos = 100;
		x_arr[1] = lev1_mtn2_x_pos = 200;
		x_arr[2] = lev1_mtn3_x_pos = 400; 
		x_arr[3] = lev1_mtn4_x_pos = 150;
		x_arr[4] = lev1_mtn5_x_pos = 350;
		x_arr[5] = lev1_base_x_pos = 250;
		
		
		y_arr = new int[6];
		//Y Position
		y_arr[0] = lev1_mtn1_y_pos = 150;
		y_arr[1] = lev1_mtn2_y_pos = 100;
		y_arr[2] = lev1_mtn3_y_pos = 200;
		y_arr[3] = lev1_mtn4_y_pos = 500;
		y_arr[4] = lev1_mtn5_y_pos = 550;
		y_arr[5] = lev1_base_y_pos = 400;
		//y_arr = {lev1_mtn1_y_pos};
		
		GetImage();
	    addKeyListener(this);
	 
   	}
    	
	public void keyPressed(KeyEvent e) 
	{
		
		int key = e.getKeyCode();  		// keyboard code for the pressed key
   		
   		 
		if (key == KeyEvent.VK_LEFT) 
		{  								// left-arrow key; move the square left
				while((lev1_per_x_pos > 0)&& (a == true))
				{ 
					
						lev1_per_x_pos -= 5;
						
						for (int j = 0; j < x_arr.length; j++) 
						{
							if ((lev1_per_x_pos == x_arr[j] + 70) && (lev1_per_y_pos == y_arr[j])) 
							{
								a = false;
								
								lev1_per_x_pos = x_arr[j] + 70;					   		
					   			repaint();                                                                                                           
							}
							 
							else 
							{
								repaint();
							}
						} /// end for
			
				} /// end while
			
		}/// end left condition
		
		else if (key == KeyEvent.VK_RIGHT) 
		{  									// right-arrow key; move the square right
  	 		while((lev1_per_x_pos < 760) && (b == true))
			{ 
					
						lev1_per_x_pos += 5;
						
						for (int j = 0; j < y_arr.length; j++) 
						{
							if ((lev1_per_x_pos == x_arr[j]) && (lev1_per_y_pos == y_arr[j])) 
							{
								b = false;
								lev1_per_x_pos = x_arr[j];					   		
					   			repaint();                                                                                                           
							}
							 
							else 
							{
								repaint();
							}
						} /// end for
			
				} /// end while
				 
  	 	} /// end right condition
  	 	
  	 	else if (key == KeyEvent.VK_UP)
  	 	{  										// up-arrow key; move the square up
  	 		while((lev1_per_y_pos > 40) && (c == true))
			{ 
					
						lev1_per_y_pos -= 5;
						
						for (int j = 0; j < y_arr.length; j++) 
						{
							if ((lev1_per_x_pos == x_arr[j]) && (lev1_per_y_pos == y_arr[j] + 70)) 
							{
								c = false;
								lev1_per_y_pos = y_arr[j] + 70;					   		
					   			repaint();                                                                                                           
							}
							 
							else 
							{
								repaint();
							}
						} /// end for
			
				} /// end while
  	 	
  	 	} /// end up condition
  	 
  	 	else if (key == KeyEvent.VK_DOWN)
  	 	{  										// down-arrow key; move the square down
  	 	 	while((lev1_per_y_pos < 710) && (d == true))
			{ 
					System.out.println("down");
						lev1_per_y_pos += 5;
						
						for (int j = 0; j < x_arr.length; j++) 
						{
							if ((lev1_per_x_pos == x_arr[j]) && (lev1_per_y_pos == y_arr[j])) 
							{
								d = false;
								lev1_per_y_pos = y_arr[j];					   		
					   			repaint();    
					   			System.out.println("down2");                                                                                                       
							}
							 
							else 
							{
								System.out.println("down3");     
								repaint();
							}
						} /// end for
			
				} /// end while
  	 		
  	 	} /// end down condition
  	 	
  	} /// end keypPressed
    	
    public void paintComponent(Graphics g)
    {
		super.paintComponent(g);		
		g.drawImage(mountain, lev1_mtn1_x_pos ,lev1_mtn1_y_pos , 70, 70, this);
		g.drawImage(mountain, lev1_mtn2_x_pos, lev1_mtn2_y_pos , 70, 70, this);
		g.drawImage(mountain, lev1_mtn3_x_pos, lev1_mtn3_y_pos , 70, 70, this);
		g.drawImage(mountain, lev1_mtn4_x_pos, lev1_mtn4_y_pos , 70, 70, this);
		g.drawImage(mountain, lev1_mtn5_x_pos, lev1_mtn5_y_pos , 70, 70, this);
		g.drawImage(person,lev1_per_x_pos ,lev1_per_y_pos, 20, 20, this);
		g.drawImage(base, lev1_base_x_pos, lev1_base_y_pos, 40, 40, this);
		
    	 	
	} /// end paintComponent
    	
	public void GetImage()
    {
    	try
        { 		
    		
    	    mountain = ImageIO.read(new File("mountain.jpg"));
    	    person = ImageIO.read(new File("person.jpg"));
    	    base = ImageIO.read(new File("base.jpg"));
    	    	
    	}
    	catch(IOException e) 
    	{
    	   	System.err.println("Cannot get image");
    	}
    	
    } /// end GetImage 
    	
		public void keyReleased(KeyEvent evt) {}
		public void keyTyped(KeyEvent evt) {}
    	public void mousePressed(MouseEvent evt){}
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseClicked(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}
        public void actionPerformed(ActionEvent av){}
    
    } /// end class Level1
 
    class Level2 extends JPanel implements ActionListener, MouseListener
    {	   
    	
       
    	public void mousePressed(MouseEvent evt){}
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseClicked(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}        
        public void actionPerformed(ActionEvent av){}        
    
    } /// end class Level2
    
    class Level3 extends JPanel implements ActionListener, MouseListener
    {	   
    	
       
    	public void mousePressed(MouseEvent evt){}
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseClicked(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}        
        public void actionPerformed(ActionEvent av){}        
    
    } /// end class Level3
} /// end class Avatar











/// HomePanel
/*
    		JTextArea homeText;
		homeText = new JTextArea();
    	 	homeText.setText("Pandora Adventure");
    	 	homeText.setEditable(false);
    	 	homeText.setLineWrap(true);
		homeText.setWrapStyleWord(true);
    	 	this.add(homeText);
*/