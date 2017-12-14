coins = [25, 10, 5, 1]
for num in range(1, 101):
    temp_num = num
    counter = 0
    i = 0
    while i < len(coins):
        if coins[i] <= temp_num:
            temp_num -= coins[i]
            counter += 1
            i = -1
        i += 1
    print num, ":", counter
