class Node:
    def __init__(self, x):
        self.next = None
        self.data = x

def reverse(head: Node):
    if head is None or head.next is None:
            return head
    
    prev = None
    curr = head

    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt

    return prev

def reorder(head: Node):
    if head is None or head.next is None:
        return head

    slow = head
    fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    second = slow.next
    slow.next = None
    second = reverse(second)
    first = head

    while second:
        nxt = first.next
        first.next = second
        second = second.next
        first.next.next = nxt
        first = nxt

    return head