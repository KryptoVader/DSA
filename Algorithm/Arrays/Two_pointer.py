def tp(arr, target):
    L, R = 0, len(arr)-1

    while(L < R):
        if(arr[L] + arr[R] == target):
            return True
        elif (arr[L] + arr[R] < target):
            L += 1
        else:
            R -= 1

    L, R  = 0, 1
    while R < len(arr) and L < R:
        if(arr[R] - arr[L]) == target:
            return True
        elif arr[R] - arr[L] > target:
            L+= 1
        else:
            R+= 1
            if L == R:
                R += 1
    return False
print(tp([1, 2, 10], 8))