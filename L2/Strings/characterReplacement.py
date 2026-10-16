def characterReplacement(s, k):
    max_freq = 0
    freq = {}
    left = 0
    res = 0
    for i in range(len(s)):
        right = i
        if s[i] not in freq:
            freq[s[i]] = 1

        else:
            freq[s[i]] += 1

        max_freq = max(max_freq, freq[s[i]])
        length = right - left + 1
        while length - max_freq > k:
            freq[s[left]] -= 1
            left += 1
            length -= 1

        res = max(res, length)
    return res