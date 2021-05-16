 

/********************
 * Sai Harsha Malireddy
 * Game.java
*********************/
 /*************************************
Game : 
   The game is based on Avatar 
   This game can be played in three levels - Easy, Medium, Hard levels.
   The user has to find a way to reach the base(target) through various mountains in his chopper.
 WIN condition :
    User should navigate through the mountains.
    Answer educational questions asked by Dragon on the way.
    Arrive at the base within the time specified.
 LOSE Condition:
    If user cannot find the way to base and exits of the screen. 
    If he cannot reach within the time specified.
 
 Visual Components:
    Start button : To start the game and to start Timer for the game.
    Reset button : To stop the timer and to reset the game to original positions.
    Level ComboBox : To choose three levels , Easy, Medium, and hard levels.
    Help Button  :  Shows the help panel. Mouse over the picture to get the text help.
    Home Button  : To go back to Home of the game.
    Name TextField : User to enter the name.
    Timer text Button : Timer to display number of seconds left to complete the game.
    HomePanel   : To display Home page
    HelpPanel	: To display help instructions for the game
    MainPanel	: Will have Levels panels and Button Panels
    ButtonPanel : Will have all buttons, Home, Help, Start, Reset, Name textbox
    Level1Panel : Easy level of game.
    Level2Panel : Medium level of game.
    Level3Panel : Hard level of game.
***************************************/

  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.Graphics;
