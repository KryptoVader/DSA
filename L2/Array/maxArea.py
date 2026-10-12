def maxArea(height):
    res = 0
    left = 0 
    right = len(height) - 1

    while left < right:
        ans = min(height[left], height[right]) * (right - left)
        res = max(res, ans)

        if height[left] <= height[right]:
            left += 1
        else:
            right -= 1
 
    return res
