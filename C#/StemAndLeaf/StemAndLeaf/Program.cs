using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StemAndLeaf {
    class Stem {

        List<Line> lines = new List<Line>();

        public Stem(int[] values) {
            foreach(int value in values) {
                Line l = getLine(value / 10);
                if (l == null) Insert(new Line(value / 10));
                getLine(value / 10).Add(value);
            }
        }

        void Insert(Line l) {
            for(int i = 0; i < lines.Count; i++) {
                if (lines[i].header > l.header) {
                    lines.Insert(i, l);
                    return;
                }
            }
            lines.Add(l);
        }

        Line getLine(int h) {
            foreach (Line l in lines) {
                if (l.header == h) return l;
            }
            return null;
        }

        public override string ToString() {
            int biggest = (maxHead() + "").Length;
            foreach (Line l in lines) {
                Console.Write(l.header);
                for(int i = 0; i < 1 + (biggest - (l.header + "").Length); i++) {
                    Console.Write(" ");
                }
                Console.WriteLine("| " + l);
            }
            return null;
        }

        int maxHead() {
            int max = int.MinValue;
            foreach(Line l in lines) {
                if (l.header > max) {
                    max = l.header;
                }
            }
            return max;
        }


        
        public static void Main(string[] ar) {
            Random r = new Random();
            int[] hmm = new int[200];
            for(int i = 0; i < hmm.Length; i++) {
                hmm[i] = r.Next(250);
            }
            Stem s = new Stem(hmm);
            Console.WriteLine(s);
            Console.Read();
        }
    }

    class Line {
        public int header;

        List<int> nums = new List<int>();
   
        public Line(int head) {
            header = head;
        }

        public void Add(int num) {
            nums.Add(num);
        }

        override public string ToString() {
            nums.Sort();
            string lis = "";
            foreach (int num in nums) lis += (num % 10) + " ";
            return lis;
        }
    }
}
