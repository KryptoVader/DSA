def k(e):
    return e[2]

def fractional_knapsack(items, capacity):
    val = []
    for i in items:
        val.append([i[1], i[2], i[1] / i[2]])
    val = sorted(val, key = k, reverse= True)

    res = 0
    for ele in val:
        if capacity >= 0 and capacity >= ele[1]:
            capacity -= ele[1]
            res += ele[0]
        else:
            res += ele[2] * capacity
            capacity = 0

    return res

items = [
    ("A", 60, 10),
    ("B", 100, 20),
    ("C", 120, 30)
]

capacity = 50
print(fractional_knapsack(items, capacity))