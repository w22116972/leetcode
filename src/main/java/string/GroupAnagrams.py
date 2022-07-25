from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        x = {}
        for s in strs:
            t = {}
            for i in s:
                if i not in t:
                    t[i] = 1
                else:
                    t[i] = t[i] + 1
            if t not in x:
                x[t] = [s]
            else:
                x[t].append(s)
        for v in x.values():
            print(v)


Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])