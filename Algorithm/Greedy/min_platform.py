def minimum_platforms(arrivals, departures):
    arrivals = sorted(arrivals)
    departures = sorted(departures)

    i,j = 0,0
    res = 0
    p = 0
    while(i < len(arrivals) and j < len(departures)):
        if (arrivals[i] < departures[j]):
            p += 1
            res = max(res, p)
            i += 1
            continue
        p -= 1
        j += 1
    return res

arrivals = [900, 940, 950, 1100, 1500, 1800]
departures = [910, 1200, 1120, 1130, 1900, 2000]
print(minimum_platforms(arrivals, departures))