class HouseRobberII:
    def rob(self, nums: list):
        n = len(nums)
        if n == 1:
            return nums[0]
