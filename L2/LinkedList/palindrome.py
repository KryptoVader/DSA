def reverse(head):
    prev = None
    curr = head

    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt

    return prev


def palindrome(head):
    if head is None or head.next is None:
        return True

    slow = head
    fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    if fast:
        slow = slow.next

    second = reverse(slow)

    first = head
    while second:
        if first.data != second.data:
            return False
        first = first.next
        second = second.next
    return True