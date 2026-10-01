def subArray(arr, k):
    slide = {0:1}
    s = 0
    i = 0
    count = 0
    for ele in arr:
        s += ele
        if s - k in slide:
           count += slide[s-k]

        if s not in slide:
            slide[s] = 1

        else:
            slide[s] += 1
        i += 1
    return count