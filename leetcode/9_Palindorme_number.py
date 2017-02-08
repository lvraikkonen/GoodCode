def isPalindrom(x):
    if x < 0:
        return False
    if x == 0:
        return True
    if x % 10 == 0:
        return False
    
    rev = 0
    tmp = x
    # refer to 7_reverse_integer
    while tmp != 0:
        rev = 10 * rev + tmp % 10
        tmp /= 10
    print rev, x
    return rev == x

print isPalindrom(586)
print isPalindrom(585)