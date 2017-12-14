number = input("Input: ")
times = 0
while number != 1:
    if number % 2 == 0:
        number /= 2
    else:
        number *= 3
        number += 1
    print number
    times += 1
print "Inatances", times
