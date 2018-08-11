package com.algorithms.graphs;

/*
* https://www.youtube.com/watch?v=H0bkmI1Xsxg&index=4&list=PLe-ggMe31CTexoNYnMhbHaWhQ0dvcy43t
* */
public class UnionFind {

    private int[] id;

    public UnionFind(int n){

        this.id = new int[n];

        for (int i=0; i<n; i++){
            this.id[i] = i;
        }
    }

    public void union(int u, int v){
        int rootU = this.root(u);
        int rootV = this.root(v);

        this.id[rootU] = rootV;
    }

    public boolean connected(int u, int v){
        return this.root(u) == this.root(v);
    }

    private int root(int i){

        while (id[i] != i){
            i = id[i];
        }

        return id[i];
    }
}
