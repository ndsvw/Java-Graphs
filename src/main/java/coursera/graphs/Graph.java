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
		reachedHashSet = dfs_rec(u, explored, reachedHashSet);
		return reachedHashSet;
	}

	protected HashSet<Integer> dfs_rec(int u, boolean[] explored, HashSet<Integer> reachedHashSet) {
		explored[u] = true;
		reachedHashSet.add(u);
		for (int v : adjList.get(u)) {
			if (!explored[v]) {
				dfs_rec(v, explored, reachedHashSet);
			}
		}
		return reachedHashSet;
	}

	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(nodes + " nodes\n");
		for (int u = 0; u < nodes; u++) {
			sBuffer.append(u + " ->");
			for (int v : adjList.get(u)) {
				sBuffer.append(" " + v);
			}
			sBuffer.append("\n");
		}
		return sBuffer.toString();
	}
}
