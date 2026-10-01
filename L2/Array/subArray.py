def subArray(arr, k):
    slide = {0:1}
    s = 0
    i = 0
    count = 0
    for ele in arr:
        s += ele
        if s - k in slide:
           count += slide[s-k]

        if s not in slide:
            slide[s] = 1

        else:
            slide[s] += 1
        i += 1
    return count

tests = [
    ([1, 1, 1], 2, 2),
    ([1, 2, 3], 3, 2),
    ([1, 2, 3, 4], 3, 2),
    ([1, -1, 1, 1], 2, 2),
    ([1, -1, 0], 0, 3),
    ([3, 4, 7, 2, -3, 1, 4, 2], 7, 4),
    ([1], 1, 1),
    ([1], 2, 0),
    ([], 0, 0),
    ([0, 0, 0, 0], 0, 10),
    ([5, -2, 5, -2, 5], 3, 4),
    ([-1, -1, 1], -1, 3),
]

for arr, k, expected in tests:
    result = subArray(arr, k)
    status = "PASS" if result == expected else "FAIL"
    print(f"{status}: arr={arr}, k={k}, got={result}, expected={expected}")