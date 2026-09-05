def kadane(arr):
    maxSum, curSum = float('-inf'), float('-inf')
    res = []
    best = []
    for i in range(len(arr)):
        if curSum == float('-inf'):
            res.append(arr[i])
            best.append(arr[i])
            curSum = arr[i]
            maxSum = arr[i]
        else: 
            if (curSum + arr[i]) > arr[i]:
                curSum = curSum + arr[i]
                res.append(arr[i])
            else:
                curSum = arr[i]
                res = [arr[i]]

            if curSum > maxSum:
                best = res.copy()
                maxSum = curSum
    return maxSum, best 

print(kadane([-2, 3, -1, 5, -6]))
print(kadane([4, -1, 2, 1, -20]))
print(kadane([-5, -2, -8, -1]))