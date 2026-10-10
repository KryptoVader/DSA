def productExceptSelf(arr):
    ans = []
    for i in range(len(arr)):
        if i == 0:
            ans.append(1)
        else:
            ans.append(arr[i-1] * ans[i-1])
    suffix = 1

    for i in range(len(arr) - 1, -1, -1):
        ans[i] *= suffix
        suffix *= arr[i]
    return ans