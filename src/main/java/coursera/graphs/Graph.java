package coursera.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	protected int nodes = 0;
	protected List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();

	public Graph(int nodes) {
		this.nodes = nodes;
		for (int i = 0; i < nodes; i++) {
			adjList.add(new HashSet<Integer>());
		}
	}

	public void addEdge(int u, int v) throws Exception {
		if (u != v) {
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		} else {
			throw new Exception("An edge from a node to itself is not allowed");
		}
	}

	public Set<Integer> getAdjNodesOf(int u) {
		return adjList.get(u);
	}

	public Set<Integer> dfs(int u) {
		boolean[] explored = new boolean[nodes];
		for (int i = 0; i < explored.length; i++) {
			explored[i] = false;
		}
		HashSet<Integer> reachedHashSet = new HashSet<Integer>();
		dfs_rec(u, explored);
		for (int i = 0; i < explored.length; i++) {
			if (explored[i]) {
				reachedHashSet.add(i);
			}
		}
		return reachedHashSet;
	}

	private boolean[] dfs_rec(int u, boolean[] explored) {
		explored[u] = true;
		for (int v : adjList.get(u)) {
			if (!explored[v]) {
				dfs_rec(v, explored);
			}
		}
		return explored;
	}
}
