# 2020.02.17
# Problem Statement:
# https://leetcode.com/problems/surrounded-regions/

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0: return
        
        # idea:
        # set all "O"s that are connected to edge (should not be changed finally) to "N"
        # remain all "O"s that should be flipped as "O"
        # do the change from "N" to "O" and "O" to "X" finally

        # set loop signal to True initially
        Continue = True

        # always loop until no new "N"s are assigned, so that no further influence they will make
        while Continue:
            # set loop signal to False, and reset to True if an "N" is assigned
            Continue = False
            for i in range(0, len(board)):
                for j in range(0, len(board[0])):
                    if board[i][j] == "O":
                        if i == 0 or j == 0 or i ==len(board)-1 or j == len(board[0])-1:
                            board[i][j] = "N"
                            Continue = True
                        else:
                            if i>=1 and board[i-1][j] == "N":
                                board[i][j] = "N"
                                Continue = True
                            elif i<=len(board)-2 and board[i+1][j] == "N":
                                board[i][j] = "N"
                                Continue = True
                            elif j>=1 and board[i][j-1] == "N":
                                board[i][j] = "N"
                                Continue = True
                            elif j<=len(board[0])-2 and board[i][j+1] == "N":
                                board[i][j] = "N"
                                Continue = True
                        
        # final change
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == "N":
                    board[i][j] = "O"
                elif board[i][j] == "O":
                    board[i][j] = "X"
                    