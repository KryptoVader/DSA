def non_repeating(s):
    hashmap = dict()
    for ele in s:
        if ele not in hashmap:
            hashmap[ele] = False

        else:
            hashmap[ele] = True

    for ele in hashmap:
        if hashmap[ele] == False:
            return ele

    return ""

print(non_repeating("swiss"))