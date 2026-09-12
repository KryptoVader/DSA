def two_sum(arr, target):
    hashset = dict()
    for i in range(len(arr)):
        if target - arr[i] in hashset:
            return(hashset[target-arr[i]],i)
        hashset[arr[i]] = i

print(two_sum([2, 7, 11, 15], 9))