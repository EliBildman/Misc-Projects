#Takes a maze as an image where black pixels are walls and white pixels are path. There should be a solid wall of black pixels around the border of the maze execpting two white spots which are the start and end
#sorry to anyone trying to interpret this code

import math, sys
from PIL import Image

class Node(object):

    def __str__(self):
        return "Node " + str(self.num) + " (" + str(self.x) + ", " + str(self.y) + ")"

    def find_pals(self):
        for i in range(4):
            x = self.x + int(math.cos(math.pi/2 * i))
            y = self.y + int(math.sin(math.pi/2 * i))
            while 0 <= y < len(maze) and 0 <= x < len(maze[y]) and maze[y][x] != 'x' and not is_node(x, y):
                x += int(math.cos(math.pi/2 * i))
                y += int(math.sin(math.pi/2 * i))
            if is_node(x, y):
                self.add_pal(get_node(x, y))
                get_node(x, y).add_pal(self)

    def add_pal(self, node):
        if node not in self.pals:
            self.pals.append(node)

    def __init__(self, x, y):
        self.pals = []
        self.x = x
        self.y = y
        self.num = len(nodes)
        self.c = ' '

#-----------------------------------------------------------------------------------------------#

def open_sides(x, y):
    sides = []
    for i in range(4):
        if maze[y + int(math.sin(math.pi/2 * i))][x + int(math.cos(math.pi/2 * i))] != 'x':
            sides.append(i)
    return sides


def find_nodes():
    for y in range(1, len(maze) - 1):
        print float(y) / len(maze) * 100
        for x in range(1, len(maze[y]) - 1):
            opsides = open_sides(x, y)
            if maze[y][x] != 'x' and not is_node(x, y) and (len(opsides) != 2 or (len(opsides) == 2 and opsides[0] - opsides[1] != -2)): #hehe
                nodes.append(Node(x, y))
    for n in nodes:
        n.find_pals()

#maybe fix this
def find_ends():
    ends = []
    for y in range(len(maze)):
        if maze[y][0] == ' ':
            n = Node(0, y)
            ends.append(n)
            nodes.append(n)

        if maze[y][len(maze) - 1] == ' ':
            n = Node(len(maze) - 1, y)
            ends.append(n)
            nodes.append(n)
    for x in range(len(maze[0])):
        if maze[0][x] == ' ':
            n = Node(x, 0)
            ends.append(n)
            nodes.append(n)
        if maze[len(maze[0]) - 1][x] == ' ':
            n = Node(x, len(maze[0]) - 1)
            ends.append(n)
            nodes.append(n)
    return ends

def is_node(x, y):
    for node in nodes:
        if node.x == x and node.y == y:
            return True
    return False

def get_node(x, y):
    for node in nodes:
        if node.x == x and node.y == y:
            return node
    raise ValueError
    print "no node at " + x + ", " + y

def print_maze():
    for y in range(len(maze)):
        row = ''
        for x in range(len(maze[y])):
            if is_node(x, y):
                row += get_node(x, y).c + ' ' * (2 - len(get_node(x, y).c))
            else:
                row += maze[y][x] + ' '
        print row

def find_pathr(node, end, oldpath = []):
    path = list(oldpath)
    path.append(node)
    if node == end:
        return path
    for n in node.pals:
        if n not in path:
            p = find_pathr(n, end, path)
            if p != None:
                return p

def find_path(start, end):
    node = start
    while node != end:
        x = 1

def make_maze(img, pxs):
    maze = []

    for y in range(img.height):
        maze.append([])
        for x in range(img.width):
            if pxs[x, y] == 251:
                maze[y].append(' ')
            else:
                maze[y].append('x')
    return maze

def print_solve(solve, pxs):
    x = solve[0].x
    y = solve[0].y
    for node in solve:
        pxs[x, y] = 175
        while x != node.x or y != node.y:
            if x != node.x:
                x += (node.x - x) / abs(node.x - x)
            else:
                y += (node.y - y) / abs(node.y - y)
            pxs[x, y] = 175



#main
filename = sys.argv[1]

sys.setrecursionlimit(2000)

img = Image.open(filename)
pxs = img.load()
print "Making maze..."
maze = make_maze(img, pxs)

nodes = []
print "Finding ends..."
ends = find_ends()
print "Finding nodes..."
find_nodes()
print "Solving..."
solve = find_pathr(ends[0], ends[1])

print "Printing solve..."
print_solve(solve, pxs)
img.save("solved.png", "PNG")
