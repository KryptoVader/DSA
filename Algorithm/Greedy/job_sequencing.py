def k(e):
    return e[2]

def job_sequencing(entities):
    entities = sorted(entities, key = k, reverse=True)
    max_d = max(ele[1] for ele in entities)
    arr = [None for _ in range(max_d)]

    for ele in entities:
        if ele[1] <= max_d:
            i = ele[1]-1
            while(i >= 0):
                if arr[i] == None:
                    arr[i] = ele[2]
                    break
                i -= 1
    return sum(arr)

jobs = [
    ("A", 2, 100),
    ("B", 2, 200),
    ("C", 2, 300),
    ("D", 2, 400)
]

print(job_sequencing(jobs))