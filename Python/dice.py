import random
def roll_dice(sides):
    return random.randint(1, sides)


while True:
    print roll_dice(6)

