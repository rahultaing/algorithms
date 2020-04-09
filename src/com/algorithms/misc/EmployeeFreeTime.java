import java.util.PriorityQueue;

// https://leetcode.com/problems/employee-free-time/discuss/113134/Simple-Java-Sort-Solution-Using-(Priority-Queue)-or-Just-ArrayList

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.start-b.start);
        List<Interval> result = new ArrayList<>();

        schedule.forEach(x -> pq.addAll(x));
        Interval temp = pq.poll();

        while(!pq.isEmpty()){

            if (temp.end<pq.peek().start){
                result.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll();
            }
            else{
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }

        return result;
    }
}