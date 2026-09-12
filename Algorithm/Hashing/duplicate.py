def duplicate(arr):
    hashset = set()
    for i in arr:
        if i in hashset:
            return i
        hashset.add(i)

print(duplicate([4, 2, 7, 2, 9, 3, 3, 3]))