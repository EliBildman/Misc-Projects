package Demos;

import java.awt.*;
import javax.swing.*;

public class ButtonGrid extends JFrame
{
	public static void main(String[] args)
	{
		ButtonGrid bg = new ButtonGrid();
		bg.display();
	}
	
	public ButtonGrid()
	{
		// put components in a resizable 2x2 grid
		setLayout(new GridLayout(2, 2));
		
		// add 4 buttons (each will go to one spot in the grid, in
		// row-major order
		for (int i = 1; i <= 4; i++)
		{
			add(new JButton("Button " + i));
		}
		
		setSize(300, 300);
		setTitle("Button Grid");
	}
	
	public void display()
	{
		setVisible(true);
	}
}
