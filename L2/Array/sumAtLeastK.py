def sumAtLeastK(arr, k):
    if len(arr) == 0:
        return 0
    
    window = []
    res = float('inf')
    curr_sum = 0
    for ele in arr:
        if ele + curr_sum < k:
            window.append(ele)
            curr_sum += ele

        else:
            window.append(ele)
            curr_sum += ele
            res = min(res, len(window))

            while curr_sum >= k:
                res = min(res, len(window))
                curr_sum -= window[0]
                window.pop(0)

    if res == float('inf'):
        return 0
    return res