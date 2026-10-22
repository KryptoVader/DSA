def KFreqEleBucket(arr, k):
    freq = {}
    for ele in arr:
        freq[ele] = freq.get(ele, 0) + 1

    bucket = {}
    for val in freq.values():
        bucket[val] = bucket.get(val, [])

    for key, val in freq.items():
        bucket[val].append(key)

    res = []
    for i in range(len(arr), 0, -1):
        if len(res) == k:
            break
        
        if i in bucket:
            res.extend(bucket[i])

    return res
