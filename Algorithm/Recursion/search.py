def search(arr, target, i):
    if i == len(arr): 
        return -1

    if (target == arr[i]):
        return i
    
    return search(arr,target,i+1) 

print(search([4, 7, 2, 9, 5], 9, 0))
print(search([4, 7, 2, 9, 5], 5, 0))
print(search([4, 7, 2, 9, 5], 8, 0))