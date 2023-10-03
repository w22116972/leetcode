import datastructure.ListNode;

public class ReversedLinkedList {

    public static ListNode iterativeSol(ListNode currentNode) {
        ListNode prevNode = null;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    public ListNode recursiveSol(ListNode currentNode) {
        // base case: emtpy list or only one node
        if (currentNode == null) {
            return currentNode;
        }
        // reverse next node and return last node as reversed head
        ListNode reversedHead = recursiveSol(currentNode.next);
        // current_node -> ( null <- current_node.next <- ... <- last_node)
        // 1. make current_node.next point to current_node instead of null
        currentNode.next.next = currentNode;
        // current_node <-> current_node.next <- ...
        // 2. make current_node point to the null
        currentNode.next = null;
        // null <- current_node <- current_node.next <- ... last_node
        return reversedHead;
    }
}
