// https://leetcode.com/problems/meeting-rooms-ii/solution/
/**
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1


Algorithm

Sort the given meetings by their start time.
Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
If not, then we allocate a new room and add it to the heap.
After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
 */
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