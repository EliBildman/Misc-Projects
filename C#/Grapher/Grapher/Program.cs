using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grapher {
    class Graph {
        string equation;
        Point[,] points;
        int Xmin;
        int Xmax;
        int Ymin;
        int Ymax;
        int size;

        public Graph(int maxX, int minX, int maxY, int minY, int size, string eq) {
            points = new Point[size, size];
            for(int x = 0; x < size; x++) {
                for(int y = 0; y < size; y++) {
                    points[x, y] = new Point();
                }
            }
            Xmax = maxX;
            Xmin = minX;
            Ymin = minY;
            Ymax = maxY;
            this.size = size;
            equation = eq;
        }

        void DrawLine() {
            for (int i = 0; i < (size + 1 + "").Length; i++) Console.Write(" ");
            for(int i = 0; i < size + 1; i++) {
                Console.Write("- ");
            }
            Console.WriteLine();
        }

        public void Draw() {
            DrawLine();
            for(int y = size - 1; y >= 0; y--) {
                for(int i = 0; i < (size + 1 + "").Length - (y + 1 + "").Length; i++) {
                    Console.Write(" ");
                }
                Console.Write(y + 1 + "|");
                for(int x = 0; x < size - 1; x++) {
                    Console.Write(points[x, y] + " ");
                }
                Console.WriteLine(points[size - 1, y] + "|");
            }
            DrawLine();
        }

        public static void Main(string[] arg) {
            Graph g = new Graph(0, 10, 0, 10, 10, "x");
            g.Draw();
            Console.Read();
        }
        
    }

    struct Point {

        public float x;
        public float y;
        public bool onLine;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
            onLine = false;
        }

        void setLine() {
            onLine = true;
        }

        public override string ToString() {
            return onLine ? "x" : "o";

        }
    }
    
}
