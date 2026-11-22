from heapq import heappush, heappop
from math import inf

def mincostToHireWorkers(quality, wage, k):
    workers = sorted((w / q, q) for q, w in zip(quality, wage))
    max_heap = []
    quality_sum = 0
    min_cost = inf

    for ratio, q in workers:
        heappush(max_heap, -q)
        quality_sum += q

        if len(max_heap) > k:
            quality_sum += heappop(max_heap)

        if len(max_heap) == k:
            min_cost = min(min_cost, ratio * quality_sum)

    return min_cost