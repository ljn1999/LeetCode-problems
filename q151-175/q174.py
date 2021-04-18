# 2021.04.18
# Problem Statement:
# https://leetcode.com/problems/dungeon-game/
import numpy as np

class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        # dp
        # all elements in the dp_structure would store the min health it should have,
        # before entering that cell
        dp_structure = np.zeros((len(dungeon), len(dungeon[0])))
        
        for i in range(0, max(len(dungeon), len(dungeon[0]))):
            # do divide and conquer (?)
            # start from the right-bottom cell, say (i, j), fill in its horizontal and vertical lines
            # then move to the cell which is (i-1, j-1), until all is finished

            # horizontal
            row = len(dungeon)-1-i
            if row >= 0:
                for j in reversed(range(0, len(dungeon[0])-i)):
                    # check if it's the right-bottom cell
                    if j == len(dungeon[0])-1:
                        # have to have at least 1 health
                        dp_structure[row][j] = max(1, 1-dungeon[-1][-1])
                    else:
                        # check if it's the most-bottom row
                        if row == len(dungeon)-1:
                            down = inf
                        else:
                            down = dp_structure[row+1][j]
                        # have to have at least 1 health
                        dp_structure[row][j] = max(min(dp_structure[row][j+1], down) - dungeon[row][j], 1)
            else: # all finished
                return int(dp_structure[0][0])

            # vertical
            col = len(dungeon[0])-1-i
            if col >= 0:
                # do not need to repeat the "center" cell
                for k in reversed(range(0, len(dungeon)-i-1)):
                    # check if it's the most-right col
                    if col == len(dungeon[0])-1:
                        right = inf
                    else:
                        right = dp_structure[k][col+1]
                    # have to have at least 1 health
                    dp_structure[k][col] = max(min(right, dp_structure[k+1][col]) - dungeon[k][col], 1)
            else: # all finished
                return int(dp_structure[0][0])

        #print(dp_structure)
        return int(dp_structure[0][0])
                