public class leetcode_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {

    public int getDecimalValue(ListNode head) {
        int decimal = head.val;
        while(head.next != null){
            head = head.next;
            decimal *=2;
            decimal += head.val;
        }
        return decimal;
    }
}
