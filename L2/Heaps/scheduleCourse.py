from heapq import heappush, heappop

def scheduleCourse(courses):
    courses.sort(key = lambda x: x[1])
    max_heap = []
    total_duration = 0

    for course in courses:
        total_duration += course[0]
        heappush(max_heap, -course[0])

        if total_duration > course[1]:
            total_duration += heappop(max_heap)

    return len(max_heap)