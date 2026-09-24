class Node:
    def __init__(self, x):
        self.next = None
        self.data = x

    def getNext(self):
        return self.next

    def setnext(self, next):
        self.next = next

    def getData(self):
        return self.data

def merge_sorted(l1 : Node, l2: Node):
    if l1 == None:
        return l2
    elif l2 == None:
        return l1
    
    head = Node(None)
    ptr = head
    ptr1, ptr2 = l1, l2
    while ptr1 and ptr2:
        if ptr1.getData() <= ptr2.getData():
            if(ptr.getData() == None):
                ptr = ptr1
                head = ptr
                ptr1 = ptr1.getNext()
                continue

            ptr.setnext(ptr1)
            ptr = ptr.getNext()
            ptr1 = ptr1.getNext()

        else:
            if(ptr.getData() == None):
                ptr = ptr1
                head = ptr
                ptr2 = ptr2.getNext()
                continue

            ptr.setnext(ptr2)
            ptr = ptr.getNext()
            ptr2 = ptr2.getNext()

    while ptr1:
        ptr.setnext(ptr1)
        ptr = ptr.getNext()
        ptr1 = ptr1.getNext()

    while ptr2:
        ptr.setnext(ptr2)
        ptr = ptr.getNext()
        ptr2 = ptr2.getNext()

    return head