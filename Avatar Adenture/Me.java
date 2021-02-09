// Sai Harsha Malireddy
// Me.java
// To use and manipulate images in your programs.

import java.awt.*;
import java.event.*;
import java.swing.*;
import java.io.*;
import java.imageio.*;

public class Me
{
	public static void main(String [] args)
	{
		Me me = new Me();
		me.Run();	
		
	}

	public void Run()  
	{
		
		// Get the Image from a file
		GetMyImage();

		// Create the JFrame and add the JPanel
		frame = new JFrame("Me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(image);
		frame.addKeyListener(image);
		frame.setBackground(Color.gray);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
} // end class Me


	
	
	
	
	
	
	