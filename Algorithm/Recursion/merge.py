def merge(arr1, arr2):
    i,j = 0,0
    new_arr = []

    while i < len(arr1) and j < len(arr2):
        if arr1[i] <= arr2[j]:
            new_arr.append(arr1[i])
            i += 1

        elif arr1[i] >= arr2[j]:
            new_arr.append(arr2[j])
            j+= 1

    while i < len(arr1):
        new_arr.append(arr1[i])
        i+= 1

    while j < len(arr2):
        new_arr.append(arr2[j])
        j+= 1
    return new_arr

def merge_sort(arr, L, R):
    if L >= R:
        return [arr[L]]
    
    mid = (L+R) // 2
    left = merge_sort(arr,L,mid)
    right = merge_sort(arr, mid+1, R)
    return merge(left, right)


arr = [7, 2, 5, 1, 9, 3]
arr = merge_sort(arr, 0, len(arr)-1)
print(arr)

arr = merge_sort(arr, 0, len(arr)-1)
print(arr)

arr = [5, 4, 3, 2, 1]
arr = merge_sort(arr, 0, len(arr)-1)
print(arr)


arr = [4, 2, 4, 1, 2, 4]
arr = merge_sort(arr, 0, len(arr)-1)
print(arr)


arr = [8]
arr = merge_sort(arr, 0, 0)
print(arr)

arr = [9, 3]
arr = merge_sort(arr, 0, 1)
print(arr)

arr = [-3, 5, -1, 0, -7, 2]
arr = merge_sort(arr, 0, len(arr)-1)
print(arr)


arr = [5, 5, 5, 5]
arr = merge_sort(arr, 0, len(arr)-1)
print(arr)