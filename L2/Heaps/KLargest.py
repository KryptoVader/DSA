from heapq import heapify, heappop

def KLargest(nums, k):
    heapify(nums)
    for _ in range(len(nums) - k):
        heappop(nums)

    return heappop(nums)