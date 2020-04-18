// https://leetcode.com/problems/meeting-rooms-ii/solution/
import java.util.PriorityQueue;

public class Solution{

    public int maxMeetingRooms(int[][] meetings){

        int n = meetings.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n, new Comparator<Integer>(){ 
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });

        Arrays.sort(meetings, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });

        minHeap.add(meetings[0][1]);

        for (int i=1; i<n; i++){
         
            if (meetings[i][0] >= minHeap.peek()){
                minHeap.poll();
            }

            minHeap.add(meetings[i][1]);
        }

        return minHeap.size();
    }
}