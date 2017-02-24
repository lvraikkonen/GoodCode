def convertTo7(num):
    """
    :type num: int
    :rtype: str
    """
    if num == 0:
        return "0"
    n = abs(num)
    result = ""
    while n:
        result += str(n % 7)
        n /= 7
    if num < 0:
        return '-' + result[::-1]
    else:
        return result[::-1]


if __name__ == "__main__":
    result = convertTo7(6)
    print result