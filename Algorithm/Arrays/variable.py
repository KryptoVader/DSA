def variable(arr, target):
    minLen = float('inf')
    s = 0
    L = 0 
    for R in range(len(arr)):
        s += arr[R]

        while(s >= target):
            minLen = min(minLen, R-L+1)
            s -= arr[L]
            L += 1
    return minLen
    
print(variable([2, 3, 1, 2, 4, 3], 7))