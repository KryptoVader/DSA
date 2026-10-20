def checkAnagrams(s1, s):
    if len(s) == 0 or len(s) > len(s1):
        return []

    res = []
    need = {}
    for char in s:
        need[char] = need.get(char, 0) + 1

    windowSize = len(s)
    window = {}
    left = 0

    for i in range(len(s1)):
        char = s1[i]
        if char in window:
            window[char] += 1

        else:
            window[char] = 1

        if i - left + 1 > windowSize:
            window[s1[left]] -= 1
            if window[s1[left]] == 0:
                del window[s1[left]]
            left += 1

        if windowSize == i - left + 1:
            if window == need:
                res.append(left)

    return res