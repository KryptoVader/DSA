def coins(arr, n):
    dp = [-1 for _ in range(n+1)]
    dp[0] = 0

    for i in range(1,n+1):
        for j in range(len(arr)):
            if arr[j] <= i and dp[i-arr[j]] != -1:
                if dp[i] == -1:
                    dp[i] = 1+dp[i-arr[j]]
                else:
                    dp[i] = min(dp[i], 1+dp[i-arr[j]])

    return dp[n]

print(coins([2], 3))      
print(coins([2], 6))      
print(coins([1, 3, 4], 6)) 
print(coins([2, 5, 10], 1)) 