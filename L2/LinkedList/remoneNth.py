def remove_n_th(head, n):
    if head is None:
        return head

    slow = head
    fast = head
    i = 1
    while fast and i < n:
        fast = fast.next
        i += 1

    if fast is None or fast.next is None:
        return head.next

    if i != n:
        return head

    while fast.next:
        slow = slow.next
        fast = fast.next

    slow.next = slow.next.next
    return head