package Demos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActiveButton extends JFrame implements ActionListener
{
	private JLabel message;
	
	public static void main(String[] args)
	{
		ActiveButton ab = new ActiveButton();
		ab.display();
	}
	
	public ActiveButton()
	{
		setLayout(new BorderLayout());
		
		message = new JLabel("No button has been pushed", SwingConstants.CENTER);
		add(message, BorderLayout.CENTER);
		
		JPanel bottom = new JPanel();
		
		JButton b1 = new JButton("Button 1");
		b1.addActionListener(this);
		bottom.add(b1);
		
		JButton b2 = new JButton("Button 2");
		b2.addActionListener(this);
		bottom.add(b2);
		
		add(bottom, BorderLayout.SOUTH);
		
		setTitle("ActiveButton");
		setSize(400, 200);
	}
	
	public void display()
	{
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Button 1"))
			message.setText("You pushed Button 1");
		else if (e.getActionCommand().equals("Button 2"))
			message.setText("You pushed Button 2");
		else
			message.setText("I don't know what you did!");
	}
}
