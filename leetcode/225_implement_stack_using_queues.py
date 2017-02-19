# Queue implementation by list
class MyQueue:
    """
    队列的说明

    一个线性的数据结构
    队列遵循FIFO的原则，First In ， First Out 即先进先出
    队列头部为front，尾部为rear
    """
    def __init__(self):
        self.items = []
    
    def isEmpty(self):
        return self.items == []
    
    def enqueue(self, item):
        self.items.insert(0, item)
    
    def dequeue(self):
        return self.items.pop()
    
    def size(self):
        return len(self.items)

# q = MyQueue()
# q.enqueue("first")
# q.enqueue("second")
# print q.dequeue()
# print q.size()
# print q.isEmpty()
# print q.dequeue()
# print q.isEmpty()


""" 双队列
Version A (efficient push):

push:
enqueue in queue1
pop:
while size of queue1 is bigger than 1, pipe dequeued items from queue1 into queue2
dequeue and return the last item of queue1, then switch the names of queue1 and queue2
=======================================================================================
"""
class MyStack(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q1 = MyQueue()
        # self.q2 = MyQueue()
        

    def push(self, x):
        """
        Push element x onto stack.
        :type x: int
        :rtype: void
        """
        self.q1.enqueue(x)
        

    def pop(self):
        """
        Removes the element on top of the stack and returns that element.
        :rtype: int
        """
        count = self.q1.size()
        while count > 1:
            self.q1.enqueue(self.q1.dequeue())
            count -= 1
        return self.q1.dequeue()
        


    def top(self):
        """
        Get the top element.
        :rtype: int
        """
        count = self.q1.size()
        while count > 1:
            self.q1.enqueue(self.q1.dequeue())
            count -= 1
        top = self.q1.dequeue()
        self.q1.enqueue(top)
        return top
        

    def empty(self):
        """
        Returns whether the stack is empty.
        :rtype: bool
        """
        return self.q1.isEmpty()
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()


"""
Version B (efficient pop):

push:
enqueue in queue2
enqueue all items of queue1 in queue2, then switch the names of queue1 and queue2
pop:
deqeue from queue1
==================================================================================
"""