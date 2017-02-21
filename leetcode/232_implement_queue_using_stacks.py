# Stack implementation by list
class MyStack:
    """
    栈的说明

    栈是一个线性的数据结构
    栈遵循LIFO的原则，Last In First Out , 即后进先出
    栈顶为top，栈底为base
    """
    def __init__(self):
        self.items = []
    
    def isEmpty(self):
        return self.items == []
    
    def push(self, item):
        self.items.append(item)
    
    def pop(self):
        return self.items.pop()
    
    def peek(self):
        return self.items[-1]
    
    def size(self):
        return len(self.items)

# s = MyStack()
# print s.isEmpty()
# s.push(1)
# s.push(2)
# print s.peek()
# print s.pop()
# print s.size()
        

# implement queue using python deque
from collections import deque

class MyQueue1(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = deque()
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: void
        """
        tmp_stack = deque()

        for i in range(len(self.stack)):
            tmp_stack.append(self.stack.pop())
        
        self.stack.append(x)

        for i in range(len(tmp_stack)):
            self.stack.append(tmp_stack.pop())
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        return self.stack.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        return self.stack[-1]
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return len(self.stack) == 0


if __name__ == "__main__":
    # Your MyQueue object will be instantiated and called as such:
    obj = MyQueue1()
    obj.push(0)
    obj.push(1)
    obj.push(2)
    param_2 = obj.pop()
    param_3 = obj.peek()
    param_4 = obj.empty()