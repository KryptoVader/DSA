from heapq import heapify, heappush, heappop

def meetingRooms(intervals):
    if intervals == []:
        return 0
    
    intervals = sorted(intervals, key = lambda x: x[0])
    res = [intervals[0][1]]
    heapify(res)
    for i in range(1, len(intervals)):
        if res[0] <= intervals[i][0]:
            heappop(res)
        heappush(res, intervals[i][1])
    return len(res)