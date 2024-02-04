class Solution(object):
    def minimumTimeToInitialState(self, word, k):
        if k == len(word):
            return 1
        return self.recur(k, word, 0)
    
    def recur(self, k, originalWord, i):
        ctAtBack = min(len(originalWord), i * k)
        if ctAtBack == len(originalWord) or (i > 0 and originalWord[:len(originalWord) - ctAtBack] == originalWord[ctAtBack:]):
            return 0
        ans = 1 + self.recur(k, originalWord, i+1)
        return ans


        