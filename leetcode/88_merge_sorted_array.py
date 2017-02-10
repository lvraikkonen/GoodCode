# @param A  a list of integers
# @param m  an integer, length of A
# @param B  a list of integers
# @param n  an integer, length of B
# @return nothing

# 从后向前把两个有序列表元素一一放入，A列表原地处理
# assume array A is big enough
def merge(A, m, B, n):
    i, j, k = m - 1, n - 1, m + n - 1
    while i >= 0 and j >= 0:
        if B[j] > A[i]:
            A[k] = B[j]
            j -= 1
        else:
            A[k] = A[i]
            i -= 1
        k -= 1
    while j >= 0:
        A[k] = B[j]
        j -= 1
        k -= 1

if __name__ == "__main__":
    result = merge([1, 1, 2, 2, 4, 0, 0, 0, 0], 5, [0, 0, 2, 3], 4)
    print result