import java.util.Timer;
import java.util.Scanner;
import javax.swing.JTabbedPane;
import java.lang.String;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Game
{
    private MainPanel mainPanel; 
    private JFrame frame;
    static Game game;
    

    long elapsedTime = 2;
    Timer timer;
    int charsWritten = 0;
    long start = System.currentTimeMillis();
    String timeCount;
    JTextArea tmTxt1 = new JTextArea("120");
    JTextArea tmTxt2 = new JTextArea("120");
    JTextArea tmTxt3 = new JTextArea("120");
    long secsLeft = 120;

    
    
    
    public static void main (String [] args)
    {
        game = new Game();
        game.Run();
    }
     
    public void Run()
    {  
        // Initialize and set up the JFrame
        frame = new JFrame("Avatar Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        
        mainPanel = new MainPanel();        
        mainPanel.setSize(800,800);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setResizable(false);
     
    } /// end Run
    
    class MainPanel extends JPanel implements MouseListener, ActionListener, KeyListener
    {         
        
    	String level = "none";
    	// Layouts
    	private CardLayout cards;  
        
        // Panels
        public JPanel panel;
        public HelpPanel helpPanel;
        public HomePanel homePanel;
        public JPanel buttonPanel;
        public Level1 level1;
        public Level2 level2;
        public Level3 level3;
       	public String name = ""; 
        // Components
        public JButton homeBtn, helpBtn, startBtn, resetBtn;
        boolean gameStarted = false;
        javax.swing.Timer t;
        JComboBox selectLevel;
        JTextField textField;
    
        
        //Images
        Image mtn, chopper, base, background, dragon;
       
		

        
        public MainPanel()
        {   
            
           // Initializing all JPanels
            panel = new JPanel();	
            buttonPanel = new JPanel();
            level1 = new Level1();
            level2 = new Level2();
            level3 = new Level3();
            homePanel = new HomePanel();
            helpPanel = new HelpPanel();
            cards = new CardLayout();
            
            // Set Layouts
            setLayout(new BorderLayout()); 
            panel.setLayout(cards);
            buttonPanel.setLayout(new FlowLayout());
            homePanel.setLayout(new BorderLayout());
            level1.setLayout(null);
            level2.setLayout(null);
            level3.setLayout(null);
 
            // Set Background
            homePanel.setBackground(Color.blue);           
            helpPanel.setBackground(Color.white);           
            buttonPanel.setBackground(Color.blue);
           
           
            //Set Size
            panel.setSize(800, 700);
            homePanel.setSize(800,700);
            helpPanel.setSize(800,700);
            level1.setSize(800, 700);
            level2.setSize(800, 700);
            level3.setSize(800, 700);
            buttonPanel.setSize(800,100);
            
        
            //ButtonPanel
 
            // Initialize Buttons / TextField
            homeBtn = new JButton("Home");
            helpBtn = new JButton("Help");
            startBtn = new JButton("Start");
            resetBtn = new JButton("Reset");
            textField = new JTextField("Enter Name"); 
            selectLevel = new JComboBox();
            
             // Add Buttons/ TextField To ButtonPanel
            buttonPanel.add(homeBtn);
            buttonPanel.add(helpBtn);
            buttonPanel.add(textField);
            buttonPanel.add(selectLevel);
            buttonPanel.add(resetBtn);
            buttonPanel.add(startBtn);
           	selectLevel.addItem("SELECT LEVEL");
            selectLevel.addItem("Easy");
            selectLevel.addItem("Medium");
            selectLevel.addItem("Hard");
           
            
            // Add ActionListener/ MouseListener to buttons and comboBox
            helpBtn.addMouseListener(this);
            startBtn.addMouseListener(this);
            resetBtn.addMouseListener(this);
            homeBtn.addMouseListener(this);
            selectLevel.addActionListener(this);
           
            
            // Add Panels To Panel           
            panel.add(homePanel, "Home Panel");
            panel.add(helpPanel, "Help Panel");
            panel.add(level1, "Easy");
            panel.add(level2, "Medium");
            panel.add(level3, "Hard");
            
            // Adding to MainPanel
            this.add(panel, BorderLayout.CENTER);
            this.add(buttonPanel, BorderLayout.SOUTH);
            panel.addKeyListener(level1);
           
            textField.addKeyListener(this);
           
        }/// end constructor Main Panel 
        
        public void keyPressed(KeyEvent evt) {}
       
		public void keyTyped(KeyEvent evt) {}
		
        public void keyReleased(KeyEvent evt) 
        {
        	
     	 name = textField.getText(); // Getting name that is typed
     	 
        }
      
        // actionPerformed
        public void actionPerformed(ActionEvent evt)
        {
			reset(); // Calls reset method
				
				// Checking which level is selected in comboBox and displaying it
    			JComboBox selectLevel = (JComboBox) evt.getSource();
    			Object selected = selectLevel.getSelectedItem();
				
    			if("Easy".equals(selected))
    			{
    				level = "Easy";
    				secsLeft = 120; // Reinitializing number of seconds for timer
    				
    					level1.setVisible(true);
    					level1.setFocusable(true);
    					level1.requestFocus();
    					level2.setVisible(false);
    					level3.setVisible(false);
    					helpPanel.setVisible(false);
    					homePanel.setVisible(false);
		
    			}					
    			
    			if("Medium".equals(selected)) 
				{
    				level = "Medium";
    				secsLeft = 120;
    				
    					level2.setVisible(true);
    					level2.setFocusable(true);
    					level2.requestFocus();
    					level1.setVisible(false);
    					level3.setVisible(false);
    					helpPanel.setVisible(false);
    					homePanel.setVisible(false);
    		
				}
			
    			if("Hard".equals(selected)) 
				{
    				level = "Hard";
    				secsLeft = 120;
    				
    					
    					level3.setVisible(true);
    					level3.setFocusable(true);
    					level3.requestFocus();
    					level1.setVisible(false);
    					level2.setVisible(false);
    					helpPanel.setVisible(false);
    					homePanel.setVisible(false);
				}				
    
        }/// end actionPerformed
    
        // Implement MouseEvents
		public void mouseClicked(MouseEvent evt) 
		{
			// Checks if home or help buttons are clicked and displays panel
			if(evt.getSource() == helpBtn) 
    		{	
    			helpPanel.setVisible(true);
    			homePanel.setVisible(false);
    			level1.setVisible(false);
    			level2.setVisible(false);
    			level3.setVisible(false);
    			
						
    		} /// end if
    		else if(evt.getSource() == homeBtn) 
    		{	
    			homePanel.setVisible(true);
    			helpPanel.setVisible(false);
    			level1.setVisible(false);
    			level2.setVisible(false);
    			level3.setVisible(false);
    			
    		} /// end if
    		else if(evt.getSource() == startBtn) 
    		{
    			
    			//initialize the game with method
    			gameStarted = true;
    			if(level.equals("Easy")) 
    			{
    				level1.reset = false;  // sets level1 reset variable to false
    			} 
    			else if(level.equals("Medium")) 
    			{
    				level2.reset = false;
    			} 
    			else if(level.equals("Hard")) 
    			{
    				level3.reset = false;
    			}
    			if(t == null) // t is timer object
    			{
	    			ActionListener listener = new ActionListener() 
	    			{
	    				public void actionPerformed(ActionEvent evt) 
	    				{
	    					secsLeft = secsLeft - 1; // Decrementing number of seconds
	    	    			
	    					// Checks which level is selected and sets the number of seconds to textArea tmTxt
	    					if(level.equals("Easy"))
	    	    			{
	    		    			tmTxt1.setText("" + secsLeft); 
	    	    			} 
	    	    			else if(level.equals("Medium")) 
	    	    			{
	    		    			tmTxt2.setText(""  + secsLeft);
	    	    			} 
	    	    			else if(level.equals("Hard")) 
	    	    			{
	    		    			tmTxt3.setText(""  + secsLeft);
	    	    			}
	    		    		
	    					//If number of seconds is less than zero it checks which level is selected, sets the levels timeup boolean 
	    					// variables to true, and repaints the certain panel. Also stops the timer.
	    					if(secsLeft <= 0) 
	    		    		{
	    		    			if(level.equals("Easy")) 
	    		    			{
	    		    				level1.timeup = true; 
	    		    				level1.repaint();
	    		    			}
	    		    			
	    		    			if(level.equals("Medium")) 
	    		    			{
	    		    				level2.timeup = true;
	    		    				level2.repaint();
	    		    			}
	    		    			
	    		    			if(level.equals("Hard")) 
	    		    			{
	    		    				level3.timeup = true;
	    		    				level3.repaint();
	    		    			}
	    		    			t.stop(); // Stops the timer
	    		    			t = null;
	    		    		
	    		    		}
	    				} /// end actionPerformed
	    			};
	    			t = new javax.swing.Timer(1000, listener); // Fires event every second
	    			t.start();
	    			
	    			// Gets the focus for the panel that is selected
	    			if(level.equals("Easy")) 
	    			{
		    			level1.setFocusable(true);
		    			level1.requestFocus();
	    			} 
	    			else if(level.equals("Medium")) 
	    			{
		    			level2.setFocusable(true);
		    			level2.requestFocus();
	    			} 
	    			else if(level.equals("Hard")) 
	    			{
		    			level3.setFocusable(true);
		    			level3.requestFocus();
	    			}
    			} /// end if
    			
    			
    		} /// end if
    		
    		// If resetBtn is clicked it calls reset method
    		else if(evt.getSource() == resetBtn) 
    		{
    			reset();
    		} /// end if
			
    		
			
		}/// end mouseClicked
		
		// Reset method stops the timer, calls init to initialize variables, sets the levels boolean reset to 
		// true, and requests focus
		public void reset() 
		{
			if(t != null) 
			{
				t.stop();
			}
			t = null;
			gameStarted = false;
			secsLeft = 120;
			
			//initialize the game with method
			if(level.equals("Easy")) 
			{
    			level1.init();
    			level1.reset = true;
    			level1.repaint();

    			level1.setFocusable(true);
    			level1.requestFocus();
			} 
			else if(level.equals("Medium")) 
			{
    			level2.init();
    			level2.reset = true;
    			level2.repaint();

    			level2.setFocusable(true);
    			level2.requestFocus();
			} 
			else if(level.equals("Hard")) 
			{
    			level3.init();
    			level3.reset = true;
    			level3.repaint();

    			level3.setFocusable(true);
    			level3.requestFocus();
			}
		}
		
		// Gets the name of player, current date, time, and level played. Writes information to text file
		public void SaveInfo()
	   	{
	   		
	   		Date date = new Date();
	   		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   		try 
	   		{
	   			
				File file = new File("SaveInfo.txt");	
	   			
				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				 
				 //get current date time with Date()
				 
		   //System.out.println(dateFormat.format(date));
				
				bw.write(""+(dateFormat.format(date))+"    ");
		   		bw.write(""+name+"   ");
				
				bw.write(""+level);
				bw.close();
	 
				
	 
			} catch (IOException e) {
				e.printStackTrace(); 
			}
			
			
			
	   	}
		
		public void mousePressed(MouseEvent evt) {}
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}
      
       
   
    // Creates homePanel: adds Title image
    class HomePanel extends JPanel 
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
        

    } /// end class HomePanel

    // Instructions Panel
    // Creates JTabbedPane for instructions. Adds image, and when mouse is moved to image, 
    // instructions are displayed
    class HelpPanel extends JPanel implements MouseMotionListener
    {
    	ImageIcon icon;
       	JPanel jp1;
    	JTabbedPane tabbedPane;
    	JTextArea infoText;
    	Image arrow;
    	JLabel picLabel;
    	boolean target;
       	
    	public HelpPanel()
       	{
    		target = false;
    		picLabel = new JLabel(new ImageIcon( "Arrow.jpg"));
    		icon = new ImageIcon("Arrow.jpg");
       		GetImage();
       		jp1 = new JPanel();
       		jp1.setBackground(Color.white);
       		infoText = new JTextArea();
       		infoText.setBounds(0,0,800,200);
            setLayout(null);
       		tabbedPane = new JTabbedPane();
       		tabbedPane.setBounds(0,0,800,660);
        	tabbedPane.addTab("Instructions", icon,jp1);
        	add(tabbedPane);
        	
      	}
           
       
		public void GetImage()
       	{
       		
       		try
            { 		
        		
        	    arrow = ImageIO.read(new File("Arrow.jpg"));
        	     
        	}
        	catch(IOException e) 
        	{
        	   	System.err.println("Cannot get image");
        	}
       	}
       	
    	public void paintComponent(Graphics g)
    	{
    		
       		
    		super.paintComponent(g);
    		g.setColor(Color.black);
    		
    		infoText.setText(" The goal of the game is to navigate the chopper to its base. One key press will send the chopper moving  in that direction, and it will keep moving in a straight line until a mountain causes it to  come to rest. If the chopper goes off the board, you must restart the level. There is a time limit of 2 minutes to get to the base. If the base is not  reached by that time, then the game will be over and you will have to restart the level.");
    		infoText.setLineWrap(true);
			infoText.setWrapStyleWord(true);
       		infoText.setEditable(false);
       		Font font = new Font("Serif", Font.ITALIC, 40);
       		infoText.setFont(font);
       		infoText.setForeground(Color.blue);
       		jp1.add(picLabel);
       		if(target)
    		{
       			jp1.add(infoText);
    		}
       		
       		jp1.addMouseMotionListener(this);
    	} /// end paintComponent
    	   
    	public void mouseDragged(MouseEvent evt) {}
    	
    	public void mouseMoved(MouseEvent evt) 
    	{ 
    		
    		if(((evt.getPoint().x >= 280) && (evt.getPoint().x <= 480)) && ((evt.getPoint().y >= 50) && (evt.getPoint().y <= 150)))
    		{
    			target = true;
    			repaint();
    			
    		}
    		
    	}
    	
    
    } /// end class HelpPanel

   
   // Level1 class
    class Level1 extends JPanel implements KeyListener, ActionListener
    {	   
    	
    // Creating images, x, y positions of images, boolean reset, timeup, and Scanner infile
   	Image mtn, chopper, base, background, dragon;
   	private int chopper_xpos;
   	private int chopper_ypos;
   	private int mtn_xpos;
   	private int mtn_ypos;
   	private int base_xpos;
   	private int base_ypos;
   	private int dragon_xpos;
   	private int dragon_ypos;
   	private int[] y_arr;
   	private int[] x_arr;
   	boolean a,b,c,d, win, lose, mtn_at_left, mtn_at_right, mtn_at_up, mtn_at_down, other_move_left, other_move_right, other_move_up, other_move_down;
   	private Scanner inFile;
   	String name1;
	public boolean reset;
	public boolean timeup;
	
   	public Level1()
   	{
   		init();
  
		x_arr = new int[5];

		y_arr = new int[5]; 
		
		
		GetImage();
		GetValues1();
		
		tmTxt1.setBounds(700, 5, 50, 20);
		add(tmTxt1);
		tmTxt1.setEditable(false);
	    addKeyListener(this);
	    
   	}
   	
   	// Initializes variables 
   	public void init() {
   		timeup = false;
   		reset = false;
   		lose = false;
   		win = false;
   		other_move_left = false;
   		other_move_right = false;
   		other_move_up = false;
   		other_move_down = false;
   		mtn_at_left = false;
   		mtn_at_right = false;
   		mtn_at_up = false;
   	 	mtn_at_down = false;
		chopper_xpos = 380; 
		chopper_ypos = 360; 
		base_xpos = 300;
		base_ypos = 400;
		dragon_xpos = 300;
		dragon_ypos = 480;
   	}
   
   	// Reads text file to get coordinates of images 
   	public void GetValues1()
   	{
   		String fileName = "Values.txt";
   		int number = 0;
   		try 
   		{
			inFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.printf("ERROR: Cannot open %s\n", fileName);
			System.exit(1); 
		}
		while (inFile.hasNext()) 
		{
			
			for(int i = 0; i < x_arr.length; i++)
			{
				
				number = inFile.nextInt();
				x_arr[i] = number;
				
			}
			for(int j = 0; j < y_arr.length; j++)
			{
				
				number = inFile.nextInt();
				y_arr[j] = number;
				
			}
			
		}
		inFile.close();
		
   	} /// end GetValues
   	
   	
   	
   	// Movement of the chopper
	public void keyPressed(KeyEvent e) 
	{
		if(gameStarted == false) return;
		
		int key = e.getKeyCode();  		// keyboard code for the pressed key

		start = start + 120000;

		
   		
   		 
		if (key == KeyEvent.VK_LEFT) 
		{  								// left-arrow key; move the square left
			
				
				a = true;
				mtn_at_right = false;
				mtn_at_down = false;
				mtn_at_up = false;
				
				if(mtn_at_left != true)
				{
					if(other_move_right || other_move_up || other_move_down)
					{
						mtn_at_left = false;	
					
					}
				
				}
				
				// Goes through movements only if win is false, lose is false, and mountain is not at left
				while((a == true) && (mtn_at_left == false) && (win == false) && (lose == false)) 
				{ 		
							
							chopper_xpos -= 1; // Decrements the chopper xpos 
							
							// Checks if chopper is out of bounds and stops timer, 
							//sets booleans lose and a to false
						
							if(chopper_xpos < -80)
							{
								a = false;
								lose = true;
								t.stop();
							}
						
						// Checks the array mountain x-positions after every pixel incremented
						for (int w = 0; w < x_arr.length; w++) 
						{	
							
							if(a == true)
							{	
								// If condition to check if chopper intersects a mountain
								if ((chopper_xpos == x_arr[w] + 80) && (chopper_ypos == y_arr[w])) 
								{	
									
									
										a = false;
										mtn_at_left = true; // Sets boolean for mountain at left to false
										other_move_left = true;
									
										chopper_xpos = x_arr[w] + 80;   		
										if(timeup == false) // Repaints it time is still available
										repaint(); 
								}	
								
								// If chopper encounters a dragon
								else if((chopper_xpos == 380) && (chopper_ypos == 480))
								{
									//Asks a question
									char response = JOptionPane.showInputDialog(null,
			    		                "How many ways can three books be arranged on a shelf?",
			    		                "Enter Your Answer",
			    		                JOptionPane.QUESTION_MESSAGE).charAt(0);
									
									// If response is correct than repaint to farther position if time is available
									if(response == '6')
									{
										chopper_xpos = 260;
										chopper_ypos = 480;
										if(timeup == false)
										repaint();
									}
									
									// If response is not correct, asks again until answer is correct
									else
									{
										
										response = JOptionPane.showInputDialog(null,
					    		                "How many ways can three books be arranged on a shelf?",
					    		                "Enter Your Answer",
					    		                JOptionPane.QUESTION_MESSAGE).charAt(0);
										if(response == '6')
										{
											chopper_xpos = 260;
											chopper_ypos = 480;
											if(timeup == false)
											repaint();
										}
									}
								}
								
								// If dragon is not encountered repaints if time is still available
								else 
								{
									if(timeup == false)
									repaint();
									   
								}
							} /// end if
						} /// end for
			
				} /// end while
			
		}/// end left condition
		
		                                                                                                                                                                          
		if (key == KeyEvent.VK_RIGHT) 
		{  									// right-arrow key; move the square right
		
			
			b = true;
			mtn_at_left = false;
			mtn_at_down = false;
			mtn_at_up = false;
			
			if(mtn_at_right != true)
			{
				if(other_move_left || other_move_up || other_move_down)
				{
						mtn_at_right = false;	
				}
				
			}
				
			while((b == true) && (mtn_at_right == false) && (win == false) && (lose == false))
			{ 		
					
						chopper_xpos += 1;
						if(chopper_xpos > 800) 
						{
							b = false;
							lose = true;
							t.stop();
						}
				
					
					for (int x = 0; x < x_arr.length; x++) 
					{	
						
						if(b == true)
						{	
							if ((chopper_xpos + 40 == x_arr[x]) && (chopper_ypos == y_arr[x])) 
							{
								b = false;
								mtn_at_right = true;
								other_move_right = true;
								chopper_xpos = x_arr[x] - 40;   		
								
								if(timeup == false)
								repaint(); 
								
							}
						
							else 
							{
								
								if((chopper_xpos + 40 == base_xpos) && (chopper_ypos  == base_ypos + 40))
								{
									win = true;
									t.stop();
									chopper_xpos = base_xpos - 40;
									chopper_ypos = base_ypos + 40;
								}	
								if(timeup == false)
								repaint();
								   
							}
						} /// end if
					} /// end for
		
			} /// end while
		
				
				
  	 	} /// end right condition
  	 	
  	 	
		
		if (key == KeyEvent.VK_UP)
  	 	{  										// up-arrow key; move the square up
	
			c = true;
			mtn_at_left = false;
			mtn_at_right = false;
			mtn_at_down = false;
			
			if(mtn_at_up != true)
			{
			
				if(other_move_left || other_move_up || other_move_down)
				{
					mtn_at_up = false;	
				}
			}

			
			while((c == true) && (mtn_at_up == false) && (win == false) && (lose == false))
			{ 		
					
				
						chopper_ypos -= 1;
						if(chopper_ypos < -80)
						{
							c = false;
							lose = true;
							t.stop();
						}
					
					for (int y = 0; y < y_arr.length; y++) 
					{	
						
						if(c == true)
						{	
							if ((chopper_xpos == x_arr[y]) && (chopper_ypos == y_arr[y] + 80)) 
							{
								c = false;
								mtn_at_up = true;
								other_move_up = true;
								chopper_ypos = y_arr[y] + 80;   		
								if(timeup == false)
								repaint(); 
								
							}
						
							else
							{
								if(timeup == false)
								repaint();   
							}
						} /// end if
					} /// end for
		
			} /// end while
  	 	} /// end up condition
								
					
  	 	
		if (key == KeyEvent.VK_DOWN)
		{  										// down-arrow key; move the square down
	
			d = true;
			mtn_at_up = false;
			mtn_at_left = false;
			mtn_at_right = false;
			
			if(mtn_at_down != true)
			{
				if(other_move_left || other_move_right || other_move_up)
				{
						mtn_at_down = false;	
				}
			}
			
			while((d == true) && (mtn_at_down == false) && (win == false) && (lose == false))
			{ 		
					
			
				chopper_ypos += 1;
				if(chopper_ypos > 700)
				{
					d = false;
					lose = true;	
					t.stop();
				}
					
				for (int z = 0; z < y_arr.length; z++) 
				{	
						
					if(d == true)
					{	
						if ((chopper_xpos == x_arr[z]) && (chopper_ypos + 40 == y_arr[z] )) 
						{
							d = false;
							mtn_at_down = true;						
							other_move_down = true;
							chopper_ypos = y_arr[z] - 40;   		
							if(timeup == false)
							repaint(); 
						}
						
						else 
						{
							if(timeup == false)
							repaint();
						}
					} /// end if
				} /// end for
		
			}/// end while
		} /// end if
		SaveInfo(); 
	} /// end keypPressed
    	
		
		// Gets the images
		public void GetImage()
    	{
			try
			{ 		   
    		
				background = ImageIO.read(new File("background.png"));
				mtn = ImageIO.read(new File("mountain.png"));
				chopper = ImageIO.read(new File("chopper.png"));
				base = ImageIO.read(new File("base.png"));
				dragon = ImageIO.read(new File("dragon.png"));
    	    	
			}
			catch(IOException e) 
    		{
				System.err.println("Cannot get image");
    		}
    	
    	} /// end GetImage2
		
		// Paints the chopper movement and prints win, lose or time's up statements
		public void paintComponent(Graphics g)
    	{
			
			super.paintComponent(g);		
			Font font2 = new Font("Arial", Font.PLAIN, 150);
			
			if(reset == true)
			{	
				
						g.drawImage(background, 0 ,0, 800, 800, this);
						g.drawImage(chopper, 380,360, 40, 40, this);
						g.drawImage(base, base_xpos, base_ypos, 80, 80, this);
						g.drawImage(dragon, dragon_xpos, dragon_ypos, 80, 80, this);
						for(int i = 0; i < x_arr.length; i++)
						{	
							
							mtn_xpos = x_arr[i];
							mtn_ypos = y_arr[i];
							g.drawImage(mtn, mtn_xpos, mtn_ypos , 80, 80, this);
						}
						
			}
			else if(lose == true)
			{
				g.setColor(Color.red);
				g.setFont(font2);
				
				
				g.drawImage(background, 0 ,0, 800, 800, this);
				g.drawImage(chopper, chopper_xpos ,chopper_ypos, 40, 40, this);
				g.drawImage(dragon, dragon_xpos, dragon_ypos, 80, 80, this);
				g.drawImage(base, base_xpos, base_ypos, 80, 80, this);
				for(int i = 0; i < x_arr.length; i++)
				{
					mtn_xpos = x_arr[i];
					mtn_ypos = y_arr[i];
					g.drawImage(mtn, mtn_xpos, mtn_ypos , 80, 80, this);
				}
				g.drawString("TRY AGAIN", 0, 200);
			} 
			
			else if(win == false)
			{	
				
						g.drawImage(background, 0 ,0, 800, 800, this);
						g.drawImage(chopper, chopper_xpos ,chopper_ypos, 40, 40, this);
						g.drawImage(base, base_xpos, base_ypos, 80, 80, this);
						g.drawImage(dragon, dragon_xpos, dragon_ypos, 80, 80, this);
						for(int i = 0; i < x_arr.length; i++)
						{
							mtn_xpos = x_arr[i];
							mtn_ypos = y_arr[i];
							g.drawImage(mtn, mtn_xpos, mtn_ypos , 80, 80, this);
						}
					
			}
			else if(win == true)
			{
				g.setColor(Color.green);
				g.setFont(font2);
				
				
				g.drawImage(background, 0 ,0, 800, 800, this);
				g.drawImage(chopper, chopper_xpos ,chopper_ypos, 40, 40, this);
				g.drawImage(dragon, dragon_xpos, dragon_ypos, 80, 80, this);
				g.drawImage(base, base_xpos, base_ypos, 80, 80, this);
				for(int i = 0; i < x_arr.length; i++)
				{
					mtn_xpos = x_arr[i];
					mtn_ypos = y_arr[i];
					g.drawImage(mtn, mtn_xpos, mtn_ypos , 80, 80, this);
				}
				g.drawString(name , 150, 200);
				g.drawString("WINS!",150,320);
			} 
			
			if(timeup == true)
			{
				g.setColor(Color.red);
				g.setFont(font2);
				
				
				g.drawImage(background, 0 ,0, 800, 800, this);
				g.drawImage(chopper, chopper_xpos ,chopper_ypos, 40, 40, this);
				g.drawImage(dragon, dragon_xpos, dragon_ypos, 80, 80, this);
				g.drawImage(base, base_xpos, base_ypos, 80, 80, this);
				for(int i = 0; i < x_arr.length; i++)
				{
					mtn_xpos = x_arr[i];
					mtn_ypos = y_arr[i];
					g.drawImage(mtn, mtn_xpos, mtn_ypos , 80, 80, this);
				}
				g.drawString(name , 150, 200);
				g.drawString("Time's Up!",0,320);
			}
			
    	} /// end paintComponent
    	

		public void actionPerformed(ActionEvent av) {}
		public void keyReleased(KeyEvent evt) {}
		public void keyTyped(KeyEvent evt) {}
    	
        
        
	
    
    } /// end class Level1
 
//************************Level2
    class Level2 extends JPanel implements ActionListener, MouseListener, KeyListener
    {	   
    	 
       	Image mtn, chopper, base, background, dragon;
       	private int chopper_xpos;
       	private int chopper_ypos;
       	private int mtn_xpos;
		private int mtn_ypos;
       	private int base_xpos;
       	private int base_ypos;
       	private int dragon_xpos;
       	private int dragon_ypos;
       	private int[] y_arr;
       	private int[] x_arr;
       	boolean a,b,c,d, win, lose, mtn_at_left, mtn_at_right, mtn_at_up, mtn_at_down, other_move_left, other_move_right, other_move_up, other_move_down;
       	private Scanner inFile2;
       	public boolean reset;
       	public boolean timeup;
       	
       	public Level2()
       	{
       		init();    		
    		x_arr = new int[39];
    		y_arr = new int[39]; 
    		
    		
    		GetValues2();
    		GetImage2();
    		
    		tmTxt2.setBounds(700, 5, 50, 20);
    		add(tmTxt2);
    		tmTxt2.setEditable(false);
    	    addKeyListener(this);
    	    
       	}
       	
       	public void init() {
       		timeup = false;
       		reset = false; 
       		mtn_xpos = 0;
       		mtn_ypos = 0;
       		lose = false;
       		win = false;
       		other_move_left = false;
       		other_move_right = false;
       		other_move_up = false;
       		other_move_down = false;
       		mtn_at_left = false;
       		mtn_at_right = false;
       		mtn_at_up = false;
       	 	mtn_at_down = false;
    		chopper_xpos = 275;
    		chopper_ypos = 385;
    		base_xpos = 715;
    		base_ypos = 220;
    		dragon_xpos = 440;
    		dragon_ypos = 210;
       	}
        
       	public void GetValues2()
       	{
       
       	   		String fileName = "Values2.txt";
       	   		int number = 0;
       	   		try 
       	   		{
       				inFile2 = new Scanner(new File(fileName));
       			} catch (FileNotFoundException e) {
       				System.err.printf("ERROR: Cannot open %s\n", fileName);
       				System.exit(1); 
       			}
       			while (inFile2.hasNext()) 
       			{
       				
       				for(int i = 0; i < x_arr.length; i++)
       				{
       					
       					number = inFile2.nextInt();
            		    x_arr[i] = number;
       					
       				}
       				for(int j = 0; j < y_arr.length; j++)
       				{
       					
       					number = inFile2.nextInt();
       					y_arr[j] = number;
       					
       				}
       				
       			}
       			inFile2.close();
       			
       	   	} /// end GetValues
  
       	
    	public void keyPressed(KeyEvent e) 
    	{
    		
    		int key = e.getKeyCode();  		// keyboard code for the pressed key
       		
       		 
    		if (key == KeyEvent.VK_LEFT) 
    		{  								// left-arrow key; move the square left
    			
    				
    				a = true;
    				mtn_at_right = false;
    				mtn_at_down = false;
    				mtn_at_up = false;
    				
    				if(mtn_at_left != true)
    				{
    					if(other_move_right || other_move_up || other_move_down)
    					{
    						mtn_at_left = false;	
    					
    					}
    				
    				}
    				
    				while((a == true) && (mtn_at_left == false) && (win == false) && (lose == false)) 
    				{ 		
    						
    					
    						
    							chopper_xpos -= 1; 
    							if(chopper_xpos < -55)
    							{
    								a = false;
    								lose = true;
    								t.stop();
    							}
    						
    						
    						for (int w = 0; w < x_arr.length; w++) 
    						{	
    							
    							if(a == true)
    							{	
    								if ((chopper_xpos == x_arr[w] + 55) && (chopper_ypos == y_arr[w])) 
    								{	
    									
    									
    										a = false;
    										mtn_at_left = true;
    										other_move_left = true;
    									
    										chopper_xpos = x_arr[w] + 55;   		
    										if(timeup == false)
    										repaint(); 
    								}	
    							
    							
    								
    								else 
    								{
    									if(timeup == false)
    									repaint();
    									   
    								}
    							} /// end if
    						} /// end for
    			
    				} /// end while
    			
    		}/// end left condition
    		
    		                                                                                                                                                                          
    		if (key == KeyEvent.VK_RIGHT) 
    		{  									// right-arrow key; move the square right
    		
    			
    			b = true;
    			mtn_at_left = false;
    			mtn_at_down = false;
    			mtn_at_up = false;
    			
    			if(mtn_at_right != true)
    			{
    				if(other_move_left || other_move_up || other_move_down)
    				{
    						mtn_at_right = false;	
    				}
    				
    			}
    				
    			while((b == true) && (mtn_at_right == false) && (win == false) && (lose == false))
    			{ 		
    					
    				
    					
    						chopper_xpos += 1;
    						if(chopper_xpos > 800) 
    						{
    							b = false;
    							lose = true;
    							t.stop();
    						}
    				
    					
    					for (int x = 0; x < x_arr.length; x++) 
    					{	
    						
    						if(b == true)
    						{	
    							if ((chopper_xpos + 55 == x_arr[x]) && (chopper_ypos == y_arr[x])) 
    							{
    								b = false;
    								mtn_at_right = true;
    								other_move_right = true;
    								chopper_xpos = x_arr[x] - 55;   		
    									
    								if(timeup == false)
    								repaint(); 
    								
    							}
    						
    							else 
    							{
    								
    								if((chopper_xpos + 55 == base_xpos) && (chopper_ypos == base_ypos))
    								{
    									win = true;
    									t.stop();
    									chopper_xpos = base_xpos - 55;
    									chopper_ypos = base_ypos;
    								}	
    								if(timeup == false)
    								repaint();
    								   
    							}
    						} /// end if
    					} /// end for
    		
    			} /// end while
    		
    				
    				
      	 	} /// end right condition
      	 	
      	 	
    		
    		if (key == KeyEvent.VK_UP)
      	 	{  										// up-arrow key; move the square up
    	
    			c = true;
    			mtn_at_left = false;
    			mtn_at_right = false;
    			mtn_at_down = false;
    			
    			if(mtn_at_up != true)
    			{
    			
    				if(other_move_left || other_move_up || other_move_down)
    				{
    					mtn_at_up = false;	
    				}
    			}

    			
    			while((c == true) && (mtn_at_up == false) && (win == false) && (lose == false))
    			{ 		
    					
    				
    						chopper_ypos -= 1;
    						if(chopper_ypos < -55)
    						{
    							c = false;
    							lose = true;
    							t.stop();
    						}
    					
    					for (int y = 0; y < y_arr.length; y++) 
    					{	
    						
    						if(c == true)
    						{	
    							if ((chopper_xpos == x_arr[y]) && (chopper_ypos == y_arr[y] + 55)) 
    							{
    								c = false;
    								mtn_at_up = true;
    								other_move_up = true;
    								chopper_ypos = y_arr[y] + 55;   		
    								if(timeup == false)
    								repaint(); 
    								
    							}
    							
    							else if((chopper_xpos == 440) && (chopper_ypos == 255))
								{
								
									char response = JOptionPane.showInputDialog(null,
			    		                "What is sin 30 + 1/2?",
			    		                "Enter Your Answer",
			    		                JOptionPane.QUESTION_MESSAGE).charAt(0);
									if(response == '1')
									{
										chopper_xpos = 440;
										chopper_ypos = 55;
										if(timeup == false)
										repaint();
									}
									else
									{
										
										response = JOptionPane.showInputDialog(null,
					    		                "What is sin 30 + 1/2?",
					    		                "Enter Your Answer",
					    		                JOptionPane.QUESTION_MESSAGE).charAt(0);
										if(response == '1')
										{
											chopper_xpos = 440;
											chopper_ypos = 55;
											if(timeup == false)
											repaint();
										}
									}
								}
    							
    							else
    							{
    								if(timeup == false)
    								repaint();   
    							}
    						} /// end if
    					} /// end for
    		
    			} /// end while
      	 	} /// end up condition
    								
    					
      	 	
    		if (key == KeyEvent.VK_DOWN)
    		{  										// down-arrow key; move the square down
    	
    			d = true;
    			mtn_at_up = false;
    			mtn_at_left = false;
    			mtn_at_right = false;
    			
    			if(mtn_at_down != true)
    			{
    				if(other_move_left || other_move_right || other_move_up)
    				{
    						mtn_at_down = false;	
    				}
    			}
    			
    			while((d == true) && (mtn_at_down == false) && (win == false) && (lose == false))
    			{ 		
    					
    			
    				
    				chopper_ypos += 1;
    				if(chopper_ypos > 700)
    				{
    					d = false;
    					lose = true;
    					t.stop();
    				}
    					
    					 
    					for (int z = 0; z < y_arr.length; z++) 
    					{	
    						
    						
    						if(d == true)
    						{	
    							if ((chopper_xpos == x_arr[z]) && (chopper_ypos + 55 == y_arr[z] )) 
    							{
    								d = false;
    								mtn_at_down = true;						
    								other_move_down = true;
    								chopper_ypos = y_arr[z] - 55;   		
    								
    								if(timeup == false)
    								repaint(); 
    								
    								
    							}
    						
    							else 
    							{
    								if(timeup == false)
    								repaint();
    									
    							}
    						} /// end if
    					} /// end for
    		
    			}/// end while
    		} /// end if
    		SaveInfo();
    	} /// end keypPressed
        	
    		
    	
    		public void GetImage2()
        	{
    			try
    			{ 		
        		
    				background = ImageIO.read(new File("background.png"));
    				mtn = ImageIO.read(new File("mountain.png"));
    				chopper = ImageIO.read(new File("chopper.png"));
    				base = ImageIO.read(new File("base.png"));
    				dragon = ImageIO.read(new File("dragon.png"));
        	    	
    			}
    			catch(IOException e) 
        		{
    				System.err.println("Cannot get image");
        		}
        	
        	} /// end GetImage2
    		
    		public void paintComponent(Graphics g)
        	{
    			
    			super.paintComponent(g);		
    			Font font2 = new Font("Arial", Font.PLAIN, 150);
    			
    			if(win == false)
    			{	
    				
    				
    						g.drawImage(background, 0 ,0, 800, 800, this);
    						g.drawImage(chopper, chopper_xpos ,chopper_ypos, 55, 55, this);
    						g.drawImage(base, base_xpos, base_ypos, 55, 55, this);
    						g.drawImage(dragon, dragon_xpos, dragon_ypos, 55, 55, this);
    						for(int i = 0; i < x_arr.length; i++)
    						{
    							mtn_xpos = x_arr[i];
    							mtn_ypos = y_arr[i];
    							g.drawImage(mtn, mtn_xpos, mtn_ypos , 55, 55, this);
    						}
    						
    			}
    			if(win == true)
    			{
    				g.setColor(Color.green);
    				g.setFont(font2);
    				
    				
    				g.drawImage(background, 0 ,0, 800, 800, this);
    				g.drawImage(base, base_xpos, base_ypos, 55, 55, this);
    				g.drawImage(chopper, chopper_xpos ,chopper_ypos, 55, 55, this);
    				g.drawImage(dragon, dragon_xpos, dragon_ypos, 55, 55, this);
    				for(int i = 0; i < x_arr.length; i++)
					{
						mtn_xpos = x_arr[i];
						mtn_ypos = y_arr[i];
						g.drawImage(mtn, mtn_xpos, mtn_ypos , 55, 55, this);
					}
    				g.drawString(name , 150, 200);
    				g.drawString("WINS!",150,320);
    			} 
    			
    			if(lose == true)
    			{
    				g.setColor(Color.red);
    				g.setFont(font2);
    				
    				
    				g.drawImage(background, 0 ,0, 800, 800, this);
    				g.drawImage(chopper, chopper_xpos ,chopper_ypos, 55, 55, this);
    				g.drawImage(dragon, dragon_xpos, dragon_ypos, 55, 55, this);
    				g.drawImage(base, base_xpos, base_ypos, 55, 55, this);
    				for(int i = 0; i < x_arr.length; i++)
					{
						mtn_xpos = x_arr[i];
						mtn_ypos = y_arr[i];
						g.drawImage(mtn, mtn_xpos, mtn_ypos , 55, 55, this);
					}
    				g.drawString("TRY AGAIN", 0, 200);
    			}
    			
    			if(timeup == true)
    			{
    				g.setColor(Color.red);
    				g.setFont(font2);
    				
    				
    				g.drawImage(background, 0 ,0, 800, 800, this);
    				g.drawImage(chopper, chopper_xpos ,chopper_ypos, 55, 55, this);
    				g.drawImage(dragon, dragon_xpos, dragon_ypos, 55, 55, this);
    				g.drawImage(base, base_xpos, base_ypos, 55, 55, this);
    				for(int i = 0; i < x_arr.length; i++)
					{
						mtn_xpos = x_arr[i];
						mtn_ypos = y_arr[i];
						g.drawImage(mtn, mtn_xpos, mtn_ypos , 55, 55, this);
					}
    				g.drawString("Time's Up", 0, 320);
    			}
        	} /// end paintComponent
        	

    		
    		public void keyReleased(KeyEvent evt) {}
    		public void keyTyped(KeyEvent evt) {}
        	public void mousePressed(MouseEvent evt){}
            public void mouseEntered(MouseEvent evt) {}
            public void mouseExited(MouseEvent evt) {}
            public void mouseClicked(MouseEvent evt) {}
            public void mouseReleased(MouseEvent evt) {}
            public void actionPerformed(ActionEvent av){}
    	
            
        } /// end class Leve2
     
       	
    

//*************************************Level3    
    class Level3 extends JPanel implements ActionListener, MouseListener, KeyListener
    {	   
    	
     	Image mtn, chopper, base, background, dragon;
       	private int chopper_xpos;
       	private int chopper_ypos;
       	private int mtn_xpos;
		private int mtn_ypos;
       	private int base_xpos;
       	private int base_ypos;
       	private int dragon_xpos;
       	private int dragon_ypos;
       	private int[] y_arr;
       	private int[] x_arr;
       	boolean a,b,c,d, win, lose, mtn_at_left, mtn_at_right, mtn_at_up, mtn_at_down, other_move_left, other_move_right, other_move_up, other_move_down;
       	private Scanner inFile3;
       	public boolean reset;
       	public boolean timeup;
       	
       	public Level3()
       	{
       		init();
    		
    		x_arr = new int[112];
    		y_arr = new int[112]; 
    		
    		
    	
    		GetValues3();
    		GetImage2();

    		tmTxt3.setBounds(700, 5,50, 20);
    		add(tmTxt3);
    		tmTxt3.setEditable(false);
    	    addKeyListener(this);
    	    
       	}

       	public void init() {
       		timeup = false;
       		reset = false;
       		mtn_xpos = 0;
       		mtn_ypos = 0;
       		lose = false;
       		win = false;
       		other_move_left = false;
       		other_move_right = false;
       		other_move_up = false;
       		other_move_down = false;
       		mtn_at_left = false;
       		mtn_at_right = false;
       		mtn_at_up = false;
       	 	mtn_at_down = false;
    		chopper_xpos = 600; 
    		chopper_ypos = 440; 
    		base_xpos = 0;
    		base_ypos = 160;
    		dragon_xpos = 360;
    		dragon_ypos = 160;
       	}
       	public void GetValues3()
       	{
       
       	   		String fileName = "Values3.txt";
       	   		int number = 0;
       	   		try 
       	   		{
       				inFile3 = new Scanner(new File(fileName));
       			} catch (FileNotFoundException e) {
       				System.err.printf("ERROR: Cannot open %s\n", fileName);
       				System.exit(1); 
       			}
       			while (inFile3.hasNext()) 
       			{
       				
       				for(int i = 0; i < x_arr.length; i++)
       				{
       					
       					number = inFile3.nextInt();
            		    x_arr[i] = number;
       					
       				}
       				for(int j = 0; j < y_arr.length; j++)
       				{
       					
       					number = inFile3.nextInt();
       					y_arr[j] = number;
       					
       				}
       				
       			}
       			inFile3.close();
       			
       	   	} /// end GetValues
  
       	
    	public void keyPressed(KeyEvent e) 
    	{
    		
    		int key = e.getKeyCode();  		// keyboard code for the pressed key
       		
       		 
    		if (key == KeyEvent.VK_LEFT) 
    		{  								// left-arrow key; move the square left
    			
    				
    				a = true;
    				mtn_at_right = false;
    				mtn_at_down = false;
    				mtn_at_up = false;
    				
    				if(mtn_at_left != true)
    				{
    					if(other_move_right || other_move_up || other_move_down)
    					{
    						mtn_at_left = false;	
    					
    					}
    				
    				}
    				
    				while((a == true) && (mtn_at_left == false) && (win == false) && (lose == false)) 
    				{ 		
    						
    					
    						
    							chopper_xpos -= 1; 
    							if(chopper_xpos < -40)
    							{
    								a = false;
    								lose = true;
    								t.stop();
    							}
    						
    						
    						for (int w = 0; w < x_arr.length; w++) 
    						{	
    							
    							if(a == true)
    							{	
    								if ((chopper_xpos == x_arr[w] + 40) && (chopper_ypos == y_arr[w])) 
    								{	
    									
    									
    										a = false;
    										mtn_at_left = true;
    										other_move_left = true;
    									
    										chopper_xpos = x_arr[w] + 40;   		
    										if(timeup == false)
    										repaint(); 
    								}	
    							
    							
    								
    								else 
    								{
    									if((chopper_xpos - 40 == base_xpos) && (chopper_ypos == base_ypos))
        								{
        									win = true;
        									t.stop();
        									chopper_xpos = base_xpos + 40;
        									chopper_ypos = base_ypos;
        								}	
    									if(timeup == false)
    									repaint();
    									   
    								}
    							} /// end if
    						} /// end for
    			
    				} /// end while
    			
    		}/// end left condition
    		
    		                                                                                                                                                                          
    		if (key == KeyEvent.VK_RIGHT) 
    		{  									// right-arrow key; move the square right
    		
    			
    			b = true;
    			mtn_at_left = false;
    			mtn_at_down = false;
    			mtn_at_up = false;
    			
    			if(mtn_at_right != true)
    			{
    				if(other_move_left || other_move_up || other_move_down)
    				{
    						mtn_at_right = false;	
    				}
    				
    			}
    				
    			while((b == true) && (mtn_at_right == false) && (win == false) && (lose == false))
    			{ 		
    					
    				
    					
    						chopper_xpos += 1;
    						if(chopper_xpos > 800) 
    						{
    							b = false;
    							lose = true;
    							t.stop();
    						}
    				
    					
    					for (int x = 0; x < x_arr.length; x++) 
    					{	
    						
    						if(b == true)
    						{	
    							if ((chopper_xpos + 40 == x_arr[x]) && (chopper_ypos == y_arr[x])) 
    							{
    								b = false;
    								mtn_at_right = true;
    								other_move_right = true;
    								chopper_xpos = x_arr[x] - 40;   		
    									
    								if(timeup == false)
    								repaint(); 
    								
    							}
    						
    							else 
    							{
    								
    								if(timeup == false)
    								repaint();
    								   
    							}
    						} /// end if
    					} /// end for
    		
    			} /// end while
    		
    				
    				
      	 	} /// end right condition
      	 	
      	 	
    		
    		if (key == KeyEvent.VK_UP)
      	 	{  										// up-arrow key; move the square up
    	
    			c = true;
    			mtn_at_left = false;
    			mtn_at_right = false;
    			mtn_at_down = false;
    			
    			if(mtn_at_up != true)
    			{
    			
    				if(other_move_left || other_move_up || other_move_down)
    				{
    					mtn_at_up = false;	
    				}
    			}

    			
    			while((c == true) && (mtn_at_up == false) && (win == false) && (lose == false))
    			{ 		
    					
    				
    						chopper_ypos -= 1;
    						if(chopper_ypos < -40)
    						{
    							c = false;
    							lose = true;
    							t.stop();
    						}
    					
    					for (int y = 0; y < y_arr.length; y++) 
    					{	
    						
    						if(c == true)
    						{	
    							if ((chopper_xpos == x_arr[y]) && (chopper_ypos == y_arr[y] + 40)) 
    							{
    								c = false;
    								mtn_at_up = true;
    								other_move_up = true;
    								chopper_ypos = y_arr[y] + 40;   		
    								if(timeup == false)
    								repaint(); 
    								
    							}
    							
    							else if((chopper_xpos == 360) && (chopper_ypos == 200))
								{
								
									char response = JOptionPane.showInputDialog(null,
			    		                "What is arcsin(1) - 85?",
			    		                "Enter Your Answer",
			    		                JOptionPane.QUESTION_MESSAGE).charAt(0);
									if(response == '5')
									{
										chopper_xpos = 360;
										chopper_ypos = 40;
										if(timeup == false)
										repaint();
									}
									else
									{
										
										response = JOptionPane.showInputDialog(null,
					    		                "What is arcsin(1) - 85?",
					    		                "Enter Your Answer",
					    		                JOptionPane.QUESTION_MESSAGE).charAt(0);
										if(response == '5')
										{
											chopper_xpos = 360;
											chopper_ypos = 40;
											if(timeup == false)
											repaint();
										}
									}
								}
    							
    							else
    							{
    								if(timeup == false)
    								repaint();   
    							}
    						} /// end if
    					} /// end for
    		
    			} /// end while
      	 	} /// end up condition
    								
    					
      	 	
    		if (key == KeyEvent.VK_DOWN)
    		{  										// down-arrow key; move the square down
    	
    			d = true;
    			mtn_at_up = false;
    			mtn_at_left = false;
    			mtn_at_right = false;
    			
    			if(mtn_at_down != true)
    			{
    				if(other_move_left || other_move_right || other_move_up)
    				{
    						mtn_at_down = false;	
    				}
    			}
    			
    			while((d == true) && (mtn_at_down == false) && (win == false) && (lose == false))
    			{ 		
    					
    				
    				
    				chopper_ypos += 1;
    				if(chopper_ypos > 700)
    				{
    					d = false;
    					lose = true;
    					t.stop();
    				}
    					
    					 
    					for (int z = 0; z < y_arr.length; z++) 
    					{	
    						
    						
    						if(d == true)
    						{	
    							if ((chopper_xpos == x_arr[z]) && (chopper_ypos + 40 == y_arr[z] )) 
    							{
    								d = false;
    								mtn_at_down = true;						
    								other_move_down = true;
    								chopper_ypos = y_arr[z] - 40;   		
    								
    								if(timeup == false)
    								repaint(); 
    								
    								
    							}
    						
    							else 
    							{
    								if(timeup == false)
    								repaint();
    								
    									
    							}
    						} /// end if
    					} /// end for
    		
    			}/// end while
    		} /// end if
    		SaveInfo();
    	} /// end keypPressed
        	

    	
    		public void GetImage2()
        	{
    			try
    			{ 		
        		
    				background = ImageIO.read(new File("background.png"));
    				mtn = ImageIO.read(new File("mountain.png"));
    				chopper = ImageIO.read(new File("chopper.png"));
    				base = ImageIO.read(new File("base.png"));
    				dragon = ImageIO.read(new File("dragon.png"));
        	    	
    			}
    			catch(IOException e) 
        		{
    				System.err.println("Cannot get image");
        		}
        	
        	} /// end GetImage2
    		
    		public void paintComponent(Graphics g)
        	{
    			
    			
    			super.paintComponent(g);		
    			Font font2 = new Font("Arial", Font.PLAIN, 150);
    			
    			if(win == false)
    			{	
    				
    				
    						g.drawImage(background, 0 ,0, 800, 800, this);
    						g.drawImage(chopper, chopper_xpos ,chopper_ypos, 40, 40, this);
    						g.drawImage(base, base_xpos, base_ypos, 40, 40, this);
    						g.drawImage(dragon, dragon_xpos, dragon_ypos, 40, 40, this);
    						for(int i = 0; i < x_arr.length; i++)
    						{
    							mtn_xpos = x_arr[i];
    							mtn_ypos = y_arr[i];
    							g.drawImage(mtn, mtn_xpos, mtn_ypos , 40, 40, this);
    						}
    			}
    			if(win == true)
    			{
    				g.setColor(Color.green);
    				g.setFont(font2);
    				
    				
    				g.drawImage(background, 0 ,0, 800, 800, this);
    				g.drawImage(base, base_xpos, base_ypos, 40, 40, this);
    				g.drawImage(chopper, chopper_xpos ,chopper_ypos, 40, 40, this);
    				g.drawImage(dragon, dragon_xpos, dragon_ypos, 40, 40, this);
    				for(int i = 0; i < x_arr.length; i++)
					{
						mtn_xpos = x_arr[i];
						mtn_ypos = y_arr[i];
						g.drawImage(mtn, mtn_xpos, mtn_ypos , 40, 40, this);
					}
    				g.drawString(name , 150, 200);
    				g.drawString("WINS!",150,320);
    			} 
    			
    			if(lose == true)
    			{
    				g.setColor(Color.red);
    				g.setFont(font2);
    				
    				
    				g.drawImage(background, 0 ,0, 800, 800, this);
    				g.drawImage(chopper, chopper_xpos ,chopper_ypos, 40, 40, this);
    				g.drawImage(dragon, dragon_xpos, dragon_ypos, 40, 40, this);
    				g.drawImage(base, base_xpos, base_ypos, 40, 40, this);
    				for(int i = 0; i < x_arr.length; i++)
					{
						mtn_xpos = x_arr[i];
						mtn_ypos = y_arr[i];
						g.drawImage(mtn, mtn_xpos, mtn_ypos , 40, 40, this);
					}
    				g.drawString("TRY AGAIN", 0, 200);
    			}
    			
    			if(timeup == true)
    			{
    				g.setColor(Color.red);
    				g.setFont(font2);
    				
    				
    				g.drawImage(background, 0 ,0, 800, 800, this);
    				g.drawImage(chopper, chopper_xpos ,chopper_ypos, 55, 55, this);
    				g.drawImage(dragon, dragon_xpos, dragon_ypos, 55, 55, this);
    				g.drawImage(base, base_xpos, base_ypos, 55, 55, this);
    				for(int i = 0; i < x_arr.length; i++)
					{
						mtn_xpos = x_arr[i];
						mtn_ypos = y_arr[i];
						g.drawImage(mtn, mtn_xpos, mtn_ypos , 55, 55, this);
					}
    				g.drawString("Time's Up", 0, 320);
    			}
    			
        	} /// end paintComponent
    	
    	public void keyReleased(KeyEvent evt) {}
    	public void keyTyped(KeyEvent evt) {}
    	public void mousePressed(MouseEvent evt){}
        public void mouseEntered(MouseEvent evt) {}
        public void mouseExited(MouseEvent evt) {}
        public void mouseClicked(MouseEvent evt) {}
        public void mouseReleased(MouseEvent evt) {}        
        public void actionPerformed(ActionEvent av){}        
    
    } /// end class Level3
   } // end mainPanel
} /// end class Game