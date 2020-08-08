# 2020.08.08
# Problem Statement:
# https://leetcode.com/problems/valid-sudoku/

class Solution:
    # help function
    # return if a list has duplication (invalid)
    def isDuplicate(input_list):
        for element in input_list:
            if element != "." and input_list.count(element) > 1:
                return True
        return False
    
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        # check rows
        for i in range(0, 9):
            if Solution.isDuplicate(board[i]):
                return False
            
        # check columns
        # create a new board to store columns in original board as rows
        temp_board = []
        temp_list = []
        for i in range(0, 9):
            for j in range(0, 9):
                temp_list.append(board[j][i])            
            temp_board.append(temp_list)
            temp_list = []
        # check valid
        for i in range(0, 9):
            if Solution.isDuplicate(temp_board[i]):
                return False   
            
        # check 3*3 boxes
        # create a new board to store 3*3 boxes in original board as rows
        temp_board = []
        for i in range(0, 3):
            for j in range(0, 3):
                for x in range(3*i, 3*i+3):
                    for y in range(3*j, 3*j+3):
                        temp_list.append(board[x][y])
                temp_board.append(temp_list)
                temp_list = []
        # check valid        
        for i in range(0, 9):
            if Solution.isDuplicate(temp_board[i]):
                return False 
                
        return True