def numRescueBoat(people, limit):
    people.sort(reverse = True)
    left, right = 0, len(people) - 1
    boat = 0

    while left <= right:
        if people[left] + people[right] <= limit:
            right -= 1
        left += 1
        boat += 1
    return boat