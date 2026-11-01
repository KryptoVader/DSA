def findMinArrowShots(points):
    points = sorted(points,  key = lambda x: x[0])
    intersection = points[0]
    arrowCount = 1

    for i in range(1,  len(points)):
        if points[i][0] <= intersection[1]:
            intersection[0] = max(intersection[0], points[i][0])
            intersection[1] = min(intersection[1], points[i][1])
        else:
            arrowCount += 1
            intersection = points[i]
    return arrowCount