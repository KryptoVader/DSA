def trapWater(height):
    if len(height) < 3:
        return 0

    L = 0
    R = len(height) - 1
    l_m = height[L]
    r_m = height[R]
    res = 0

    while L < R:
        if height[L] <= height[R]:
            if height[L] >= l_m:
                l_m = height[L]
            else:
                res += l_m - height[L]
            L += 1
        else:
            if height[R] >= r_m:
                r_m = height[R]
            else:
                res += r_m - height[R]
            R -= 1

    return res  