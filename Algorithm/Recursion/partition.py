def partition(arr, L, R):
    pivot = arr[R]
    i = L-1
    j = L
    while j < R:
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
        j+=1

    arr[i+1], arr[R] = arr[R], arr[i+1]
    return i+1

def quick_sort(arr, L, R):
    if L >= R:
        return arr
    
    i = partition(arr, L, R)
    quick_sort(arr, L, i-1)
    quick_sort(arr, i+1, R)
    return arr

arr = [7, 2, 5, 1, 9, 3]
print(quick_sort(arr, 0, len(arr)-1))

arr = [5, 4, 3, 2, 1]
print(quick_sort(arr, 0, len(arr)-1))