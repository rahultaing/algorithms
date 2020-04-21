public class Solution{

    public ListNode merge(ListNode[] lists){

        int begin = 0;
        int end = lists.length - 1;

        while (end>0){
            lists[begin] = this.mergeList(lists[begin], lists[end]);
            end--;
        }

        return lists[0];
    }

    private ListNode mergeList(ListNode list1, ListNode list2){

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        if (list1==null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }
        
        while (list1!=null && list2!=null){

            if (list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            }
            else{
                prev.next = list2;
                list2 = list2.next;
            }

            prev = prev.next;
        }

        if (list1==null){
            prev.next = list2;
        }

        if (list2 == null){
            prev.next = list1;
        }

        return dummy.next;
    }
}