def mergeInterval(arr):
    if arr == []:
        return []
    
    arr = sorted(arr, key = lambda x: x[0])
    stack = [arr[0]]

    for i in range(1, len(arr)):
        comp = stack[-1]
        if comp[1] >= arr[i][0]:
            if comp[1] > arr[i][1]:
                continue
            else:
                stack[-1][1] = arr[i][1]

        else:
            stack.append(arr[i])

    return stack
