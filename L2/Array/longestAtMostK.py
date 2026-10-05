def longestAtMostK(arr, k):
    hashset = set()
    window = []
    res = 0
    for ele in arr:
        if ele in hashset:
            window.append(ele)
        else:
            hashset.add(ele) 
            window.append(ele)
            while len(hashset) > k:
                window.pop(0)
                hashset = set(window)
        res = max(res, len(window))

    return res
