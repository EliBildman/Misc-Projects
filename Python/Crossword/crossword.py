# one click boom crossword

from random import randint, choice
from deffinitions import deff
from math import sin, cos, pi
from words import words
from PIL import Image, ImageDraw, ImageFont
import sys



def init_board(w, h):
    for y in range(h):
        board.append([])
        for x in range(w):
            board[y].append('.')

def print_board():
    for row in board:
        for c in row:
            sys.stdout.write(c + " ")
        print

def new_word():
    cutoff = 50000
    word = None
    c = 0
    while word == None:
        c += 1
        d = randint(0, 1)
        dx = int(cos(pi/2 * d))
        dy = int(sin(pi/2 * d))
        size = randint(1, len(words[len(words) - 1]))
        x = randint(0, width - (size -1) * dx - 1)
        y = randint(0, height - (size - 1) * dy - 1)
        if sides_clear(size, x, y, dx, dy):
            req = ''
            for i in range(size):
                req += board[y + i * dy][x + i * dx]
            word = find_word(size, req)
        if c >= cutoff:
            return None
    place_word(word, x, y, dx, dy)
    if dx == 1:
        hor[word] = [x, y]
    else:
        ver[word] = [x, y]
    return word

def sides_clear(size, x, y, dx, dy):
    sx, sy = dy, dx
    for i in range(size):
        try:
            if board[(y + i * dy) + sy][(x + i * dx) + sx] != "." and board[y + i * dy][x + i * dx] == ".":
                return False
        except:
            "nothing? how does this language work"
        try:
            if board[(y + i * dy) - sy][(x + i * dx) - sx] != "." and board[y + i * dy][x + i * dx] == ".":
                return False
        except:
            "this is one of the most disgusting hacks ive ever written"
    try:
        if board[y - dy][x - dx] != ".":
            return False
    except:
        "sorry"
    try:
        if board[y + size * dy][x + size * dx] != ".":
            # print size
            # print x
            # print y
            # print dx
            # print dy
            return False
    except:
        ".."

    return True

def find_word(l, req):
    for word in words:
        if len(word) == l and word not in hor and word not in ver:
            works = True
            for i in range(len(req)):
                if req[i] != "." and req[i] != word[i]:
                    works = False
                    break
            if works:
                return word


def place_word(word, x, y, dx, dy):

    for i in range(len(word)):
        board[y + i * dy][x + i * dx] = word[i]

width = int(sys.argv[1])
height = int(sys.argv[2])
board = []
init_board(width, height)
hor ={}
ver = {}
c = 0
i = 0
wordcount = int(sys.argv[3])
while i < wordcount:
    if new_word() == None:
        c += 1
        i = 0
        hor = {}
        ver = {}
        print "Retry " + str(c)
        board = []
        init_board(width, height)
    i+=1
mult = 40

img = Image.new("RGBA", (width * mult, height * mult) , "white")
pxs = img.load()

for y in range(img.height):
    for x in range(img.width):
        if board[y/mult][x/mult] == '.' or y % mult == 0 or x % mult == 0:
            pxs[x, y] = (0, 0, 0)

txt = Image.new("RGBA", img.size, (255, 255, 255, 0))
fnt = ImageFont.truetype(font="/mnt/c/Windows.old/WINDOWS/Fonts/times.ttf", size=15)
d = ImageDraw.Draw(txt)

deffs = []
counter = 0
for word in hor.keys():
    counter += 1
    deffs.append(deff[word])
    d.text((hor[word][0] * mult + 5, hor[word][1] * mult), str(counter), font=fnt, fill=(0, 0, 0, 255))
for word in ver.keys():
    counter += 1
    deffs.append(deff[word])
    d.text((ver[word][0] * mult + 5, ver[word][1] * mult), str(counter), font=fnt, fill=(0, 0, 0, 255))



out = Image.alpha_composite(img, txt)

out.save(str(width) + "x" + str(height) + " crossword.png", "PNG")

for w in hor.keys():
    print deff[w]

print_board()
