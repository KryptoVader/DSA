def groupAna(arr):
    res = {}

    for ele in arr:
        need = [0] * 26
        for char in ele:
            need[ord(char) - ord('a')] += 1

        need = tuple(need)

        if need in res:
            res[need].append(ele)

        else:
            res[need] = [ele]

    return list(res.values())