def max_sum_subarray(arr, k):
    s = sum(arr[:k])
    max_sum = s

    for i in range(1, len(arr) - k + 1):
        s = s - arr[i-1] + arr[i+k-1]
        max_sum = max(max_sum, s)
    return max_sum

print(max_sum_subarray([2, 1, 5, 1, 3, 2], 3))