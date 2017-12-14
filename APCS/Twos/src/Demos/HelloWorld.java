package Demos;

// for JFrame
import javax.swing.*;

// extend JFrame to get a window to pop up
public class HelloWorld extends JFrame
{
	public static void main(String[] args)
	{
		HelloWorld h = new HelloWorld();
	}
	
	public HelloWorld()
	{
		setTitle("Hello, World!");
		setVisible(true);
	}
}
