import java.io.IOException;

public class RunSolver
{
	public static void main(String[] args) throws IOException {
		MazeSolver solver = new MazeSolver("C:\\Users\\eli\\Desktop\\maze.png");
		//System.out.println(solver.getStart());
		solver.solve();
	}
}
