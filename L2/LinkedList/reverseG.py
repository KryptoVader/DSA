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