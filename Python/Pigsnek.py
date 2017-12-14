VOWELS = 'aeiou'


def convert_word(word):
    first_letter = word[0]
    if first_letter in VOWELS:
        return word + "yay"
    else:
        for x in range(1, len(word)):
            if word[x] in VOWELS or word[x] == 'y':
                return word[x:] + word[:x] + "ay"


def convert_sentence(sentence, mode):
    valid = True
    sentence = sentence.lower()
    for letter in sentence:
        if not(letter.isalpha()) and letter != " ":
            valid = False
    if valid:
        list_of_words = sentence.split(' ')
        new_sentence = ""
        if mode == 0:
            for word in list_of_words:
                new_sentence += translate_word_opish(word)
                new_sentence += " "
        elif mode == 1:
            for word in list_of_words:
                new_sentence += convert_word(word)
                new_sentence += " "
        return new_sentence
    else:
        return "Invalid Input"


def translate_word_opish(word):
    word = list(word)
    y = len(word)
    x = 0
    final = ""
    while x < y:
        if word[x].isalpha() and word[x] not in VOWELS and word[x] != 'op':
            word.insert(x + 1, 'op')
            y += 1
        x += 1
    for x in word:
        final += x
    return final


text = raw_input("Sentence: ")
print
print "Opish: " + convert_sentence(text, 0)
print "PigLatin: " + convert_sentence(text, 1)
