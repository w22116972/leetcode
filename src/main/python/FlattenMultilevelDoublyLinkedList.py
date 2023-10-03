class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child

class Solution:

    def flatten_recursively(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return head




    def flatten_stack_iteratively(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return head
        stack = [head]
        prev_node = Node(None, None, None, None)
        while len(stack) > 0:
            current_node = stack.pop()

            # prev <-> current
            prev_node.next = current_node
            current_node.prev = prev_node

            if current_node.next is not None:
                stack.append(current_node.next)
            if current_node.child is not None:
                stack.append(current_node.child)

            prev_node.child = None
            prev_node = current_node
        # since head.prev is dummy node, Node(None, None, None, None)
        head.prev = None
        return head





    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return head
        current_node = head

        while current_node is not None:
            if current_node.child is None:
                current_node = current_node.next
            else:
                tail_node = self.find_tail_node(current_node)
                # tail -> current.next
                tail_node.next = current_node.next
                # tail <- current.next
                if current_node.next is not None:
                    current_node.next.prev = tail_node

                # current -> child
                current_node.next = current_node.child
                # current <- child
                current_node.next.prev = current_node

                current_node.child = None
        return head


    def find_tail_node(self, head):
        tail_node = head.child
        while tail_node.next is not None:
            tail_node = tail_node.next
        return tail_node
if __name__ == '__main__':
    index = 1
    nums = [1, 2, 1]
    print(nums[:index + 1])
