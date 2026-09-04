class LinkedList:
    class __Node:
        def __init__(self, data, next = None):
            self.__data = data
            self.__next = next
            
        def setNext(self, next):
            self.__next = next
            
        def getNext(self):
            return self.__next
        
        def getData(self):
            return self.__data
        
    def __init__(self, data = None):
        node = LinkedList.__Node(data) if data != None else None
        self.__head = node
        self.__tail = node
        if(self.__head == None):
            self.__ele = 0
        else:
            self.__ele = 1
            
    def addAtHead(self, data):
        node = LinkedList.__Node(data)
        if(self.__head == None):
            self.__head = node
            self.__tail = node
        else:
            node.setNext(self.__head)
            self.__head = node
        self.__ele += 1
        
    def addAtTail(self, data):
        node = LinkedList.__Node(data)
        if(self.__head == None):
            self.__head = node
            self.__tail = node
        else:
            self.__tail.setNext(node)
            self.__tail = node
        self.__ele += 1
        
    def addAt(self, index, data):
        if(index < 0 or index > self.__ele):
            raise IndexError("Invalid Index")
        
        if(index == 0):
            self.addAtHead(data)
        elif(index == self.__ele - 1):
            self.addAtTail(data)
        else:
            node = LinkedList.__Node(data)
            ptr = self.__head
            i = 0
            while(ptr != None and i < index-1):
                ptr = ptr.getNext()
                i +=1
            node.setNext(ptr.getNext())
            ptr.setNext(node)
            self.__ele += 1
            
    def removeFromHead(self):
        if(self.isEmpty()):
            raise Exception("Linked List is Empty")
        
        data = self.__head.getData()
        self.__head = self.__head.getNext()
        self.__ele -=1
        return data
    
    def removeFromTail(self):
        if(self.isEmpty()):
            raise Exception("Linked List is Empty")
        
        ptr = self.__head
        while(ptr.getNext() != self.__tail):
            ptr = ptr.getNext()
            
        data = self.__tail.getData()
        self.__tail = ptr
        self.__tail.setNext(None)
        self.__ele -=1
        return data
    
    def removeAt(self, index):
        if(index < 0 or index > self.__ele):
            raise IndexError("Invalid Index")
        
        if(index == 0):
            return self.removeFromHead()
        elif(index == self.__ele - 1):
            return self.removeFromTail
        else:
            slow = self.__head
            fast = self.__head.getNext()
            i = 0
            while(i < index - 1 and fast != None):
                slow = slow.getNext()
                fast = fast.getNext()
                i += 1
                
            slow.setNext(fast.getNext())
            self.__ele -=1
            return fast.getData()
        
    def reverse(self):
        if(self.isEmpty() or self.__head.getNext() == None): return self
        
        curr = self.__head
        prev = None
        self.__tail = self.__head
        while(curr != None):
            next = curr.getNext()
            curr.setNext(prev)
            prev = curr
            curr = next
            
        self.__head = prev
        self.__tail.setNext(None)
            
    def __len__(self):
        return self.__ele
    
    def isEmpty(self):
        return self.__ele == 0
    
    def first(self):
        return None if self.isEmpty() else self.__head.getData()
    
    def last(self):
        return None if self.isEmpty() else self.__tail.getData()
    
    def __str__(self):
        if self.isEmpty():
            return '[]'
        string = "["
        ptr = self.__head
        while (ptr != None):
            string += str(ptr.getData())
            if(ptr.getNext() != None):
                string += ', '
            ptr = ptr.getNext()
        string += "]"
        return string
     
        
ll = LinkedList(10)
for i in range(20,60,10):
    ll.addAtTail(i)
print("After Adding all the elements", ll, sep='\n')
ll.addAt(2,25)
print("After Adding an element at a particular Index", ll, sep='\n')     
ll.removeFromHead()
print("After Removing Head", ll, sep='\n')
ll.removeFromTail()
print("After Removing Tail", ll, sep='\n')
ll.removeAt(1)
print("After Removing an element at a particular Index",ll, sep='\n')
print("Printing the length of Linked List using len() function", len(ll), sep='\n')
ll.reverse()
print("After reversing the LinkedList", ll, sep='\n')