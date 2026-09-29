def BinarySearch2D(arr, target):
    L = 0
    R = len(arr) -1 
    mid = 0 
    while L <= R:
        mid = (L + R) // 2
        if arr[mid][0] <= target <= arr[mid][-1]:
            break

        elif arr[mid][-1] < target:
            L  = mid + 1
        elif arr[mid][0] > target:
            R = mid - 1

        else:
            return False

    L = 0
    R = len(arr[mid]) - 1
    while L <= R:
        m = (L + R) // 2
        if arr[mid][m] == target:
            return True

        elif arr[mid][m] < target:
            L = m + 1
        else:
            R = m - 1 

    return False