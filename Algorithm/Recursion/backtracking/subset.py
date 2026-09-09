def subset(arr, i, curr):
    if len(arr) == i:
        print(curr)
        return 

    choice = [[], arr[i]]
    for ch in choice:
        if ch == []:
            subset(arr, i+1, curr)
        else:
            curr.append(ch)
            subset(arr, i+1, curr)
            curr.pop()

subset([1,2,3], 0, [])