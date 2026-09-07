def selection(arr):
    for i in range(len(arr)):
        min_i = i
        for j in range(i+1, len(arr)):
            if arr[min_i] > arr[j]:
                min_i = j
        (arr[i], arr[min_i]) = (arr[min_i], arr[i]) 
    return arr

print(selection([7,1,5,3,8,4]))        