def min_cost(cost):
    dp = [[float('inf') for _ in range(len(cost[0]))] for _ in range(len(cost))]
    dp[0][0] = cost[0][0]

    for i in range(1, len(cost)):
        dp[i][0] = dp[i-1][0] + cost[i][0]

    for j in range(1,len(cost[0])):
        dp[0][j] = dp[0][j-1] + cost[0][j]

    for i in range(1, len(cost)):
        for j in range(1,len(cost[0])):
            dp[i][j] = cost[i][j] + min(dp[i-1][j], dp[i][j-1])

    return dp[-1][-1]

grid = [[7]]

print(min_cost(grid))