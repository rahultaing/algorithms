// https://www.youtube.com/watch?v=uzHJXbToiIU&list=PLRdD1c6QbAqJn0606RlOR6T3yUqFWKwmX&index=75

public class DijsktraSP{

    private DirectedEdge[] edgeTo;
    private Double[] distTo;
    private IndexMinPQ<Double> minPq;

    public void DijkstaSP(EdgeWeightedDigraph g){

        edgeTo = new DirectedEdge[g.V()];
        distTo = new Double[g.V()];
        minPq = new IndexMinPQ<>();
    }

    public void compute(EdgeWeightedDigraph g, int s){

        for(int i: g.V()){
            distTo[i] = Double.MAX_VALUE;
        }

        distTo[s] = 0.0;
        minPq.insert(s, 0.0);

        while(!minPq.isEmpty()){
            int v = minPq.delMin();
            for (DirectedEdge e: g.adj(v)){
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e){
        int v = e.from();
        int w = e.to();

        if (distTo[w] > distTo[v] + e.weight()){
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }

        if (minPq.containsKey(w)){
            minPq.decreaseKey(w, distTo[w]);
        }
        else{
            minPq.insert(w, distTo[w]);
        }
    }
}