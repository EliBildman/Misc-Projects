using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace MazeSolverTry2 {
    class Program {


        static void Main(string[] args) {
            Solver yam = new Solver("C:\\Users\\eli\\OneDrive\\Desktop\\maze.png");
            Console.WriteLine(yam.isWall(0, 0));
            Console.Read();
        }

        

    }
    
    class Solver {

        Bitmap map;
        public Solver(string FileName) {
            map = new Bitmap(FileName);
        }

        public bool isWall(int x, int y) {
            Color pix = map.GetPixel(x, y);
            return pix.R + pix.G + pix.B < 5;
        }
    }

}
