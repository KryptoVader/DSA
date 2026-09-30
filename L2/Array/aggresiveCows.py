def aggressiveCows(stalls, k):
    stalls = sorted(stalls)
    L = 0
    R = stalls[-1] - stalls[0]
    res = float('-inf')
    
    while L <= R:
        mid  = (L + R) // 2
        i = 0
        count = 1
        for j in range(1, len(stalls)):
            if stalls[j] - stalls[i] >= mid:
                count += 1
                i = j

        if count >= k:
            res = max(res, mid)
            L = mid + 1

        else:
            R = mid - 1
    return res
