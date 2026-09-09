def permutation(candidates, curr):
    if len(curr) == len(candidates):
        print(curr)
        return

    for i in candidates:
        if i not in curr:
            curr.append(i)
            permutation(candidates, curr)
            curr.pop()

permutation([1,2,3], [])