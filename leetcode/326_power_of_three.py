# 循环法
def isPowerOfThree(n):
    """
    :type n: int
    :rtype: bool
    """
    if n <= 0:
        return False
    while n%3 == 0:
        n /= 3
    return n == 1

# 递归法
def isPowerOfThree(n):
    """
    :type n: int
    :rtype: bool
    """
    if n <= 0:
        return False
    if n == 1:
        return True
    if n%3 == 0:
        return isPowerOfThree(n/3)
    return False

# 数学法
def isPowerOfThree(n):
    return False if n <= 0 else n == pow(3, round(math.log(n, 3)))