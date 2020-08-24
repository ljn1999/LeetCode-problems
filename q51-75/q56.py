# 2020.08.24
# Problem Statememt:
# https://leetcode.com/problems/merge-intervals/

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # check corner cases
        if len(intervals) <= 1: return intervals
        
        # build a dictionary to finally sort them by decending interval length
        dictionary = {}
        for i in range(0, len(intervals)):
            dictionary[tuple(intervals[i])] = intervals[i][1] - intervals[i][0]
        
        intervals = []
        for w in sorted(dictionary, key=dictionary.get, reverse=True):
            intervals.append(w)

        # initialize answer to return, first possible element would be the longest interval.
        answer = []
        answer.append([intervals[0][0], intervals[0][1]])

        # check from the second until the end
        for i in range(1, len(intervals)):
            # at most duplicate with 2 intervals,
            # initialize index with duplication as -1 and -1.
            combine_1, combine_2 = -1, -1
            
            # if the left of current <= right of another,
            # and the right of current >= left of another,
            # then the current should be merged with "another"
            
            # find the first
            for j in range(0, len(answer)):                
                if intervals[i][0] <= answer[j][1] and intervals[i][1] >= answer[j][0]:
                    combine_1 = j
                    break
            
            # find the second
            for j in range(0, len(answer)):                
                if intervals[i][0] <= answer[j][1] and intervals[i][1] >= answer[j][0]:
                    combine_2 = j
            
            # if only need to merge with one,
            # ie: first == second, merge with either:
            if combine_1 != -1 and combine_2 != -1 and combine_1 == combine_2: 
                answer[combine_1] = [min(answer[combine_1][0], intervals[i][0]), \
                                     max(answer[combine_1][1], intervals[i][1])]
            
            # if need to merge with both:
            if combine_1 != -1 and combine_2 != -1 and combine_1 != combine_2:
                answer[combine_1] = [min(answer[combine_1][0], answer[combine_2][0]), \
                                     max(answer[combine_1][1], answer[combine_2][1])]
                answer.remove(answer[combine_2])
            
            # if no need to merge at all, count as a new interval:
            if combine_1 == -1 and combine_2 == -1:
                answer.append([intervals[i][0], intervals[i][1]])
            
        return answer