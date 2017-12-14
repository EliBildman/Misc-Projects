import random
import sys
from math import sin, cos, pi

class Cell(object):

    def __init__(self, x, y):
        self.visited = False
        self.x = x
        self.y = y
        self.conns = {}
        self.find_conns()
        self.back = None

    def __str__(self):
        return str(self.x) + " " + str(self.y)

    def connect(self, cell):
        self.conns[cell] = False
        cell.conns[self] = False

    def find_conns(self):
        for i in range(4):
            x = int(self.x + cos(pi/2 * i))
            y = int(self.y + sin(pi/2 * i))
            if 0 <= y < len(cells) and 0 <= x < len(cells[y]):
                self.connect(cells[y][x])



def init_cells(width, height):
    for y in range(height * 2 + 1):
        cells.append([])
        for x in range(width * 2 + 1):
            cells[y].append(Cell(x, y))

def print_maze(maze):
    for y in range(len(maze) * 2 + 1):
        for x in range(len(maze[0]) * 2 + 1):
            if y == 0 or y == len(maze) * 2 or x == 0 or x == len(maze[0]):
                write("x ")
            elif y % 2 != 0 and x % 2 != 0:
                write("x ")
            elif y % 2 != 0 or x % 2 != 0:
                if maze[y/2][x/2].conns[maze[(y+1)/2][(x+1)/2]]:
                    write("  ")
                else:
                    write("x ")
            else:
                write("  ")
        print

def no_shot(cell):
    for x in cell.conns:
        if not x.visited:
            return False
    return True

def generate(cell):
    curr = cell
    curr = cell.conns[random.randint(0, len(cell.conns) - 1)]
    curr.back = cell
    while curr != cell:
        curr.visited = True
        if no_shot(curr):
            curr = curr.back
        else:
            new = curr.conns[random.randint(0, len(cell.conns) - 1)]
            new.back = curr
            curr = new

write = sys.stdout.write
cells = []
init_cells(5, 5)
print cells[0][0]
print_maze(cells)
