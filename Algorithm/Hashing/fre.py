def freq(arr):
    frequency = dict()
    for i in arr:
        if i not in frequency:
            frequency[i] = 1
        else:
            frequency[i] += 1

    return frequency

print(freq([1, 2, 2, 3, 1, 2, 4, 3]))