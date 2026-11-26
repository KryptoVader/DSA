from bisect import bisect_left

def lengthOfLIS(nums):
    tails = []

    for num in nums:
        i = bisect_left(tails, num)

        if i == len(tails):
            tails.append(num)
        else:
            tails[i] = num

    return len(tails)