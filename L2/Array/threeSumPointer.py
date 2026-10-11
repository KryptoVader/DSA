def threeSumPointer(arr):
    res = []
    arr = sorted(arr)
    i = 0
    while i < len(arr) - 1:
        left = i + 1
        right = len(arr) - 1
        while left < right:
            s = arr[i] + arr[left] + arr[right]
    
            if s == 0:
                res.append([arr[i], arr[left], arr[right]])
                curr_l = arr[left]
                curr_r = arr[right]

                while left < len(arr) and arr[left] == curr_l:
                    left += 1

                while right > 0 and arr[right] == curr_r:
                    right -= 1
            elif s < 0:
                left += 1
            else:
                right -= 1

        curr = arr[i]
        while i < len(arr) and arr[i] == curr:
            i += 1

    return res