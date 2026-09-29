def findPeak(arr):
    L = 0
    R = len(arr) - 1

    if len(arr) <= 1:
        return 0

    while L <= R:
        mid = (L + R) // 2

        if mid == 0:
            if arr[0] > arr[1]:
                return 0

        elif mid == len(arr)-1:
            if arr[mid-1] < arr[mid]:
                return mid

        if arr[mid] < arr[mid+1]:
            L = mid + 1
        else:
            if arr[mid] > arr[mid-1]:
                return mid
            else:
                R = mid - 1 

    return -1