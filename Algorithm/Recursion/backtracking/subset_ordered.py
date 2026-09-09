def subsets(arr, i , curr, k):
    if len(curr) == k:
        print(curr)
        return

    for j in range(i, len(arr)):
        curr.append(arr[j])
        subsets(arr, j+1, curr, k)
        curr.pop()

for i in range(len([1,2,3])+1):
    subsets([1,2,3], 0, [], i)