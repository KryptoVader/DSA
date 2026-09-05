def prefix_sum(arr, L, R):
    prefix = [0] * (len(arr)+1)

    for i in range(len(arr)):
        prefix[i+1] = prefix[i] + arr[i]

    return prefix[R+1] - prefix[L]

print(prefix_sum([3, 2, 5, 1, 7, 4], 1,4))
print(prefix_sum([3, 2, 5, 1, 7, 4], 0,4))
print(prefix_sum([3, 2, 5, 1, 7, 4], 2,5))