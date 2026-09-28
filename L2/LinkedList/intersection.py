def intersection(head1, head2):
    h1 = head1
    h2 = head2

    ptr1 = head1
    ptr2 = head2

    while ptr1 and ptr2:
        ptr1 = ptr1.next
        ptr2 = ptr2.next

    while ptr1:
        h1 = h1.next
        ptr1 = ptr1.next

    while ptr2:
        h2 = ptr2.next
        ptr2 = ptr2.next

    while h1 and h2:
       if h1 is h2:
           return h1
       else:
           h1 = h1.next
           h2 = h2.next
    return None