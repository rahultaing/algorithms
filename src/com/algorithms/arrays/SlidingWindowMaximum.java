/*https://leetcode.com/problems/sliding-window-maximum/solution/ */

class Solution {

    ArrayDeque<Integer> deque = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<k; i++){
            this.remove_invalid(nums, i, k);
            this.deque.addLast(i);
        }

        list.add(nums[this.deque.getFirst()]);

        for (int i=k; i<nums.length; i++){
            this.remove_invalid(nums, i, k);
            this.deque.addLast(i);
            list.add(nums[this.deque.getFirst()]);
        }

        int[] ar = new int[list.size()];
        return list.toArray(ar);
    }

    private void remove_invalid(int[] nums, int i, int k){

        if (this.deque.length > k-1){
            this.deque.removefirst();
        }

        while (this.deque.size() > 0 && nums[this.deque.getLast()] < nums[i]){
            this.deque.removeLast();
        }
    }
}