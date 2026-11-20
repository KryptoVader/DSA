from heapq import heappop, heappush

def findMaximizedCapital(k, w, profits, capital):
    min_heap = list(zip(capital, profits))
    min_heap.sort(key = lambda x: x[0])

    max_heap = []
    i = 0
    while k:
        while i < len(min_heap) and min_heap[i][0] <= w:
            ele = min_heap[i]
            heappush(max_heap, -ele[1])
            i += 1

        if not max_heap:
            return w

        largest_profit = -heappop(max_heap)
        w += largest_profit
        k -= 1

    return w
                