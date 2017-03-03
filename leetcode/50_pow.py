def pow(x, n):
    if n < 0:
        return 1.0 / pow(x, -n)
    elif n == 0:
        return 1.0
    else:
        if n % 2 == 0:
            return pow(x, n//2) ** 2
        else:
            return x * pow(x, n//2) ** 2

if __name__ == "__main__":
    result = pow(2, 6)
    print result