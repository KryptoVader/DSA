def stair(n):
    one = 1
    curr = 2

    for i in range(3,n+1):
        temp = one + curr
        one = curr
        curr = temp

    return curr

print(stair(10))