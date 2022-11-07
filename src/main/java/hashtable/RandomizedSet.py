import random


class RandomizedSet:

    def __init__(self):
        self.val_to_val_index = {}
        self.vals = []  # used to random.choice

    def insert(self, val: int) -> bool:
        if val in self.val_to_val_index:
            return False
        else:
            self.val_to_val_index[val] = len(self.vals)
            self.vals.append(val)
            return True

    def remove(self, val: int) -> bool:
        if val not in self.val_to_val_index:
            return False
        else:
            target_val_index = self.val_to_val_index[val]

            last_val = self.vals[-1]
            self.val_to_val_index[last_val] = target_val_index
            # to remove element in array without moving entire array
            # overwrite target element with last element then pop it from end
            self.vals[target_val_index] = last_val
            self.vals.pop()
            del self.val_to_val_index[val]

            return True

    def getRandom(self) -> int:
        return random.choices(self.vals)[0]


if __name__ == '__main__':
    print(random.choices([1, 0]))

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
