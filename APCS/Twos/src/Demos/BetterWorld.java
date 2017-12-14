package Demos;

import javax.swing.*;

public class BetterWorld extends JFrame
{
	public static void main(String[] args)
	{
		BetterWorld bw = new BetterWorld();
		bw.display();
	}
	
	public BetterWorld()
	{
		setTitle("The World");
		setSize(300, 300);
		JLabel label = new JLabel("A better world", SwingConstants.CENTER);
		add(label);
	}
	
	public void display()
	{
		setVisible(true);
	}
}
