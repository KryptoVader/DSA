def longestSubarray(arr, k):
    res = 0
    slide = {0:-1}
    s = 0
    i = 0
    for ele in arr:
        s += ele
        if s - k in slide:
            res = max(res, i - slide[s-k])
        
        if s not in slide:
            slide[s] = i
        i += 1
    return res
