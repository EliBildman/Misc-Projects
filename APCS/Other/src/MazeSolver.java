import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MazeSolver {
	
	BufferedImage pic;
	BufferedImage solved;
	Pixel[][] pixs;
	Pixel current;
	int dir; //0: N, 1: E, 2: S, 3: W
	
	public MazeSolver(String fileName) throws IOException {
		File f = new File(fileName);
		pic = ImageIO.read(f);
		pixs = new Pixel[pic.getWidth()][pic.getHeight()];
		initializeMap();
		solved = new BufferedImage(pic.getWidth(), pic.getHeight(), BufferedImage.TYPE_INT_RGB);
	}
	
	public void solve() throws IOException {
		current = getStart();
		moveOne();
		while(!isExit(current.x, current.y)) {
			System.out.println(current.x + ", " + current.y);
			current.traveled = true;
			if(isWall(current.x, current.y)) {
				if(forwardIsWall(turn(3))) {
					moveOne();
				} else if(forwardIsWall(dir)) {
					dir = turn(3);
					moveOne();
				} else if(forwardIsWall(turn(1))) {
					dir = turn(1);
					moveOne();
				} else {
					dir = turn(2);
					moveOne(); 
				}
			}
		}
		for(int x = 0; x < pixs.length; x++) {
			for(int y = 0; y < pixs[0].length; y++) {
				if(pixs[x][y].traveled) {
					solved.setRGB(x, y, 255);
				} else if(pixs[x][y].isWall) {
					solved.setRGB(x, y, 0);
				}
			}
		}
		File out = new File("C:\\Users\\eli\\Desktop\\solved.png");
		ImageIO.write(solved, "png", out);
	}
	
	private int turn(int amount) {
		if(dir + amount > 3) {
			return dir + amount;
		}
		return dir + amount - 4;
	}
	
	private boolean forwardIsWall(int dir) {
		if(dir == 0) return pixs[current.x][current.y - 1].isWall;
		else if(dir == 1) return pixs[current.x + 1][current.y].isWall;
		else if(dir == 2) return pixs[current.x][current.y + 1].isWall;
		else return pixs[current.x - 1][current.y].isWall;
	}
	
	private void initializeMap() {
		for(int x = 0; x < pic.getWidth(); x++) {
			for(int y = 0; y < pic.getHeight(); y++) {
				pixs[x][y] = new Pixel(x, y, isWall(x, y));
			}
		}
	}
	
	private boolean isExit(int x, int y) {
		return (x == 0 || x == pic.getWidth() - 1 || y == 0 || y == pic.getHeight() - 1) && !isWall(x, y);
	}
	
	private boolean isWall(int x, int y) {
		return Color.black.getRGB() == pic.getRGB(x, y);
	}
	
	private void moveOne() {
		if(dir == 0) current = pixs[current.x][current.y - 1];
		else if(dir == 1) current = pixs[current.x + 1][current.y];
		else if(dir == 2) current = pixs[current.x][current.y + 1];
		else current = pixs[current.x - 1][current.y];
	}

	public Pixel getStart() {
		for(Pixel[] x : pixs) {
			for(Pixel y : x) {
				if(isExit(y.x, y.y)) {
					if(y.x == 0) dir = 1;
					else if(y.x == pic.getWidth() - 1) dir = 3;
					else if(y.y == 0) dir = 2;
					else dir = 0;
					return y;
				}
			}
		}
		return null;
	}
	
}


