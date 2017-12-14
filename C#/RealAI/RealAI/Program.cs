using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RealAI {

    public class AI {
        string code;
        int size;

        public AI(string code) {
            this.code = code;
            size = code.Length;
        }

         

        public string runTheNumbers() {
            Random r = new Random();
            String guess = "";
            String lastGuess;
            for (int i = 0; i < code.Length; i++) guess += "x";
            while (getScore(guess) != 1.0) {
                Console.WriteLine(guess);
                int ind = r.Next(size);
                char c = (char)(r.Next(128));
                lastGuess = guess;
                guess = replace(guess, ind, c + "");
                if (getScore(guess) < getScore(lastGuess)) {
                    guess = lastGuess;
                }
            }
            return guess;
        }

        private static String replace(String input, int index, string c) {
            return input.Substring(0, index) + c + input.Substring(index + c.Length);
        }

        public double getScore(String input) {
            int counter = 0;
            for (int i = 0; i < size; i++) {
                if (code[i] == input[i]) counter++;
            }
            return (double)counter / size;
        }

        public static void Main(String[] args) {
            AI net = new AI("hmm");
            Console.WriteLine(net.runTheNumbers());

            Console.Read();
        }
    }

}
