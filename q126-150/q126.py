# 2020.02.13
# Problem Statement:
# https://leetcode.com/problems/word-ladder-ii/
# Looked up the solution here, basically did a copy and paste:
# https://leetcode.com/problems/word-ladder-ii/discuss/40482/Python-simple-BFS-layer-by-layer

class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if endWord not in wordList: return []
        
        # BFS
        # level[word] would store all possible transform path, from the beginWord to the current word "word" in wordSet
        wordSet = set(wordList)
        level = {}
        level[beginWord] = [[beginWord]]
        
        while len(level) != 0:
            newLevel = collections.defaultdict(list)
            
            # see where the the current keys in level can go
            for word in level:
                # reach the end, return the answer
                if word == endWord:
                    return level[word]
                # try out all possibilities and see if it's legal (in the wordSet)
                for i in range(0, len(word)):
                    for char in "abcdefghijklmnopqrstuvwxyz":
                        newWord = word[:i] + char + word[i+1:]
                        if newWord in wordSet:
                            for j in level[word]:
                                newLevel[newWord] = newLevel[newWord] + [j + [newWord]]

            # remove already used words        
            wordSet = wordSet - set(newLevel.keys())
            # update level
            level = newLevel
        
        return []