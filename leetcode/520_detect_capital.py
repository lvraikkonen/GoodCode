def detectCapitalUse(word):
    """
    :type word: str
    :rtype: bool
    """
    return word[1:].islower() or word.islower() or word.isupper()