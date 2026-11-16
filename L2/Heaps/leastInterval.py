from collections import Counter, deque
from heapq import heapify, heappop, heappush

def leastInterval(tasks, n):
    freq = Counter(tasks)
    heap = [-count for count in freq.values()]
    heapify(heap)
    cooldown = deque()
    time = 0

    while heap or cooldown:
        while cooldown and cooldown[0][0] <= time:
            available_time, remaining = cooldown.popleft()
            heappush(heap, remaining)

        if not heap:
            time = cooldown[0][0]
            continue

        remaining = heappop(heap)
        remaining += 1

        if remaining < 0:
            cooldown.append((time + n + 1, remaining))
        time += 1
    return time