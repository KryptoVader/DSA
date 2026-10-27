def dailyTemperatures(temperatures):
    res = [0] * len(temperatures)
    stack = []
    for i in range(len(temperatures)):
        while stack and temperatures[stack[-1]] < temperatures[i]:
            j = stack.pop()
            res[j] = i - j

        stack.append(i)
    return res