def longestUnique(arr):
    seen = {}
    left = 0
    res = 0

    for i in range(len(arr)):
        if arr[i] not in seen:
            seen[arr[i]] = i

        else:
            if seen[arr[i]] >= left:
                left = seen[arr[i]] + 1
            seen[arr[i]] = i
        res = max(res, i - left + 1)
    return res
