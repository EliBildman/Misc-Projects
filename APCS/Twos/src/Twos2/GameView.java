package Twos2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/**********************************************************
 * Assignment: Twos
 *
 * Author: Eli Bildman
 *
 * Description: makes a 2048 game with a GUI
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from lucas g in designing and debugging
 * my program.
 **********************************************************/

public class GameView extends JFrame implements IChangeListener
{
	private JLabel status;
	private JLabel score;
	private GameState grid;
	private JLabel[] tiles;
	
	public GameView(GameState g)
	{
		status = new JLabel();
		score = new JLabel();
		tiles = new JLabel[16];
		Font font = new Font("Comic Sans MS", Font.BOLD, 40);
		for(int i = 0; i < tiles.length; i ++) {
			tiles[i] = new JLabel("", SwingConstants.CENTER);
			tiles[i].setFont(font);
			tiles[i].setForeground(Color.lightGray);
			tiles[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
			tiles[i].setBackground(Color.darkGray);
			tiles[i].setOpaque(true);
		}
		
		// set the value for the instance variable grid
		grid = g;
		// this next line registers the GameView with the GameState
		grid.addListener(this);
		ActionHandler handler = new ActionHandler(grid);
		setTitle("2048 b!");
		setSize(800, 800);
		setLayout(new BorderLayout());

		add(buildTopPanel(handler), BorderLayout.NORTH);
		add(buildCenterPanel(handler), BorderLayout.CENTER);
		add(buildBottomPanel(), BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void colorRed() {
		for(int i = 0; i < tiles.length; i++) {
			tiles[i].setBackground(Color.red);
		}
	}
	
	public void colorBlack() {
		for(int i = 0; i < tiles.length; i ++) {
			tiles[i].setBackground(Color.darkGray);
		}
	}
	
	public void display()
	{
		setVisible(true);
	}
	
	public void highlightTile(int pos[]) {
		for(int i = 0; i < pos.length; i ++)
			if(grid.gameActive && pos[i] <= 16) {
				Color color = new Color(80, 80, 80);
				tiles[pos[i]].setBackground(color);
			}
	}
	
	
	
	@Override
	public void redraw()
	{
		// set the text of these labels: status, score, all the tiles
		status.setText(grid.getStatus());
		score.setText("Score: " + grid.getScore() + "     ");
		int n = 0;
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++) {
				tiles[n].setText(grid.getValue(j, 3 - i) == 0 ? "" : grid.getValue(j, 3 - i) + "");
				n++;
			}
		}
		
		if(!grid.gameActive) colorRed();
		else colorBlack();
		highlightTile(grid.newTile);
	}

	private JPanel buildBottomPanel() 
	{
		// create a JPanel and use the instance variable status to add a label
		// to the bottom panel
		JPanel pan = new JPanel();
		pan.add(status);
		return pan; 
	}

	private JPanel buildTopPanel(ActionHandler handler) 
	{
	
		JPanel pan = new JPanel(new BorderLayout());
		JButton button = new JButton();
		button.setText("New Game");
		pan.add(button, BorderLayout.WEST);
		pan.add(score, BorderLayout.EAST);
		// create JPanel and add a JButton to it for "New game"
		// also use the instance variable score to add a label
		// the next line registers the button if it were called "button"  
		button.addActionListener(handler);
		return pan;
	}
	
	private JPanel buildCenterPanel(ActionHandler handler)
	{
		// create a JPanel with a GridLayout
		JPanel pan = new JPanel(new GridLayout(4, 4));
		for(int i = 0; i < tiles.length; i ++) {
			pan.add(tiles[i]);
		}
		// use the instance variable tiles to fill the grid with labels
		// the next line sets up the arrow keys using the method we gave you
		bindArrows(handler, pan);
		return pan;
	}

	// might need to give the students this method instead of making them 
	// learn about key bindings and anonymous inner classes
	private void bindArrows(ActionHandler handler, JPanel panel) 
	{
		String[] commands = {"left arrow", "up arrow", "right arrow", "down arrow"};
		for (int i = 0; i < 4; i++)
		{
			int copy = i;
			KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT + i, 0);
			Action action = new AbstractAction()
			{
				public void actionPerformed(ActionEvent e)
				{
					handler.handleArrowPress(GameState.LEFT + copy + (copy != 3 ? 1 : -3));
				}
			};
			panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(key, commands[i]);
			panel.getActionMap().put(commands[i], action);
		}
	}
}