# 2020.09.08
# Problem Statement:
# https://leetcode.com/problems/simplify-path/

class Solution:
    def simplifyPath(self, path: str) -> str:
        # check empty case
        if len(path) == 0: return ""
        
        # make sure the path ends with a final "/", making it easier for later operation
        path = path + "/"
        
        # remove multiple "/"s
        while "//" in path:
            path = path.replace("//", "/")
        
        # initialize answer to return, and store the postions of slash
        answer = ""
        slash_idx = []

        # loop to find all positions of slash
        for i in range(0, len(path)):
            if path[i] == "/":
                slash_idx.append(i)

        # create the answer        
        for i in range(0, len(slash_idx)-1):
            # does not matter
            if path[slash_idx[i]: slash_idx[i+1]] == "/.":
                pass
            
            elif path[slash_idx[i]: slash_idx[i+1]] == "/..":
                # illegal
                if i == 0:
                    pass
                else:
                    # can not move more up
                    if len(answer) == 0:
                        pass
                    else:
                        # remove the last part until "/"
                        for j in range(0, len(answer)):
                            if answer[len(answer)-1-j] == "/":
                                answer = answer[: len(answer)-1-j]
                                break
            else:
                # add into the answer
                answer = answer + path[slash_idx[i]: slash_idx[i+1]]
        
        # make sure all non-empty inputs have a non-empty return
        if len(answer) == 0: return "/"
        else: return answer
            