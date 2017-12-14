using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2 {

    class Game {
        static Board board;
        static string winX = "";
        static string winO = "";

        static void InitBoard() {
            int w = 0;
            while (w <= 0) {
                Console.Write("Board Size: ");
                Int32.TryParse(Console.ReadLine(), out w);
            }
            board = new Board(w);
            for (int i = 0; i < board.Wid; i++) {
                winX += "X";
                winO += "O";
            }
        }

        static void Turn(char player) {
            Console.WriteLine(player + " turn!!");
            int x = 0;
            int y = 0;
            while (x <= 0 || x > board.Wid || y <= 0 || y > board.Wid || board.get(x-1,y-1) != ' ') {
                Console.Write("Location(x,y): ");
                string inp = Console.ReadLine();
                x = Int32.Parse(inp.Substring(0, inp.IndexOf(',')));
                y = Int32.Parse(inp.Substring(inp.IndexOf(',') + 1));
            }
            board.set(x-1, y-1, player);
        }

        //true if game won player is set to winning player, otherwise false and player is unassigned
        static bool GameWon(ref char player) {
            for(int i = 0;i < board.Wid; i++) {
                if(CheckHor(i, ref player) || CheckVer(i, ref player)) {
                    return true;
                }
            }
            if (CheckDia(ref player)) {
                return true;
            }
            return false;
        }

        static bool CheckVer(int x, ref char player) {
            string line = "";
            for (int i = 0; i < board.Wid; i++) {
                line += board.get(x, i);
            }
            if (line.Equals(winX)) {
                player = 'X';
                return true;
            } else if (line.Equals(winO)) {
                player = 'O';
                return true;
            }
            return false;
        }

        static bool CheckHor(int y, ref char player) {
            string line = "";
            for (int i = 0; i < board.Wid; i++) {
                line += board.get(i, y);
            }
            if (line.Equals(winX)) {
                player = 'X';
                return true;
            } else if (line.Equals(winO)) {
                player = 'O';
                return true;
            }
            return false;
        }

        static bool CheckDia(ref char player) {
            string line = "";
            string line2 = "";
            for(int i = 0; i < board.Wid; i++) {
                line += board.get(i, i);
                line2 += board.get(i, board.Wid - 1 - i);
            }
            if(line.Equals(winX) || line2.Equals(winX)) {
                player = 'X';
                return true;
            } else if(line.Equals(winO) || line2.Equals(winO)) {
                player = 'O';
                return true;
            }
            return false;
        }

        static bool Cats() {
            for(int x = 0; x < board.Wid; x++) {
                for (int y = 0; y < board.Wid; y++) {
                    if (board.get(x, y) == ' ') return false;
                }
            }
            return true;
        }

        public static void Main(string[] argzz) {
            int heheimgoodatcode = 0;
            InitBoard();
            char winner = ' ';
            while(!(Cats() || GameWon(ref winner))) {
                board.Draw();
                Turn(heheimgoodatcode % 2 == 0 ? 'X' : 'O');
                heheimgoodatcode++;
            }
            board.Draw();
            if(GameWon(ref winner)) {
                Console.WriteLine(winner + " wins!!!");
            } else {
                Console.WriteLine("Cats Game!");
            }
            Console.Read();
        }
    }

    class Board {

        public int Wid;
        private Cell[,] cells;

        public Board(int w) {
            cells = new Cell[w, w];
            Wid = w;
            for (int x = 0; x < Wid; x++) {
                for (int y = 0; y < Wid; y++) {
                    cells[y, x].c = ' ';
                }
            }
        }

        public char get(int x, int y) {
            if (x < 0 || x >= Wid || y < 0 || y >= Wid) return ' ';
            return cells[y, x].c;
        }

        public void set(int x, int y, char thing) {
            cells[y, x].c = thing;
        }

        public void Draw() {
            endLine();
            for(int y = 0; y < Wid - 1; y++) {
                ContentLine(y);
                DevLine();
            }
            ContentLine(Wid - 1);
            endLine();
        }

        private void DevLine() {
            Console.Write("-");
            for (int i = 0; i < Wid - 1; i++) {
                Console.Write("---+");
            }
            Console.WriteLine("----");
        }

        private void ContentLine(int y) {
            Console.Write("|");
            for (int i = 0; i < Wid; i++) {
                Content(i, y);
                Console.Write("|");
            }
            Console.WriteLine();
        }

        private void Content(int x, int y) {
            Console.Write(" " + cells[y, x].c + " ");
        }

        private void endLine() {
            for (int i = 0; i < 4 * Wid + 1; i++) { 
            Console.Write("-");
            }
            Console.WriteLine();
        }

    }

    struct Cell {
        public char c;
        public Cell(char c) {
            this.c = c;
        }
    }
}
