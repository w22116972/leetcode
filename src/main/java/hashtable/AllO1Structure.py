# https://leetcode.com/problems/all-oone-data-structure/discuss/91428/Python-solution-with-detailed-comments
class AllOne_TODO:

    def __init__(self):
        self.linked_list = DoubleLinkedList()
        self.key_to_count = {}
        self.count_to_bucket = {}


    def inc(self, key: str) -> None:
        if key not in self.key_to_count:
            self.key_to_count[key] = 0
        old_count = self.key_to_count[key]
        self.key_to_count[key] += 1
        new_count = self.key_to_count[key]
        # if there is no bucket for this count, we need to insert a new bucket
        if new_count not in self.count_to_bucket:
            # TODO
            self.count_to_bucket[new_count] = None




    def dec(self, key: str) -> None:
        pass


    def getMaxKey(self) -> str:
        return self.linked_list.get_tail().get_any_key() if self.linked_list.get_tail().get_count() > 0 else ""

    def getMinKey(self) -> str:
        return self.linked_list.get_head().get_any_key() if self.linked_list.get_head().get_count() > 0 else ""


# keys in same bucket will have same frequency
class Bucket:
    def __init__(self):
        self.key_set = set()
        self.prev_bucket = None
        self.next_bucket = None

    def add_key(self, key):
        self.key_set.add(key)

    def get_any_key(self):
        any_key = self.key_set.pop()
        self.key_set.add(any_key)
        return any_key

    def get_count(self):
        return len(self.key_set)

class DoubleLinkedList:
    def __init__(self):
        self.dummy_head = Bucket()
        self.dummy_tail = Bucket()
        self.dummy_head.next_bucket = self.dummy_tail
        self.dummy_tail.prev_bucket = self.dummy_head





    def get_head(self):
        return self.dummy_head.next_bucket

    def get_tail(self):
        return self.dummy_tail.prev_bucket
