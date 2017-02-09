# @param a list of integers
# @return an integer
def removeDuplicates(A):
    if len(A)==0:
        return 0
    i, j=0, 1
    for j in range(i, len(A)):
        if A[i] != A[j]:
            i += 1
            A[i]=A[j]
    return i + 1

if __name__ == "__main__":
    result = removeDuplicates([1,1,2,3,3])
    print result