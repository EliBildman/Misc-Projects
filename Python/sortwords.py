from deffinitions import deff

f = open("words.py", "w")

keys = deff.keys()
keys.sort(lambda x,y: cmp(len(x), len(y)))
f.write("words = " + str(keys))
