def wiggleMaxLength(nums):
    prev, curr, count = -1, -1, 0

    for i in range(1, len(nums)):
        diff = nums[i] - nums[i-1]
        if diff > 0:
            curr = 1
        elif diff < 0:
            curr = 0
        else:
            continue

        if prev != curr:
            count += 1
        prev = curr

    return count + 1