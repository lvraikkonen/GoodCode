import java.util.HashSet;
import java.util.Set;

public class leetcode_142_Linked_List_Cycle_II {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode node = head;

        while(node!=null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }
}
