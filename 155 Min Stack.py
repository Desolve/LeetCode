class MinStack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        curr = self.getMin()
        if curr == None or x < curr:
            curr = x
        self.s.append((x, curr))

    def pop(self):
        """
        :rtype: None
        """
        self.s.pop()

    def top(self):
        """
        :rtype: int
        """
        if len(self.s) == 0:
            return None
        else:
            return self.s[len(self.s) - 1][0]

    def getMin(self):
        """
        :rtype: int
        """
        if len(self.s) == 0:
            return None
        else:
            return self.s[len(self.s) - 1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()