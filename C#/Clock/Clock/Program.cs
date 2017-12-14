using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clock {
    class Program {
        static void Main(string[] args) {
            Clock c = new Clock();
            Console.Read();
        }
    }

    class Clock {

        string[] face;
        int hour;
        int minute;
        int[,,] lines;

        public Clock() {
            ResetFace();
            hour = 1;
            SetLines();
            DrawTime();
            PrintClock();
        }

        void SetTime() {
            hour = DateTime.Now.Hour;
            minute = DateTime.Now.Minute;
            if(hour > 12) hour -= 12;
            
        }

        void SetFace() {

        }

        void ResetFace() {
            face = new string[] { "           12          ",
                                  "                       ",
                                  "      11         1     ",
                                  "                       ",
                                  "  10                2  ",
                                  "                       ",
                                  "9          .          3",
                                  "               .       ",
                                  "  8                 4  ",
                                  "                       ",
                                  "      7          5     ",
                                  "                       ",
                                  "           6           " };

        }

        void SetLines() {
            lines = new int[,,] { { { 5, 13 }, { 4, 14 }, { 3, 16 } },
                { { 5, 15 }, { 4, 18 }, {6, 12 } },
                { { 6, 14}, { 6, 17 }, {6, 20} } };
        }

        void DrawTime() {
            for(int i = 0; i < 3; i ++) {
                SetPoint(lines[hour - 1, i, 0], lines[hour - 1, i, 1]);
            }
        }

        void SetPoint(int y, int x) {
            face[y] = face[y].Substring(0, x) + '.' + (x < face[y].Length - 1 ? face[y].Substring(x + 1) : "");
        }

        public void PrintClock() {
            foreach(var row in face) {
                foreach(char c in row) {
                    Console.Write(c);
                }
                Console.WriteLine();
            }
        }
    }

}
