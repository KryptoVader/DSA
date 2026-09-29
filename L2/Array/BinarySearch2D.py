def BinarySearch2D(arr, target):
    L = 0
    R = len(arr) -1 
    mid = 0 
    while L <= R:
        mid = (L + R) // 2
        if arr[mid][0] <= target <= arr[mid][-1]:
            break

        elif arr[mid][-1] < target:
            L  = mid + 1
        elif arr[mid][0] > target:
            R = mid - 1

        else:
            return False

    L = 0
    R = len(arr[mid]) - 1
    while L <= R:
        m = (L + R) // 2
        if arr[mid][m] == target:
            return True

        elif arr[mid][m] < target:
            L = m + 1
        else:
            R = m - 1 

    return False

tests = [
    # Basic
    ([[1, 3, 5, 7],
      [10, 11, 16, 20],
      [23, 30, 34, 60]], 3, True),

    ([[1, 3, 5, 7],
      [10, 11, 16, 20],
      [23, 30, 34, 60]], 13, False),

    # First element
    ([[1, 3, 5, 7],
      [10, 11, 16, 20],
      [23, 30, 34, 60]], 1, True),

    # Last element
    ([[1, 3, 5, 7],
      [10, 11, 16, 20],
      [23, 30, 34, 60]], 60, True),

    # Row boundaries
    ([[1, 3, 5, 7],
      [10, 11, 16, 20],
      [23, 30, 34, 60]], 7, True),

    ([[1, 3, 5, 7],
      [10, 11, 16, 20],
      [23, 30, 34, 60]], 10, True),

    ([[1, 3, 5, 7],
      [10, 11, 16, 20],
      [23, 30, 34, 60]], 22, False),

    # Single row
    ([[1, 2, 3, 4, 5]], 4, True),

    ([[1, 2, 3, 4, 5]], 6, False),

    # Single element
    ([[5]], 5, True),

    ([[5]], 3, False),

    # Target smaller/larger than everything
    ([[10, 20],
      [30, 40]], 1, False),

    ([[10, 20],
      [30, 40]], 50, False),
]

for matrix, target, expected in tests:
    result = BinarySearch2D(matrix, target)

    print(
        f"target={target} -> got={result}, "
        f"expected={expected} "
        f"{'PASS' if result == expected else 'FAIL'}"
    )