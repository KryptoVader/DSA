def knapsack(weights, value, W):
    dp = [[0 for _ in range(W + 1)] for _ in range(len(weights) + 1)]

    for i in range(1, len(weights)+1):
        for j in range(1, W+1):
            if(weights[i-1] <= j):
                dp[i][j] = max(dp[i-1][j], value[i-1] + dp[i-1][j-weights[i-1]])
            else:
                dp[i][j] = dp[i-1][j]
    return dp[-1][-1]

weights = [1, 2, 3]
values  = [6, 10, 12]
W = 5
print(knapsack(weights, values, W))