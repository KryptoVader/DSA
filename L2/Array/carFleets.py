def carFleets(target, position, speed):
    time = []
    for i in range(len(position)):
        t = (target - position[i]) / speed[i]
        time.append(t)

    arr = []
    for i in range(len(position)):
        arr.append((position[i], speed[i], time[i]))

    arr = sorted(arr, key = lambda x: x[0], reverse = True)
    fleets = 0
    last_time = 0
    for ele in arr:
        t = ele[-1]
        if t > last_time:
            fleets += 1
            last_time = t
    return fleets