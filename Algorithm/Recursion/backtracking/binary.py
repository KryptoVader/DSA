def binary(n, s):
    if len(s) == n:
        print(s)
        return ""

    for choice in [0,1]:
        s += str(choice)
        binary(n,s)
        s = s[:-1]

binary(3,'')
