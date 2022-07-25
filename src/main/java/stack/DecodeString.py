def decodeString(s: str) -> str:
    num = '01234567890'
    stack = []
    for i in s:
        if i != "]":
            stack.append(i)
        else:
            x = ""

