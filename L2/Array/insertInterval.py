def insertInterval(intervals, newInterval):
    if intervals == []:
            return [newInterval]

    flag = False
    for i in range(len(intervals)):
        if intervals[i][0] >= newInterval[0]:
            intervals.insert(i, newInterval)
            flag = True
            break

    if not flag:
        intervals.append(newInterval)

    stack = [intervals[0]] 
    for i in range(1,len(intervals)):
        peek = stack[-1]
        if peek[1] >= intervals[i][0]:
            if peek[1] > intervals[i][1]:
                continue
            else:
                stack[-1][1] = intervals[i][1]
        else:
            stack.append(intervals[i])
    return stack