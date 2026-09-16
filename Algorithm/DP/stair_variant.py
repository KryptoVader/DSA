def stair_var(n):
    prev = 1
    prev_c = 1
    curr = 2

    for _ in range(3,n+1):
        prev, prev_c, curr = prev_c, curr, curr+prev_c+prev

    return curr

print(stair_var(4))