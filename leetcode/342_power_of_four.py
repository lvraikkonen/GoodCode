def isPowerOfFour(num):
    """
    :type num: int
    :rtype: bool
    """
    return num > 0 and num & (num - 1) == 0 and num & 0x55555555 > 0

# 循环法
def isPowerOfFour(num):
    if num <= 0:
        return False
    while num & 4 == 0:
        num /= 4
    return num == 1

