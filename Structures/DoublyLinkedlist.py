class DoublyLinkedList:
    class __Node:
        def __init__(self, data, prev = None, next = None):
            self.__data = data
            self.__prev = prev
            self.__next = next
        
        def getData(self):
            return self.__data
        
        def getNext(self):
            return self.__next
        
        def getPrev(self):
            return self.__prev
        
        def setData(self,data):
            self.__data = data
            
        def setNext(self,next):
            self.__next = next
            
        def setPrev(self, prev):
            self.__prev = prev
            
    def __init__(self, data):
        if(data == None):
            raise Exception("Invalid Data")
        
        self.__head = DoublyLinkedList.__Node(None)
        self.__tail = DoublyLinkedList.__Node(None)
        node = DoublyLinkedList.__Node(data, self.__head, self.__tail)
        self.__head.setNext(node)
        self.__tail.setPrev(node)
        self.__size = 1
        
    def __len__(self):
        return self.__size
    
    def addFirst(self, data):
        node = DoublyLinkedList.__Node(data, self.__head, self.__head.getNext())
        self.__head.getNext().setPrev(node)
        self.__head.setNext(node)
        self.__size += 1
        
    def addLast(self, data):
        node = DoublyLinkedList.__Node(data, self.__tail.getPrev(), self.__tail)
        self.__tail.getPrev().setNext(node)
        self.__tail.setPrev(node)
        self.__size += 1
        
    def addAt(self, index ,data):
        if(index < 0 or index >= self.__size):
            raise Exception("Invalid Index")
        
        if(index == 0):
            self.addFirst(data)
            
        elif (index == self.__size-1):
            self.addLast(data)
            
        else:
            ptr = self.__head.getNext()
            i = 0
            while(i < index-1):
                i += 1
                ptr = ptr.getNext()
                
            node = DoublyLinkedList.__Node(data, ptr, ptr.getNext())
            ptr.getNext().setPrev(node)
            ptr.setNext(node)
            self.__size += 1
            
    def removeFirst(self):
        data = self.__head.getNext().getData()
        self.__head.getNext().getNext().setPrev(self.__head)
        self.__head.setNext(self.__head.getNext().getNext())
        self.__size -= 1
        return data
    
    def removeLast(self):
        data = self.__tail.getPrev().getData()
        self.__tail.getPrev().getPrev().setNext(self.__tail)
        self.__tail.setPrev(self.__tail.getPrev().getPrev())
        self.__size -= 1
        return data
    
    def removeAt(self, index):
        if(index < 0 or index >= self.__size):
            raise Exception("Invalid Index")
        
        if(index == 0):
            self.removeFirst()
            
        elif (index == self.__size-1):
            self.removeLast()
            
        else:
            slow = self.__head.getNext()
            fast = self.__head.getNext().getNext()
            i = 0
            while(i < index - 1):
                slow = slow.getNext()
                fast = fast.getNext()
            slow.setNext(fast.getNext())
            fast.getNext().setPrev(slow)
            self.__size -= 1
            return fast.getData()
            
        
    def __str__(self):
        st = "[ "
        node = self.__head.getNext()
        while(node != self.__tail):
            st += str(node.getData())
            if(node.getNext() != self.__tail):
                st += ', '
            node = node.getNext()
        st += " ]"
        return st
    
    
dll = DoublyLinkedList(10)
for i in range(20, 60, 10):
    dll.addLast(i)
dll.addAt(2, 25)    
print(dll)
print(dll.removeFirst(), dll)
print(dll.removeLast(), dll)
print(dll.removeAt(1), dll)