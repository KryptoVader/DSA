def minWindow(s, t):
    if not s or not t or len(s) < len(t):
        return ""

    need = {}
    for char in t:
        need[char] = need.get(char, 0) + 1

    required = len(need)
    window = {}
    formed = 0

    left = 0
    ans = ""
    min_len = float('inf')

    for right in range(len(s)):
        char = s[right]

        if char in need:
            window[char] = window.get(char, 0) + 1

            if window[char] == need[char]:
                formed += 1

        while formed == required:
            n = right - left + 1

            if n < min_len:
                min_len = n
                ans = s[left:right + 1]

            ele = s[left]

            if ele in need:
                window[ele] -= 1

                if window[ele] < need[ele]:
                    formed -= 1

            left += 1

    return ans