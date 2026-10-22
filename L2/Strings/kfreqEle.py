def remove(heap, freq):
    heap[0], heap[-1] = heap[-1], heap[0]
    heap.pop()

    if len(heap) == 0:
        return heap

    i = 0
    while 2*i + 1< len(heap):
        left = 2*i + 1
        right  = 2*i + 2
        index = left

        if right < len(heap):
            if freq[heap[right]] < freq[heap[left]]:
                index = right

        if freq[heap[i]] > freq[heap[index]]:
            heap[i], heap[index] = heap[index], heap[i]
            i = index

        else:
            break

    return heap

def kfreqEle(arr, k):
    freq = {}
    for ele in arr:
        freq[ele] = freq.get(ele, 0) + 1

    key = list(freq.keys())
    for i in range(len(key) // 2 - 1, -1, -1):
        curr = i
        while (2*curr + 1 < len(key)):
            left = 2*curr + 1
            right  = 2*curr + 2
            index = None
    
            if right >= len(key):
                index = left
            elif freq[key[left]] <= freq[key[right]]:
                index = left
            else:
                index = right
    
            if freq[key[curr]] > freq[key[index]]:
                key[curr], key[index] = key[index], key[curr]
                curr = index

            else:
                break

    for i in range(len(key) - k):
        key = remove(key, freq)   
    
    return key
