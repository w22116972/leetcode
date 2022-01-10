# Nodes for double linked list
class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

# use head and tail as dummy nodes (its next points to both end of double linked list)
# use re-insert to update order
class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {} # key -> Node
        init_node = Node(0, 0)
        self.head = init_node
        self.tail = init_node
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key in self.cache:
            self.remove(self.cache[key])
            self.insertAtTail(self.cache[key])
            return self.cache[key].value
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.remove(self.cache[key])
        self.cache[key] = Node(key, value)
        self.insertAtTail(self.cache[key])
        if len(self.cache) > self.capacity:
            least_recently_used_node = self.head.next
            self.remove(least_recently_used_node)
            del self.cache[least_recently_used_node.key]

    def remove(self, node: Node):
        prev_node = node.prev
        next_node = node.next
        prev_node.next, next_node.prev = next_node, prev_node

    def insertAtTail(self, node: Node):
        prev_node = self.tail.prev
        next_node = self.tail
        prev_node.next = node
        next_node.prev = node












