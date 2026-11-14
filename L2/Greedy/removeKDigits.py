def removeKDigits(nums, k):
    stack = []
    for i in nums:
        while stack != [] and stack[-1] > i and k > 0:  
            stack.pop()
            k -= 1
        stack.append(i)

    while k != 0 and stack != []:
        stack.pop()
        k -= 1

    result = ''.join(stack).lstrip('0')
    return result or '0'