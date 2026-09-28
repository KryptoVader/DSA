def insertIndex(arr, target):
    L = 0
    R = len(arr) - 1

    while L <= R:
        mid  = (L + R) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            L = mid + 1
        else:
            R = mid - 1

    return L