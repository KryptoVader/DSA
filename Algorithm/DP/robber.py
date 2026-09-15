def robber(arr):
    prev = arr[0]
    curr = max(arr[1], prev)

    for i in range(2,len(arr)):
        curr, prev = max(prev +arr[i], curr), curr

    return curr

print(robber([2,7,9,3,1]))