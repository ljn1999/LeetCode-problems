# 2020.08.20
# Problem Statement:
# https://leetcode.com/problems/n-queens/
# didn't know how to do, so looked up a very brilliant solution in discussion:
# https://leetcode.com/problems/n-queens/discuss/243428/Python-solution

class Solution:
    # unused function
    def isValid(p1, p2):
        if p1[0] == p2[0] or p1[1] == p2[1]: return False
        if abs(p1[0]-p2[0]) == abs(p1[1]-p2[1]): return False
        return True
    
    # unused function again lol
    def validBoard(p, board):
        for i in range(0, n):
            for j in range(0, n):
                if board[i][j] == "Q":
                    if not isValid(p, (i, j)): return False
        return True
        
    def back_track(self, i, n):
        # when a set of solution is finished
        if i == n:
            # have to add list() to make it work, tbh, I don't know why
            self.answer.append(list(self.board))
            return
        
        # finish row by row, so no need to check rows
        for j in range(0, n):
            if j not in self.col and i+j not in self.off_diagonal and j-i not in self.diagonal:
                # make a try
                self.col.add(j)
                self.off_diagonal.add(i+j)
                self.diagonal.add(j-i)
                self.board.append("."*j + "Q" + "."*(n-j-1))
                # fill in the next
                self.back_track(i+1, n)
                # clear up the last trial
                self.board.pop()
                self.off_diagonal.remove(j+i)
                self.diagonal.remove(j-i)
                self.col.remove(j)
                
                            
    def solveNQueens(self, n: int) -> List[List[str]]:
        # data structure to store all answers
        self.answer = []
        # data structure to store one answer
        self.board = []

        # data structure to store if the col/diag/off-diag is already occupied
        self.col = set()
        self.diagonal = set()
        self.off_diagonal = set()
        
        # start from 0 filled in
        self.back_track(0, n)
        return self.answer
        
        
        
