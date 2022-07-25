from typing import List


class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        # build adjacent list
        manager_to_employees = {}
        for i in range(len(manager)):
            if i != headID:
                if manager[i] not in manager_to_employees:
                    manager_to_employees[manager[i]] = []
                manager_to_employees[manager[i]].append(i)
        return self.dfs(headID, informTime, manager_to_employees)

    def dfs(self, current_id: int, informTime: List[int], manager_to_employees: {int: List[int]}) -> int:
        if informTime[current_id] == 0:
            return 0
        max_minute = 0
        for sub_id in manager_to_employees[current_id]:
            max_minute = max(max_minute, self.dfs(sub_id, informTime, manager_to_employees))
        return max_minute + informTime[current_id]
