def longestEqualZeroOne(arr):
    n0 = 0
    for ele in arr:
        if ele  == 0:
            n0 += 1
        else:
            n0 -= 1

    return len(arr) - abs(n0)