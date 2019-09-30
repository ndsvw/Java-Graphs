package coursera.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	private int nodes = 0;
	private List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();

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

}
