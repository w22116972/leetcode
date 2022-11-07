from typing import List, Optional

from linkedlist.ListNode import ListNode



class Solution:
    def merge_list_between(self, node_list, left, right):
        if left == right:
            return node_list[left]
        elif left < right:
            mid = int(left + (right - left) / 2)
            prev_half_head = self.merge_list_between(node_list, left, mid)
            next_half_head = self.merge_list_between(node_list, mid + 1, right)
            return self.mergeTwoListsRecursively(prev_half_head, next_half_head)
        else:
            return None

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists is None or len(lists) == 0:
            return None
        return self.merge_list_between(lists, 0, len(lists) - 1)

    def mergeTwoListsRecursively(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        # base case: either list1 or list2 is empty
        if list1 is None:
            return list2
        if list2 is None:
            return list1

        if list1.val < list2.val:
            list1.next = self.mergeTwoListsRecursively(list1.next, list2)
            return list1
        else:
            list2.next = self.mergeTwoListsRecursively(list1, list2.next)
            return list2
