# two pointer solution
def isPalindrome(self, s):
    i, j = 0, len(s) - 1
    while i < j:
        # only char and digit left
        while i < j and not (s[i].isdigit() or s[i].isalpha()):
            i += 1
        while i < j and not (s[j].isdigit() or s[j].isalpha()):
            j -= 1
        if s[i].lower() != s[j].lower():
            return False
        i, j = i+1, j-1
    return True