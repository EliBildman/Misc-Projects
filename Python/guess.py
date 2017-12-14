import random
playing = True
while playing:
    number = random.randint(1, 500)
    0
    tries = 0
    guess = 0
    print "Guess the number between 1 and 500 in 8 tries."
    while guess != number and tries < 8:
        print
        print 8 - tries, "guesses left"
        guess = raw_input("Guess: ")
        if guess.isdigit() and 0 < int(guess) < 500:
            guess = int(guess)
            if guess > number:
                print "Too high"
            elif guess < number:
                print "Too low"
            tries += 1
        else:
            print "Not valid"
            tries += 1
    if guess == number:
        print "Correct, the number was", number
    else:
        print "You lose, the number was", number
    answer = raw_input("Play again? ")
    if answer.strip().lower() in "n no".split():
        playing = False
print "Goodbye"
