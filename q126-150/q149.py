# 2020.03.27
# Problem Statement:
# https://leetcode.com/problems/max-points-on-a-line/
# Referred to the solution here:
# https://leetcode.com/problems/max-points-on-a-line/discuss/47113/A-java-solution-with-notes

class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        # do fast returns
        if len(points) == 1 or len(points) == 2: return len(points)
        
        dict = {}
        # global max points
        max_points = 2
        
        for i in range(0, len(points)):
            # clean up dict
            # lines in dict must pass points[i]
            dict = {}
            # update max_temp in each iteration of j
            max_temp = 2
            for j in range(i+1, len(points)):
                # dict[dx] = sub_dict
                # subdict[dy] = current number of points in line passing points[i] and has dy/dx as a slope

                # calculate slope in rational number dy/dx
                dy = points[i][1] - points[j][1]
                dx = points[i][0] - points[j][0]

                # if the line is vertical, treat dx as 0 and dy as inf  
                if dx == 0:
                    dy = inf
                    if dx in dict.keys():
                        dict[dx][inf] = dict[dx][inf] + 1 # update
                    else:
                        dict[dx] = {inf:2} # create
                # if the line is horizontal, treat dx as inf and dy as 0
                elif dy == 0:
                    dx = inf
                    if inf in dict.keys():
                        dict[inf][0] = dict[inf][0] + 1 # update
                    else:
                        dict[inf] = {0:2} # create
                # if the slope is neither 0 nor infs
                else:
                    # check sign, always let dx be positive
                    if dx * dy > 0:
                        neg = False
                    else:
                        neg = True                    
                    gcd = self.calculateGCD(abs(dy), abs(dx))
                    dx = abs(dx)/gcd                    
                    if neg:
                        dy = -abs(dy)/gcd
                    else:
                        dy = abs(dy)/gcd
                    
                    if dx in dict.keys():
                        if dy in dict[dx].keys():
                            dict[dx][dy] = dict[dx][dy] + 1 # update
                        else:
                            dict[dx][dy] = 2 # create
                    else:
                        dict[dx] = {dy:2} # create
                
                max_temp = max(max_temp, dict[dx][dy])
            max_points = max(max_points, max_temp) # compare with global max points
            
        return max_points

    # Approach 1, direct and slow 
    def calculateGCD(self, dy, dx):
        
        gcd = 1
        for i in range(1, min(dy, dx)+1):            
            if dy%i == 0 and dx%i == 0:
                gcd = i
        return gcd

    # Approach 2, much faster, but I don't get how it works
    def calculateGCD(self, dy, dx):
        if dx == 0: return dy
        else: return self.calculateGCD(dx, dy%dx)