userin = raw_input("Word: ")
newword = ""
for x in range(len(userin) - 1, -1, -1):
    newword += userin[x]
print "That word backwards is: " + newword
