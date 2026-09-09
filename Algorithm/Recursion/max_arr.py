def max_ele(a,b):
    if a >= b:
        return a
    return b

def max_arr(arr, i):
    if i ==len(arr)-1:
        return arr[i]

    return max_ele(arr[i], max_arr(arr, i+1))

print(max_arr([3, 7, 2, 9, 4], 0))