def coinChange(coins, amount):
    dp = [-1] * (amount+1)
    dp[0] = 0

    for a in range(1, amount+1):
        for coin in coins:
            if coin <= a and dp[a - coin] != -1:
                if dp[a] == -1:
                    dp[a] = 1 + dp[a - coin]
                else:
                    dp[a] = min(dp[a], 1 + dp[a - coin])

    return dp[amount] 