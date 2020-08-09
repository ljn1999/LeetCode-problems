# 2020.08.09
# Problem Statement:
# https://leetcode.com/problems/sudoku-solver/
# Got inspired by a youtube video:
# https://www.youtube.com/watch?v=ucugbKwjtRs

class Solution:
    # help function for filling in numbers
    # x is row index, y is col index
    # rows, cols, and boxes store the current state (which nums are inside) each row/col/box
    def fill(board, x, y, rows, cols, boxes):
        # if reached the 10th row, which means finished, return
        if x == 9: return True

        # calculate next row and column to solve
        next_y = (y+1) % 9
        if y == 8: next_x = x + 1
        else: next_x = x

        # if next (row, col) is already filled in, go to the next directly    
        if board[x][y] != ".": return Solution.fill(board, next_x, next_y, rows, cols, boxes)
        
        # try all possibilities for 1~9
        for i in range(1, 10):
            # calculate box index
            box_idx = int(x//3 * 3 + y//3)

            # if i can be possibly taken for this position
            # (no duplication for that row, col and box)
            if (((x, i) not in rows.keys() or rows[(x, i)] == 0) \
                and ((y, i) not in cols.keys() or cols[(y, i)] == 0) \
                and ((box_idx, i) not in boxes.keys() or boxes[(box_idx, i)] == 0)):
                # do update
                rows[(x, i)] = 1
                cols[(y, i)] = 1
                boxes[(box_idx, i)] = 1
                board[x][y] = str(i)
                
                # recursion
                if Solution.fill(board, next_x, next_y, rows, cols, boxes): return True
                
                # reset to 0 (not fitting)
                board[x][y] = "."
                rows[(x, i)] = 0
                cols[(y, i)] = 0
                boxes[(box_idx, i)] = 0
        
        # not fitting, go back to last step
        return False
                
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # build dictionaries for the very initial state
        rows, cols, boxes = {}, {}, {}
        for i in range(0, 9):
            for j in range(0, 9):
                if board[i][j] != ".":
                    rows[(i, int(board[i][j]))] = 1
                    cols[(j, int(board[i][j]))] = 1
                    box_idx = int(i//3 * 3 + j//3)
                    boxes[(box_idx, int(board[i][j]))] = 1                    

        # call fill function, with first postion (0, 0)            
        Solution.fill(board, 0, 0, rows, cols, boxes)
        
        
            