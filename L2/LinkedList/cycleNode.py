class Node:
    def __init__(self, x):
        self.next = None
        self.data = x

def cycleNode(head):
    def cycle(head):
        if head is None or head.next is None:
            return False
        
        slow = head
        fast = head

        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

            if slow is fast:
                return slow


        return False

    meeting = cycle(head)
    if meeting is False:
        return False

    ptr = head
    while ptr is not meeting:
        ptr = ptr.next
        meeting = meeting.next

    return ptr