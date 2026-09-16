def grid(m, n):
    dp = [1 for _ in range(n)]

    for _ in range(1,m):
        for i in range(1,n):
                dp[i] = dp[i] + dp[i-1]

    return  dp[n-1]

print(grid(3,3))