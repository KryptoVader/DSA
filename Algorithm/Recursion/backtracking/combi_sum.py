def combi(candidates, target, i, curr):
    if sum(curr) == target:
        print(curr)
        return 
    elif sum(curr) > target:
        return

    for j in range(i,len(candidates)):
        curr.append(candidates[j])
        combi(candidates, target, j, curr)
        curr.pop()

combi([2, 3, 6, 7], 7, 0, [])