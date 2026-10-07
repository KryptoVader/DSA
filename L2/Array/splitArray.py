def splitArray(arr, m):
    L = max(arr)
    R = sum(arr)
    res = float('inf')

    while L <= R:
        mid  = (L + R) // 2 ## Binary Search
        sub = 1
        tot = 0
        for ele in arr:
            if tot + ele > mid:
                tot = ele
                sub += 1
            else:
                tot += ele

        if sub > m:
            L = mid + 1
        else:
            res = min(res, mid)
            R = mid - 1

    return res
