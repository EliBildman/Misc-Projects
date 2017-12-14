import random
numbers = "0123456789"


def roll_dice(cappa):
    return random.randint(1, cappa)


def hot_graphics(rollz):
    if len(rollz) == 0:
        print "None"
    meme = ["", "", "", "", "", ""]
    meme[0] = [" _ _ _ _ ", "|       |", "|   .   |", "|       |", "|_ _ _ _|"]
    meme[1] = [" _ _ _ _ ", "|     . |", "|       |", "| .     |", "|_ _ _ _|"]
    meme[2] = [" _ _ _ _ ", "|     . |", "|   .   |", "| .     |", "|_ _ _ _|"]
    meme[3] = [" _ _ _ _ ", "| .   . |", "|       |", "| .   . |", "|_ _ _ _|"]
    meme[4] = [" _ _ _ _ ", "| .   . |", "|   .   |", "| .   . |", "|_ _ _ _|"]
    meme[5] = [" _ _ _ _ ", "| .   . |", "| .   . |", "| .   . |", "|_ _ _ _|"]
    for x in range(5):
        for i in rollz:
            print meme[i - 1][x],
            print "   ",
        print
    for x in range(1, len(rollz)+1):
        print x,
        print "           ",
    print


def turn(player, z):
    global playerTakens

    print "Available Scoring Methods:"
    options = ["a", "2", "3", "4", "5", "6", "3o", "4o", "fh", "ss", "ls", "yh", "ch"]
    for din in options:
        if din not in playerTakens[z]:
            print din,
    print
    print
    rolls = []
    keep = []
    for x in range(3):
        taken = []
        rolls = keep
        raw_input("Press [Enter] to Roll Dice")
        for i in range(5 - len(keep)):
            rolls.append(roll_dice(6))
        print
        if x == 2:
            print "Final Roll:"
        hot_graphics(rolls)
        keep = []
        if x != 2:
            keepInput = raw_input("Which rolls will you keep?(1-5): ")
            for p in keepInput:
                if p in numbers and p not in taken:
                    keep.append(rolls[int(p)-1])
                    taken.append(p)
            print
            print "Kept:"
            hot_graphics(keep)
    score(player, rolls, z)


def score(player, numbers, dingus):
    global playerTakens
    global playerScores
    #print playerScores
    #print playerTakens
    #print x
    taken = playerTakens[x]
    valid = False
    final = 0
    ones = 0
    twos = 0
    threes = 0
    fours = 0
    fives = 0
    sixes = 0
    lm = False
    ao = False
    for number in numbers:
        if number == 1:
            ones += 1
        elif number == 2:
            twos += 1
        elif number == 3:
            threes += 1
        elif number == 4:
            fours += 1
        elif number == 5:
            fives += 1
        elif number == 6:
            sixes += 1
    intances = [ones, twos, threes, fours, fives, sixes]
    while not valid:
        print
        print "What do you want to score for? (",
        options = ["a", "2", "3", "4", "5", "6", "3o", "4o", "fh", "ss", "ls", "yh", "ch", "skip"]
        for din in options:
            if din not in playerTakens[dingus]:
                print din,
        mode = raw_input("): ")
        mode = mode.lower()
        if mode == "a" and 'a' not in taken:
            valid = True
            taken.append('a')
            for number in numbers:
                if number == 1:
                    final += 1
        elif mode == "2" and '2' not in taken:
            valid = True
            taken.append('2')
            for number in numbers:
                if number == 2:
                    final += 2
        elif mode == "3" and '3' not in taken:
            valid = True
            taken.append('3')
            for number in numbers:
                if number == 3:
                    final += 3
        elif mode == "4" and '4' not in taken:
            valid = True
            taken.append('4')
            for number in numbers:
                if number == 4:
                    final += 4
        elif mode == "5" and '5' not in taken:
            valid = True
            taken.append('5')
            for number in numbers:
                if number == 5:
                    final += 5
        elif mode == "6" and '6' not in taken:
            valid = True
            taken.append('6')
            for number in numbers:
                if number == 6:
                    final += 6
        elif mode == "3o" and "3o" not in taken:
            for thing in intances:
                if thing > 2:
                    valid = True
            if valid:
                taken.append("3o")
                for number in numbers:
                    final += number
        elif mode == "4o" and "4o" not in taken:
            for thing in intances:
                if thing > 3:
                    valid = True
            if valid:
                taken.append("4o")
                for number in numbers:
                    final += number
        elif mode == "fh" and "fh" not in taken:
            for thing in intances:
                if thing == 3:
                    lm = True
                elif thing == 2:
                    ao = True
            if lm and ao:
                valid = True
            if valid:
                final = 25
                taken.append("fh")
        elif mode == "ss" and "ss" not in taken:
            if 1 in numbers and 2 in numbers and 3 in numbers and 4 in numbers:
                valid = True
            elif 2 in numbers and 3 in numbers and 4 in numbers and 5 in numbers:
                valid = True
            elif 3 in numbers and 4 in numbers and 5 in numbers and 6 in numbers:
                valid = True
            if valid:
                final = 30
                taken.append("ss")
        elif mode == "ls" and "ls" not in taken:
            if 1 in numbers and 2 in numbers and 3 in numbers and 4 in numbers and 5 in numbers:
                valid = True
            elif 2 in numbers and 3 in numbers and 4 in numbers and 5 in numbers and 6 in numbers:
                valid = True
            if valid:
                final = 40
                taken.append("ls")
        elif mode == "yh":
            for thing in intances:
                if thing > 4:
                    valid = True
            if valid:
                if "yh" not in taken:
                    final = 50
                else:
                    final = 100
        elif mode == "ch" and "ch" not in taken:
            valid = True
            taken.append("ch")
            for number in numbers:
                final += number
        if mode == "skip":
            valid = True
            final = 0
        if not valid:
            print "Invalid Input/Choice"
    playerTakens[dingus] = taken
    print "Round Points:", final
    playerScores[dingus] += final
    print player, "Score: ", playerScores[dingus]


playerNames = ["", "", "", "", "", ""]
playerScores = [0, 0, 0, 0, 0, 0]
playerTakens = [[], [], [], [], [], []]


amount = input("How many players?(1-6): ")
for x in range(amount):
    thing = "Player " + str(x + 1) + " Name: "
    playerNames[x] = raw_input(str(thing))

over = False
while not over:
    print
    if amount > 1:
        print "Current Scores"
        for lmao in range(amount):
            print playerNames[lmao] + ": " + str(playerScores[lmao])

    for x in range(amount):
        #print x
        print
        print playerNames[x], "Turn"
        turn(playerNames[x], x)
        if len(playerTakens[x]) == 12:
            over = True

print
print "Final Score"
for lmao in range(amount):
    print playerNames[lmao] + ": " + str(playerScores[lmao])

macs = 0
thing = 0
for y in range(len(playerScores)):
    if playerScores[y] > macs:
        macs = playerScores[y]
        thing = y

print
print playerNames[thing] + " Wins!"

