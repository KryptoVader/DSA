def minSorted(arr):
    L = 0
    R = len(arr) - 1
    ele = arr[L]
    while L <= R:
        mid  = (L + R) // 2

        if arr[L] <= arr[mid]:
            if arr[L] < ele:
                ele = arr[L]

            L = mid + 1
        else:
            if arr[mid] < ele:
                ele = arr[mid]

            R = mid -1

    return ele