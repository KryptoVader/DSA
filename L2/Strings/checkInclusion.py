def checkInclusion(s1, s2):
    if s1 == '':
        return True

    if len(s1) > len(s2):
        return False

    need = {}
    for char in s1:
        need[char] = need.get(char, 0) + 1

    window = {}
    left = 0
    k = len(s1)

    for right in range(len(s2)):
        char = s2[right]
        window[char] = window.get(char, 0) + 1

        if right - left + 1 > k:
            outgoing = s2[left]
            window[outgoing] -= 1
            if window[outgoing] == 0:
                del window[outgoing]
            left += 1

        if right - left + 1 == k and window == need:
            return True

    return False