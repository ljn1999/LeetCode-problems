# 2020.08.21
# Prblem Statement:
# https://leetcode.com/problems/n-queens-ii/

class Solution:

    # the only difference btw q51 and q52 is the meaning of self.answer.
    # in q51 it contains all valid solutions,
    # while in q52 it contains the number of valid solutions.
    # can also simply return len(self.answer) instead of return self.answer finally.

    def back_track(self, i, n):
        # a set of solution is finished
        if i == n:
            self.answer = self.answer + 1
            return
        
        # finish row by row
        for j in range(0, n):
            if j not in self.col and i+j not in self.off_diagonal and j-i not in self.diagonal:
                self.col.add(j)
                self.off_diagonal.add(i+j)
                self.diagonal.add(j-i)
                self.board.append("."*j + "Q" + "."*(n-j-1))
                self.back_track(i+1, n)
                self.board.pop()
                self.off_diagonal.remove(j+i)
                self.diagonal.remove(j-i)
                self.col.remove(j)        
        
    def totalNQueens(self, n: int) -> int:
        self.answer = 0
        self.board = []
        self.col = set()
        self.diagonal = set()
        self.off_diagonal = set()
        
        self.back_track(0, n)
        return self.answer