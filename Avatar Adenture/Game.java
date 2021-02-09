 /// Sai Harsha Malirddy
 /// Game.java
 /// This is a game.
 
import java.awt.*;        
import java.awt.event.*;
import javax.swing.*; 

 
 public class Game extends JPanel implements KeyListener 
 {
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	
	
	public static void main(String [] args)
	{
		Game game = new Game();
		game.Run();
		
	}
	
	public Game()
	{
		
	}
	
	public void Run()
	{
		frame.setSize(500,500);
		frame.getContentPane().add(panel1, BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel1);
		frame.setVisible(true);	
		
		
	} // end Run
	
	public void paintComponent(Graphics g)
	{
		panel1.setBackground(Color.blue);
		
	}


} /// end class Game