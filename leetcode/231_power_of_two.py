# 循环
def is_power_two(num):
    if num <= 0:
        return False
    while num%2 == 0:
        n /= 2
    return n == 1

# 2的整数次幂对应的二进制数只含有0个或者1个1
# 或者，该数字与该数字-1二进制与操作，结果应该为0
def is_power_two(num):
    return num > 0 and (num & (num-1) == 0)