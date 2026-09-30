def shipWithinDays(weights, days):
    L = max(weights)
    R = sum(weights)
    res = float('inf')

    while L<= R:
        mid = (L + R) // 2

        curr_load = 0
        days_needed = 1
        for ele in weights:
            if curr_load + ele <= mid:
                curr_load += ele
            else:
                curr_load = ele
                days_needed += 1

        if days_needed > days:
            L = mid + 1
        else:
            res = min(res, mid)
            R = mid - 1

    return res
