import datastructure.ListNode;

import java.util.Stack;

public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            while (!stack.isEmpty() && stack.peek().val < currentNode.val) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().next = currentNode;
            }

            stack.push(currentNode);
            currentNode = currentNode.next;
        }
        // Stack is empty only if input head is null
        return stack.isEmpty() ? null : stack.get(0);
    }
}
