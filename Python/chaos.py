from graphics import *
import random
import math

conversion = math.pi/180

points = int(raw_input("Points: "))
width = int(raw_input("Width: "))
height = int(raw_input("Height: "))
loops = int(raw_input("Dots: "))

def draw_choas(height, width, loops, points):
    win = GraphWin("Chaos", width, height)
    currentx = width/2
    currenty = height/2

    for x in range(loops):
        thing = random.randint(1, loops)
        pointx = width / 2 * math.cos((360 * thing/points - 90) * conversion) + (width / 2)
        pointy = height / 2 * math.sin((360 * thing/points - 90) * conversion) + (height / 2)
        currentx = (currentx + pointx) / 2
        currenty = (currenty + pointy) / 2
        win.plot(currentx, currenty, "black")
    win.getMouse()

draw_choas(height, width, loops, points)
