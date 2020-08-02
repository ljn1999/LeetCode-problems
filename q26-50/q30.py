# 2020.08.02
# Problem Statement:
# https://leetcode.com/problems/substring-with-concatenation-of-all-words/

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        # check if s is empty or words is empty
        if len(s) * len(words) == 0: return []
        
        # length is the total length of words
        # word_length is the length per word in words (all the same)
        # word_dict is the hash table to store words and their occurance times
        length = len(words) * len(words[0])
        word_length = len(words[0])
        word_dict = {}
        
        # initialize the occurances to all 0
        for word in words:
            word_dict[word] = 0

        # calculate for occurance times    
        for word in words:
            word_dict[word] = word_dict[word] + 1
        
        # do a deep copy for word_dict
        word_dict_copy = deepcopy(word_dict)

        # initialize answer to return
        answer = []
        
        # start index can be any index between [0, len(s)-length]
        for start in range(0, len(s)-length+1):
            # if this substring is legal
            add = True
            # check all the potential matched words in substring
            for word_index in range(0, len(words)):
                # get the single word
                word = s[start+word_index*word_length: start+(word_index+1)*word_length]
                # not match, this substring should not count
                if word not in word_dict.keys():
                    add = False
                    break
                # match
                else:
                    # check occurance time, should have 1 less occurance time remaining
                    word_dict[word] = word_dict[word] - 1
                    # exceed the occurance times
                    if word_dict[word] < 0:
                        add = False
                        break
            # add the result
            if add:
                answer.append(start)
            # get back the orginal word_dict
            word_dict = deepcopy(word_dict_copy)
            
        return answer