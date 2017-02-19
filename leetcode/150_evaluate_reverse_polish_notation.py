class Solution:
    # @param tokens, a list of string
    # @return an integer
    def evalRPN(self, tokens):
        stack = []
        result = 0
        for token in tokens:
            if (token in '+-*/'):
                result = self.calculate(token, int(stack.pop()), int(stack.pop()))
                stack.append(result)
            else:
                stack.append(int(token))
        return stack.pop()
    
    def calculate(self, token, n, m):
        if token.__eq__('+'):
            return n + m
        elif token.__eq__('-'):
            return m - n
        elif token.__eq__('*'):
            return n * m
        elif token.__eq__('/'):
            return int(float(m) / float(n))