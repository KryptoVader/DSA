def reconstructQueue(people):
    people.sort(key = lambda x: (x[0], -x[1]), reverse = True)
    ans = []

    for person in people:
        ans.insert(person[1], person)
    return ans