from typing import Optional

import ListNode


class Solution:
    def mergeTwoListsIteratively(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy_node = ListNode(None, None)

        current_node = dummy_node

        while list1 is not None and list2 is not None:
            if list1.val < list2.val:
                current_node.next = list1
                list1 = list1.next
            else:
                current_node.next = list2
                list2 = list2.next
            current_node = current_node.next
        if list1 is not None:
            current_node.next = list1
        if list2 is not None:
            current_node.next = list2
        return dummy_node.next


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
