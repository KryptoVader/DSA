def twoCitySchedCost(costs):
    costs.sort(key = lambda x: x[0] - x[1])
    n = len(costs) // 2

    total = 0
    for cost in range(len(costs)):
        if n != 0:
            total += costs[cost][0]
            n -= 1
        else:
            total += costs[cost][1]

    return total