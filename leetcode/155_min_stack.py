class MinStack_1:

    def __init__(self):
        self.data = []
        self.min_data = []
    
    def push(self, item):
        self.data.append(item)
        # if min_data has no data or value<current_min then append
        if not self.min_data or item < self.min_data[-1]:
            self.min_data.append(item)
    
    def pop(self):
        if len(self.data) > 0:
            item = self.data.pop()
            if item == self.min_data[-1]:
                self.min_data.pop()
    
    def top(self):
        if not self.data:
            return 0
        return self.data[-1]
    
    def getMin(self):
        if not self.min_data:
            return 0
        return self.min_data[-1]

class MinStack:

    def __init__(self):
        self.data = []
        self.min_data = []
    
    def push(self, item):
        self.data.append(item)
        # if min_data has no data or value<current_min then append
        if not self.min_data or item < min(self.min_data):
            self.min_data.append(item)
    
    def pop(self):
        if not self.data:
            return
        data_top = self.data[len(self.data) - 1]
        min_data_top = self.min_data[len(self.min_data) - 1]
        if data_top == min_data_top:
            self.min_data.pop()
        self.data.pop()
    
    def top(self):
        if not self.data:
            return 0
        return self.data[len(self.data) - 1]
    
    def getMin(self):
        if not self.min_data:
            return 0
        return self.min_data[len(self.min_data) - 1]

minStack = MinStack()
minStack.push(2147483646)
print minStack.data, minStack.min_data
minStack.push(2147483646)
print minStack.data, minStack.min_data
minStack.push(2147483647)
print minStack.data, minStack.min_data
print minStack.getMin()#   --> Returns -3.
print minStack.pop()
print minStack.top()#      --> Returns 0.
print minStack.getMin()#   --> Returns -2.