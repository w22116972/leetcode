from linkedlist.ListNode import ListNode


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # base case: empty list
        if head is None:
            return []
        # find the middle node of list
        middle_node = self.find_middle_node(head)
        # middle node is at 1st half, and its next node is at 2nd half
        first_2nd_half_node = middle_node.next
        middle_node.next = None

        # reverse 2nd half and return head of reversed 2nd half
        reversed_2nd_half_head = self.reverse_list(first_2nd_half_node)

        # merge 1st half and 2nd half
        self.merge_two_lists(head, reversed_2nd_half_head)


    def find_middle_node(self, head):
        middle_node = head
        helper_middle_node = head
        while helper_middle_node.next and helper_middle_node.next.next:
            middle_node = middle_node.next
            helper_middle_node = helper_middle_node.next.next
        return middle_node

    def reverse_list(self, current_node):
        prev_node = None
        while current_node:  # is not None
            # 暫時儲存當前的.next → 之後反轉完後要用來繼續往下走
            next_node = current_node.next
            # prev <- current 進行反轉把current指向prev
            # 每一趟只處理一個反轉，也就是只把current指向prev，而next指向current的會留到下一輪
            current_node.next = prev_node
            # 把prev跟current一起右移
            prev_node = current_node
            current_node = next_node
        # ... <- prev , null(current)
        return prev_node


    def merge_two_lists(self, list1, list2):
        dummy_node = ListNode(None, None)
        current_node = dummy_node

        while list1 is not None:
            current_node.next = list1
            current_node = current_node.next
            list1 = list1.next
            if list2 is not None:
                current_node.next = list2
                current_node = current_node.next
                list2 = list2.next

        return dummy_node.next


if __name__ == '__main__':
    s = Solution()
    node6 = ListNode(6)
    node5 = ListNode(5, node6)
    node4 = ListNode(4, node5)
    node3 = ListNode(3, node4)
    node2 = ListNode(2, node3)
    node1 = ListNode(1, node2)
    middle_node = s.find_middle_node(node1)
    last_half_node = middle_node.next
    middle_node.next = None
    reversed_head = s.reverse_list(last_half_node)


    # reversed_head = s.reverse_list(s.find_middle_node(node1).next)
    # print(s.find_middle_node(node1).val)

    current_node = reversed_head
    while current_node is not None:
        print(current_node.val)
        current_node = current_node.next
