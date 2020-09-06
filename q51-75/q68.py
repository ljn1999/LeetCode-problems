# 2020.09.06
# Problem Statement:
# https://leetcode.com/problems/text-justification/

class Solution:
    def modified(self, temp, maxWidth, count_char, count_word, count_char_list):
        # check corner case, if only one word
        if count_word == 1:
            temp = temp + " "*(maxWidth-len(temp))
            return temp

        # space amount stores for each space area, how many spaces need to be filled
        space_amount = []
        # space_total represents how many spaces in total need to exist
        space_total = maxWidth - count_char
        # set a and b as temp to do the calculation
        a, b = space_total, count_word

        # complete space_amount
        for i in range(0, count_word-1):
            if a % (b-1) == 0:
                space_amount.append(int(a//(b-1)))
                a = a-int(a//(b-1))
                b = b-1
            else:
                space_amount.append(int(a//(b-1)+1))
                a = a-int(a//(b-1)+1)
                b = b-1
        
        # add spaces into the temp
        index = 0        
        for i in range(0, len(count_char_list)-1):
            index = index + count_char_list[i]
            temp = temp[: index] + " "*space_amount[i] + temp[index+1: ]
            index = index + space_amount[i]
            
        return temp  
        
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        # initialize answer to return and initialize temp
        answer = []
        temp = ""
        # count_char stores for each line, how many chars (except spaces) are in
        # count_word stores for each line, how many words can be in
        # count_char_list stores the word length distribution in each line
        count_char = 0
        count_word = 0
        count_char_list = []

        # do the greedy part, without consider about the spaces (only insert one space for now)
        for i in range(0, len(words)):
            if i == 0:
                temp = words[i]
                count_char = len(words[i])
                count_word = 1
                count_char_list.append(len(words[i]))
            else:
                if len(temp) + len(words[i]) < maxWidth:                
                    temp = temp + " " + words[i]
                    count_char = count_char + len(words[i])
                    count_word = count_word + 1
                    count_char_list.append(len(words[i]))
                
                else:
                    # modify the temp
                    temp = self.modified(temp, maxWidth, count_char, count_word, count_char_list)                    
                    
                    # start a new string
                    answer.append(temp)
                    temp = words[i]

                    # do some reset
                    count_char = len(words[i])
                    count_word = 1
                    count_char_list = []
                    count_char_list.append(len(words[i]))
        
        # deal with the last line
        temp = temp + " "*(maxWidth-len(temp))        
        answer.append(temp)

        return answer