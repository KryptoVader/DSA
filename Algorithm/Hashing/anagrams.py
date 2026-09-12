from collections import Counter

def anagrams(s,t):
    if len(s) !=  len(t):
        return False
    
    s = dict(Counter(s))
    t = dict(Counter(t))

    for ele in s.keys():
        if ele not in t or s[ele] != t[ele]:
            return False

    return True

s = "listen"
t = "silent"
print(anagrams(s,t)) 