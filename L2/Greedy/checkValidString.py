def checkValidString(s):
    low, high = 0, 0

    for ele in s:
        if ele == '(':
            low += 1
            high += 1

        elif ele == ')':
            low  -= 1
            high -= 1
        
        else:
            low -= 1
            high +=1

        if high < 0:
            return False
        if low < 0:
            low = 0

    if low == 0:
        return True
    return False