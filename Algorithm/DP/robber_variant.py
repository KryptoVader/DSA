def robber(value):
    prev = 0
    curr = max(value[0], value[1])

    for i in range(3, len(value)+1):
        prev, curr = curr, max(curr, prev + value[i-1])

    return curr

print(robber([2,7,9]))