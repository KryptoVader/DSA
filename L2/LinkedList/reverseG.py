class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def reverse_group(head):
    if head  is None:
        return head

    slow = head
    fast = head.next
    prev = None

    while slow and slow.next:
        slow_temp = slow
        fast_temp = fast

        slow = fast.next if fast.next else None
        fast = fast.next.next if slow and fast.next.next else None

        if prev:
            prev.next = fast_temp
        else:
            head = fast_temp
        fast_temp.next = slow_temp  
        slow_temp.next = slow
        prev = slow_temp

    return head

def build_linked_list(values):
    if not values:
        return None

    head = Node(values[0])
    curr = head

    for value in values[1:]:
        curr.next = Node(value)
        curr = curr.next

    return head


def linked_list_to_list(head):
    result = []
    curr = head

    while curr:
        result.append(curr.data)
        curr = curr.next

    return result


test_cases = [
    ([10, 20, 30, 40], [20, 10, 40, 30]),
    ([1, 2, 3, 4, 5], [2, 1, 4, 3, 5]),
    ([1, 2, 3], [2, 1, 3]),
    ([5, 9], [9, 5]),
    ([7], [7]),
    ([], []),
    ([1, 1, 1, 1], [1, 1, 1, 1]),
    ([-5, 0, 8, -2, 6], [0, -5, -2, 8, 6])
]


for i, (values, expected) in enumerate(test_cases, start=1):
    head = build_linked_list(values)

    result_head = reverse_group(head)

    actual = linked_list_to_list(result_head)

    print(f"Test {i}: {'PASS' if actual == expected else 'FAIL'}")
    print(f"Expected: {expected}")
    print(f"Actual:   {actual}")
    print("-" * 40)