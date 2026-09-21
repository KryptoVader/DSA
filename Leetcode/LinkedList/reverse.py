class Solution:
    def reverseList(self, head):
        slow = None
        fast = head

        while fast is not None:
            ptr = fast
            fast = fast.next
            ptr.next = slow
            slow = ptr
        return slow