# 2021.04.11
# Problem Statement:
# https://leetcode.com/problems/compare-version-numbers/

class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        list_version1 = version1.split(".")
        list_version2 = version2.split(".")
        
        # check the version number indices where exist in both
        for i in range(0, min(len(list_version1), len(list_version2))):
            if int(list_version1[i]) > int(list_version2[i]):
                return 1
            elif int(list_version1[i]) < int(list_version2[i]):
                return -1
        
        # check the rest portion
        if len(list_version1) > len(list_version2):
            for i in range(len(list_version2), len(list_version1)):
                if int(list_version1[i]) != 0:
                    return 1
            return 0     
        elif len(list_version1) < len(list_version2):
            for i in range(len(list_version1), len(list_version2)):
                if int(list_version2[i]) != 0:
                    return -1
            return 0       
        else:
            return 0