package datastructure;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
    @Getter @Setter
    public ListNode next;
    @Getter @Setter
    public int val;

    public ListNode(int val) {
        this.next = null;
        this.val = val;
    }
}
