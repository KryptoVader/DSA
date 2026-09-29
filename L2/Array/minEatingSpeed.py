import math

def minEatingSpeed(piles, h):
    L = 1
    R = max(piles)
    slow = float('inf')
    while L <= R:
        mid = (L + R) // 2
        total = 0
        for ele in piles:
            total += math.ceil(ele/mid)

        if total <= h:
            slow  = min(slow, mid)
            R = mid - 1

        else:
            L = mid + 1

    return slow