def lcs(arr):
    hashset = set(arr)
    res = 0
    for ele in arr:
        if ele -1 not in hashset:
            length = 1
            while ele + 1 in hashset:
                length += 1
                ele += 1
        res = max(res, length)
    return res

print(lcs([1, 2, 3, 100, 101, 102, 103, 104]))
print(lcs([100, 1, 2, 3]))
print(lcs([5]))
print(lcs([]))
print(lcs([1, 2, 4, 5, 6]))