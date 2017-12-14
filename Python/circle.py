import math

graph = []
WIDTH = 40
HEIGHT = 40

def init_graph():
    for i in range(WIDTH):
        graph.append([])
        for k in range(HEIGHT):
            graph[i].append(' ')

def print_graph():
    for y in graph:
        row = ''
        for x in y:
            row += x + ' '
        print row

def draw_circle(r):
    for x in range(len(graph)):
        for y in range(len(graph[x])):
            if abs(math.sqrt((x - WIDTH/2)**2 + (y - HEIGHT/2)**2) - r) < 0.5:
                graph[x][y] = '+'

init_graph()
draw_circle(19)
print_graph()
