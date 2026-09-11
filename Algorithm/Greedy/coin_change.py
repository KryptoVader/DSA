def coin_change(coins, target):
    coins = sorted(coins)
    res = 0

    while target > 0:
        for i in range(len(coins)-1, -1, -1):
            if coins[i] <= target:
                break

        if coins[0] > target:
            res = -1
            break
        
        target -= coins[i]
        res += 1
    return res

coins = [2, 3]
target = 7
print(coin_change(coins, target))