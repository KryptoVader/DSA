def longestConsecutive(arr):
    hashset = set(arr)
    res = 0
    for ele in arr:
        if ele - 1 in hashset:
            continue

        else:
            i = ele
            count = 0
            while i in hashset:
                count += 1
                i += 1

            res = max(res, count)

    return res