def partitionLabels(s):
    occur = {}
    for i in range(len(s)):
        occur[s[i]] = i

    start, end = 0, 0
    res = []
    for i in range(len(s)):
        end = max(end, occur[s[i]])
        if end == i:
            res.append(end - start + 1)
            start = i + 1
    return res