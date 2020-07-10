# 2020.07.10

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # initialize answer string
        answer = ""
        
        # check empty input
        if s == "":
            return ""
        
        # calculate how many element are in each group
        # group means patterned element group in shape
        # ex: a     g
        #     b   f h   l
        #     c e   i k
        #     d     j
        # then abcdef is a group
        group_size = numRows * 2 - 2
        
        if group_size == 0:
            return s
        
        # calculate total number of groups
        if len(s) % group_size == 0:
            group_num_total = len(s) // group_size
        else:
            group_num_total = len(s) // group_size + 1

        # for each element, store which group it's in and its position in its group
        group_num = []
        group_index = []
        
        for i in range(0, len(s)):
            group_num.append(i // group_size)
            group_index.append(i % group_size)

        # index should go before group
        # from the first group to the last
        for index in range(0, group_size//2 + 1):
            # from the first index to the middle
            for group in range(0, group_num_total):
                # get the element to store
                for i in range(0, len(s)):
                    if group_num[i] == group and group_index[i] == index:
                        answer = answer + s[i]
                        breaks
                # consider the cases when 2 elements are on the same row
                # store the element as well
                if index != 0 and index != group_size//2:
                    for i in range(0, len(s)):
                        if group_num[i] == group and group_index[i] + index == group_size:
                            answer = answer + s[i]
                            break
        
        return answer