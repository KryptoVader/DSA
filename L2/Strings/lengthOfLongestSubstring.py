def lengthOfLongestSubstring(s):
    if s == '':
        return 0

    window = set()
    res = 0
    left = 0 
    for char in s:
        while char in window and left < len(s): ## Using the condition to update and maintain the window
            window.remove(s[left])
            left += 1
        
        window.add(char)
        res = max(res, len(window))
    return res