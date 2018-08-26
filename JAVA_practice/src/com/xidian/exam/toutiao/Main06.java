package com.xidian.exam.toutiao;

import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

class Bag{
	private Set<Integer> elements;
	
	public Set<Integer> getElements(){
		return this.elements;
	}
	
	public Bag() {
		this.elements =new TreeSet<Integer>();
	}
	public void add(int e) {
		this.elements.add(e);
	}
}

class Graph{
	private int V;
	private int E;
	private Bag[] adj;
	
	public Graph(int V) {
		this.V = V;
		adj = new Bag[V];
		for(int v=0;v<V;v++) {
			adj[v] = new Bag();
		}
	}
	public int getV() {
		return this.V;
	}
	public Set<Integer> adj(int v) {
		return this.adj[v].getElements();
	}
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
}
class CC{
	private boolean[] marked;
	private int[] id;
	private int count;
	public int getCount() {
		return this.count;
	}
	public CC(Graph G) {
		marked = new boolean[G.getV()];
		id = new int[G.getV()];
		for(int s =0;s<G.getV();s++) {
			if(!marked[s]) {
				dfs(G,s);
				count++;
			}
		}
	}
	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w: G.adj(v)) {
			if(!marked[w])
				dfs(G,w);
		}
	}
}
public class Main06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		int V = Integer.parseInt(n);
		String[] test = new String[V+1];
		test[0] = n;
		for(int i =1;i<V+1;i++) {
			test[i] = sc.nextLine();
		}
		
		
		Graph graph = new Graph(V);
		for(int v=1;v<=V;v++) {
			String temp = test[v];
			String[] pe = temp.split(" ");
			for(String p:pe) {
				int value = Integer.valueOf(p);
				if(value != 0) {
					graph.addEdge(v-1, value-1);
				}
			}
		}
		CC cc = new CC(graph);
		System.out.println(cc.getCount());
	}
}
