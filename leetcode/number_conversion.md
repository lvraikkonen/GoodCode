进制转换
=========


## 二进制转换十进制

## 十进制转换二进制

## 十六进制转换十进制

## 十进制转换十六进制

``` python
def toHex(num):
    result = []
    hex_mapping = '0123456789abcdef'
    if num < 0:
        num += 0x100000000
    while num:
        result.append(hex_mapping[num % 16])
        num /= 16
    return ''.join(result[::-1]) if result else '0'
```

## 十六进制转换二进制

## 二进制转换十六进制