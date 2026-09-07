def insertion(arr):
    for i in range(len(arr)):
        j = i
        ele = arr[i]
        while j > 0 and arr[j-1] > ele:
            arr[j] = arr[j-1]
            j -= 1
        arr[j] = ele  
    return arr

print(insertion([3,2,5,6,1,4]))