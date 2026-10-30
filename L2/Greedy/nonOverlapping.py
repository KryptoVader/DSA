def nonOverlapping(intervals):
    intervals = sorted(intervals, key = lambda x : x[-1])
    count = 0
    max_interval = intervals[0][-1]
    for i in range(1, len(intervals)):
        if intervals[i][0] < max_interval:
            count += 1
        else:
            max_interval = intervals[i][-1]
    return count