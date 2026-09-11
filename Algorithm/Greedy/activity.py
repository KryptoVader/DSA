def end(e):
    return e[2]

def activity_selection(activities):
    activities = sorted(activities, key=end)
    res = []
    end_time = float('-inf')
    for i in activities:
        if i[1] < end_time:
            continue
        res.append(i[0])
        end_time = i[2]
    return res

act = [
    ("A", 1, 3),
    ("B", 2, 4),
    ("C", 3, 5),
    ("D", 0, 6),
    ("E", 5, 7),
    ("F", 8, 9),
    ("G", 5, 9)
]

print(activity_selection(act))