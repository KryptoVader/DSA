def helper(e):
    return e[2]

def schedule_meetings(meetings):
    meetings = sorted(meetings, key = helper)
    res = 0
    d = float("-inf")
    for meeting in meetings:
        if meeting[1] >= d:
            d = meeting[2]
            res += 1

    return res

meetings = [
    ("A", 1, 2),
    ("B", 3, 4),
    ("C", 0, 6),
    ("D", 5, 7),
    ("E", 8, 9),
    ("F", 5, 9)
]

print(schedule_meetings(meetings))