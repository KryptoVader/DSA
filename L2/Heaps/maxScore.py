from heapq import heappush, heappop

def maxScore(nums1, nums2, k):
    nums = list(zip(nums1,nums2))
    nums.sort(key = lambda x: x[1], reverse = True)

    lo = []
    score, run = 0, 0
    for i in range(len(nums)):
        ele = nums[i][0]
        run += ele
        heappush(lo, ele)

        while len(lo) > k:
            run -= heappop(lo)

        if len(lo) == k:
            score = max(score, run * nums[i][1])

    return score
