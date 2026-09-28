def rotatedSorted(arr, target):
    L = 0
    R = len(arr)-1

    while L <= R:
        mid = (L+R) // 2

        if arr[L] <= arr[mid]:
            if arr[L] <= target <= arr[mid]:
                if arr[mid] == target:
                    return mid
                elif arr[mid] < target:
                    L = mid + 1
                else:
                    R  = mid - 1
            else:
                L = mid + 1
        else:
            if arr[mid] <= target <= arr[R]:
                if arr[mid] == target:
                    return mid
                elif arr[mid] < target:
                    L = mid + 1
                else:
                    R  = mid - 1
    return -1
