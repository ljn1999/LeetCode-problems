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
        # build a dictionary to do the search faster later, where key = (group number, group_index), value = index
        dictionary = {}

        for i in range(0, len(s)):
            dictionary[(i // group_size, i % group_size)] = i

        # index should go before group
        # from the first group to the last
        for index in range(0, group_size//2 + 1):
            # from the first index to the middle
            for group in range(0, group_num_total):
                # get the element to store
                if (group, index) in dictionary.keys():
                    answer = answer + s[dictionary[(group, index)]]
                # consider the cases when 2 elements are on the same row
                # store the element as well
                if index != 0 and index != group_size//2:
                    if (group, group_size-index) in dictionary.keys():
                        answer = answer + s[dictionary[(group, group_size-index)]]
        
        return answer