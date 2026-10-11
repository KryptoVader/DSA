def threeSum(arr):
    hashset = set()
    res = []

    for i in range(len(arr)):
        hashmap = set()
        for j in range(i+1, len(arr)):
            if -(arr[j] + arr[i]) in hashmap:
                tup = tuple(sorted([arr[i], arr[j], -(arr[j] + arr[i])]))
                if tup in hashset:
                    continue
                else:
                    res.append(list(tup))
                    hashset.add(tup)
            else:
                hashmap.add(arr[j])

    return res