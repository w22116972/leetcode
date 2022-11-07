def reverse_linked_list_recursively(current_node):
    # base case: emtpy list or only one node
    if current_node is None or current_node.next is None:
        return current_node

    # reverse next node and return last node as reversed head
    last_node = reverse_linked_list_recursively(current_node.next)
    # current_node -> (reversed result)
    # current_node -> ( null <- current_node.next <- ... <- last_node)
    # 1. make current_node.next point to current_node instead of null
    current_node.next.next = current_node
    # current_node <-> current_node.next <- ...

    # 2. make current_node point to the null
    current_node.next = None
    # null <- current_node <- current_node.next <- ... last_node

    return last_node


def reverse_linked_list_iteratively(current_node):
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
