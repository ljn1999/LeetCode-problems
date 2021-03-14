# 2020.03.14
# Problem Statement:
# https://leetcode.com/problems/candy/
# My own solution was out of time limit, referred to a super smart answer here:
# https://leetcode.com/problems/candy/discuss/42769/A-simple-solution

class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings) == 1: return 1
        
        candy_num = [1] * len(ratings)        
        # one way from left to the right
        for i in range(1, len(ratings)):
            if ratings[i]>ratings[i-1]:
                candy_num[i] = candy_num[i-1]+1
        # one way from right to the left
        for i in reversed(range(1, len(ratings))):
            if ratings[i-1]>ratings[i]:
                # cannot be smaller than before, otherwise the logic with its left neighbor might be broken
                candy_num[i-1] = max(candy_num[i-1], candy_num[i]+1)

        return sum(candy_num)

'''                    
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if len(ratings) == 1: return 1
        
        candy_num = [1]
        decreasing_start = 0
        for i in range(1, len(ratings)):
            if ratings[i]<ratings[i-1]:
                if candy_num[i-1] > 1:
                    candy_num.append(1)
                else:
                    # update all way back, add one for all inside the decreasing trend
                    candy_num.append(1)
                    for idx_to_change in reversed(range(decreasing_start, i)):
                        if candy_num[idx_to_change]-candy_num[idx_to_change+1] >= 1:
                            break
                        candy_num[idx_to_change] = candy_num[idx_to_change]+1
            elif ratings[i] == ratings[i-1]:
                candy_num.append(1)
                decreasing_start = i
            else:
                candy_num.append(candy_num[i-1]+1)
                decreasing_start = i
        
        #print(candy_num)
        return sum(candy_num)
        '''
                    