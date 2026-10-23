from heapq import heapify, heappop
def topKLargestElement(arr, k):
    heapify(arr)
    for _ in range(len(arr)-k):
        heappop(arr)

    return heappop(arr)