def countSubArray(arr, k):
    if k <= 1:
        return 0

    res = 0
    slide = 1
    left = 0

    for i in range(len(arr)):
        slide *= arr[i]

        while slide >= k and left < len(arr):
            slide //= arr[left]
            left += 1

        res += i - left + 1
    return res
