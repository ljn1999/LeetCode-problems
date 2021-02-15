# 2020.02.14
# Problem Statement:
# https://leetcode.com/problems/word-ladder/

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0
        
        # BFS
        # level[word] would store the length of transform path, from the beginWord to the current word "word" in wordSet
        # have to make wordList a set, otherwise time limit exceed would occur
        wordSet = set(wordList)
        level = {}
        level[beginWord] = 1
        
        while len(level) != 0:
            newLevel = collections.defaultdict(int)
            
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
                            # add the length of path by 1
                            newLevel[newWord] = level[word] + 1

            # remove already used words   
            wordSet = wordSet - newLevel.keys()
            # update level
            level = newLevel
        
        return 0