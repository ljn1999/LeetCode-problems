# 2020.09.17
# Problem Statement:
# https://leetcode.com/problems/word-search/

class Solution:
    def existHelper(self, board, word, row, col, word_idx):      
        # current cell matches, check the next
        if word[word_idx] == board[row][col]:
            # set visit as true            
            self.board_visited[row][col] = True
            # found the whole word
            if word_idx == len(word)-1: return True            
        # current cell doesn't match, return to the previous
        else:
            word_idx = -1
            return False
        
        # search to the right
        # cannot go right any more
        if col>len(board[0])-2 or self.board_visited[row][col+1]:
            pass
        # can still go right, check the next cell
        else:
            right = self.existHelper(board, word, row, col+1, word_idx+1)
            if right:
                self.board_visited[row][col] = False
                return True
            
        # search to the left
        # cannot go left any more
        if col<1 or self.board_visited[row][col-1]:
            pass
        # can still go left, check the next cell
        else:
            left = self.existHelper(board, word, row, col-1, word_idx+1)
            if left:
                self.board_visited[row][col] = False
                return True

        # search to the top
        # cannot go top any more
        if row<1 or self.board_visited[row-1][col]:
            pass
        # can still go top, check the next cell
        else:
            top = self.existHelper(board, word, row-1, col, word_idx+1)
            if top:
                self.board_visited[row][col] = False
                return True

        # search to the bottom
        # cannot go bottom any more
        if row>len(board)-2 or self.board_visited[row+1][col]:
            pass
        # can still go bottom, check the next cell
        else:
            bottom = self.existHelper(board, word, row+1, col, word_idx+1)
            if bottom:
                self.board_visited[row][col] = False
                return True

        # this cell does not work, go back to the previous one
        self.board_visited[row][col] = False
        return False

        
    def exist(self, board: List[List[str]], word: str) -> bool:
        # initialize the board_visited which represented which cells are already visited
        self.board_visited = deepcopy(board)
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):        
                self.board_visited[i][j] = False
        
        # check each cell as the start point
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if self.existHelper(board, word, i, j, 0):
                    return True
        
        return False