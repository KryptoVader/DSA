def bubble(arr):
    for i in range(len(arr)):
        flag = False
        for j in range(len(arr)-i-1):
            if arr[j] > arr[j+1]:
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
                flag = True
        if not flag:
            return arr 

    return arr 

print(bubble([5,1,2,4,3]))  