class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        # convert digit into number and filter out space
        for i in s:
            if i != ' ':
                if len(stack) == 0 or self.is_operator(i) or self.is_operator(stack[-1]):
                    stack.append(i)
                else:  # if top and i are both number
                    num = stack.pop()
                    stack.append(num + i)
        print(stack)
        # process *, /
        stack2 = []
        for i in stack:
            if len(stack2) == 0 or self.is_operator(i):
                stack2.append(i)
            elif stack2[-1] == '*':
                stack2.pop()  # pop * operator
                operand = stack2.pop()
                stack2.append(str(int(operand) * int(i)))
            elif stack2[-1] == '/':
                stack2.pop()  # pop / operator
                operand = stack2.pop()
                stack2.append(str(int(int(operand) / int(i))))
            else:  # if top == + or -
                # print(i)
                stack2.append(i)
        print(stack2)
        # process +, -
        stack3 = []
        for i in stack2:
            if len(stack3) == 0 or self.is_operator(i):
                stack3.append(i)
            elif stack3[-1] == '+':
                stack3.pop()
                stack3.append(str(int(stack3.pop()) + int(i)))
            elif stack3[-1] == '-':
                stack3.pop()
                stack3.append(str(int(stack3.pop()) - int(i)))
            else:
                print("no one should be here")
                print(i)
        print(stack3)
        return int(stack3[0])

    # def is_numb'er(self, s: str):
    #     return 's in '0123456789'

    def is_operator(self, s: str):
        return s == '+' or s == '-' or s == '*' or s == '/'
