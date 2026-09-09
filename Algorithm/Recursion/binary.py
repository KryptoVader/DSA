def binary(arr, target, L, R):
    if L > R:
        return -1

    mid = (L+R) // 2
    if target == arr[mid]:
        return mid
    
    elif target > arr[mid]:
        return binary(arr, target, mid+1, R)
    return binary(arr, target, L, mid-1)

arr = [1, 3, 5, 7, 9, 11, 13]
print(binary(arr, 7, 0, 6))
print(binary(arr, 8, 0, 6))