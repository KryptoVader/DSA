def canCompleteCircuit(gas, cost):
    total, current, start = 0, 0, 0

    for i in range(len(gas)):
        net = gas[i] - cost[i]
        total += net
        current += net

        if current < 0:
            current = 0
            start = i + 1


    if total < 0:
        return -1
    return start