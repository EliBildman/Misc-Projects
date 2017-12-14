using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4Conlin {
    class Eli {
        public static void Main(string[] a) {
            string name = "Eli Benjamin Conlin Eli Benjamin Conlin Eli Benjamin Conlin Eli Benjamin Conlin Eli Benjamin Conlin Eli Benjamin Conlin ";
            Random r = new Random();
            int hmm = 0;
            while (true) {
                for(int i  = 0; i < name.Length; i++) {
                    if (hmm % 2 == 0) {
                        Console.WriteLine(name.Substring(0, i));
                    } else {
                        Console.WriteLine(name.Substring(0, name.Length - i));
                    }
                }
                hmm++;
            }
        }
    }
}
