import java.util.HashMap;
import java.util.Queue;

public class UndirectedGraphNode{

    public int label;

    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int label){

        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}


public class Solution{

    public UndirectedGraphNode clone(UndirectedGraphNode node){

        if (node == null){
            return null;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        map.put(node, new UndirectedGraphNode(node.label));

        queue.add(node);

        while (!queue.isEmpty()){

            UndirectedGraphNode n = queue.poll();

            for (UndirectedGraphNode neighbor: n.neighbors){
                
                if (map.containsKey(neighbor)){

                    UndirectedGraphNode neighborCopy = map.get(neighbor);
                    UndirectedGraphNode nodeCopy = map.get(n);
                    nodeCopy.neighbors.add(neighborCopy);
                }
                else{
    
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    UndirectedGraphNode nodeCopy = map.get(n);
                    nodeCopy.neighbors.add(neighborCopy);
                    map.put(neighbor, neighborCopy);
                    queue.add(neighbor);
                }        
            }

            return map.get(node);
        }
    }
}