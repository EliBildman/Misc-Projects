using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace EquationSolver {
    class Program {
        static void Main(string[] args) {
            Regex reg = new Regex("\\d+( *(\\+|\\-|\\*|\\/) *\\d+)+");
            Console.WriteLine(reg.Match("5 + 3 / 2 + 7").Success);
            Console.Read();
        }

        string TakeInput(string input) {
            Regex reg = new Regex("/\\d+( *(\\+|\\-|\\*|\\/) *\\d+)+/g");
            return null;
        }
    }
}
