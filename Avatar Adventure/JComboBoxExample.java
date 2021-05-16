// JComboBoxExample.java
// This program provides an example of the JLabel, JTextField and JComboBox components.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBoxExample {
	JFrame frame;
	///////////////////////////////////////////////////////
	// Declare JTextField and JComboBox identifiers
	JTextField textField1;
	JComboBox comboBox1;	
	
	public static void main(String[] args) {
		JComboBoxExample ce = new JComboBoxExample();
		ce.Run();
	}
	
	public void Run() {
		// Create a frame to hold everything
		frame = new JFrame ("Component Example");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.gray);
		frame.setLayout(new GridLayout(4,1));
						
		///////////////////////////////////////////////////////
		// Declare and initialize JLabel, then add to JFrame
		JLabel jl1 = new JLabel("JComboBox");
		jl1.setFont(new Font("Serif", Font.BOLD, 20));
		frame.add(jl1); 
		
		/////////////////////////////////////////////////////////////////////
		// Initialize JComboBox, add items, add listener, then add to JFrame
		comboBox1 = new JComboBox();
		comboBox1.addItem("Red");
		comboBox1.addItem("Blue");
		comboBox1.addItem("Green");
		comboBox1.addItem("Yellow");
		comboBox1.addItem("Orange");
		comboBox1.addItem("Black");	
		ComboBoxListener cblistener = new ComboBoxListener();
		comboBox1.addActionListener(cblistener);	
		frame.add(comboBox1);
		
		//////////////////////////////////////////////////////////////
		// Declare and initialize a second JLabel, then add to JFrame
		JLabel jl2 = new JLabel("Text Input");
		jl2.setFont(new Font("Serif", Font.BOLD, 20));
		frame.add(jl2);

		/////////////////////////////////////////////////////////////////////
		// Initialize JTextField, set editable to false, then add to JFrame
		textField1 = new JTextField("I'm a JTextField");
		frame.add(textField1);
		frame.setVisible(true);
	}
	
	////////////////////////////////////////////////////////////////////
	// Create a combo box listener class that implements ActionListener
	class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int cmd = comboBox1.getSelectedIndex();
			switch (cmd) {
				case 0: textField1.setForeground(Color.red); break;
				case 1: textField1.setForeground(Color.blue); break;
				case 2: textField1.setForeground(Color.green); break;
				case 3: textField1.setForeground(Color.yellow); break;
				case 4: textField1.setForeground(Color.orange); break;
				case 5: textField1.setForeground(Color.black); break;
		}
		
	}
	}
}	// end class ComponentExample



