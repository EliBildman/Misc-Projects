package APCS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EightBall extends JFrame implements ActionListener
{
	JButton butt = new JButton("Eight Ball");
	
	public EightBall() {
		
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		butt.addActionListener(this);
		panel.add(butt);
		butt.setPreferredSize(new Dimension(200, 200));
		
		add(panel, BorderLayout.CENTER);
		
		setTitle("EightBall");
		setSize(300, 300);
		
	}
	
	public void display() {
		setVisible(true);
	}
	
	private String getAnswer() {
		String[] answers = {"Is Certain", "Am Tired", "Be Back in 15 mins", "Yes?", "Is Sure", "n0", "yamo kablamo", "totally", "absolutely not"};
		return answers[(int) (Math.random() * answers.length)];
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		butt.setText(getAnswer());
	}
	
	public static void main(String[] args) {
		EightBall ball = new EightBall();
		ball.display();
	}
}
