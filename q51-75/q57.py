# 2020.08.24
# Problem Statement:
# https://leetcode.com/problems/insert-interval/

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # check corner cases
        if len(intervals) == 0: return [newInterval]

        # can duplicate with several intervals,
        # initialize start and end index with duplication as -1 and -1.
        combine_1, combine_2 = -1, -1

        # if the left of current <= right of another,
        # and the right of current >= left of another,
        # then the current should be merged with "another"

        # find the start
        for j in range(0, len(intervals)):                
            if newInterval[0] <= intervals[j][1] and newInterval[1] >= intervals[j][0]:
                combine_1 = j
                break

        # find the end
        for j in range(0, len(intervals)):                
            if newInterval[0] <= intervals[j][1] and newInterval[1] >= intervals[j][0]:
                combine_2 = j

        # if only need to merge with one,
        # ie: first == second, merge with either:
        if combine_1 != -1 and combine_2 != -1 and combine_1 == combine_2: 
            intervals[combine_1] = [min(intervals[combine_1][0], newInterval[0]), \
                                    max(intervals[combine_1][1], newInterval[1])]

        # if need to merge with all:
        if combine_1 != -1 and combine_2 != -1 and combine_1 != combine_2:
            intervals[combine_1] = [min(intervals[combine_1][0], newInterval[0]), \
                                    max(intervals[combine_2][1], newInterval[1])]

            # remove the rest intervals
            for i in range(combine_1+1, combine_2+1):
                intervals.remove(intervals[combine_1+1])

        # if no need to merge at all, count as a new interval:
        # have to find the suitable place to insert!
        if combine_1 == -1 and combine_2 == -1:
            if newInterval[0] < intervals[0][0]:
                intervals = [newInterval] + intervals
            elif newInterval[0] > intervals[-1][0]:
                intervals = intervals + [newInterval]
            else:
                position = -1
                for i in range(0, len(intervals)-1):
                    if intervals[i][0] < newInterval[0] \
                    and intervals[i+1][0] > newInterval[0]:
                        position = i
                        break
                intervals = intervals[:position+1] + [newInterval] + intervals[position+1:]
            
        return intervals