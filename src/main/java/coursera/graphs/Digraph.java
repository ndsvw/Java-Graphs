package coursera.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Digraph extends Graph {

	private int scc_counter;

	public Digraph(int nodes) {
		super(nodes);
	}

	public void addEdge(int u, int v) throws Exception {
		if (u != v) {
			if (u < nodes && v < nodes) {
				adjList.get(u).add(v);
			} else {
				throw new Exception("Trying to connect nodes that don't exist");
			}
		} else {
			throw new Exception("An edge from a node to itself is not allowed");
		}
	}

	public Digraph reverse() {
		Digraph revGraph = new Digraph(nodes);
		for (int u = 0; u < nodes; u++) {
			for (int v : getAdjNodesOf(u)) {
				try {
					revGraph.addEdge(v, u);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
		return revGraph;
	}

	public List<Set<Integer>> calculateSCC() {
		// Tarjan's strongly connected components algorithm
		List<Set<Integer>> sccList = new ArrayList<Set<Integer>>();
		int[] order = calculateSCCOrder();

		boolean[] explored = new boolean[nodes];
		for (int i = 0; i < explored.length; i++) {
			explored[i] = false;
		}
		for (int i = nodes - 1; i >= 0; i--) {
			int u = order[i];
			if (!explored[u]) {
				sccList.add(dfs_rec(u, explored, new HashSet<Integer>()));
			}
		}
		return sccList;
	}

	public int[] calculateSCCOrder() {
		scc_counter = 0;
		Digraph revDigraph = this.reverse();
		boolean[] explored = new boolean[nodes];
		int[] order = new int[nodes];
		for (int i = 0; i < explored.length; i++) {
			explored[i] = false;
		}
		for (int u = nodes - 1; u >= 0; u--) {
			if (!explored[u]) {
				revDigraph.modified_dfs_rec(u, explored, order);
			}
		}
		return order;
	}

	private void modified_dfs_rec(int u, boolean[] explored, int[] order) {
		explored[u] = true;
		for (int v : adjList.get(u)) {
			if (!explored[v]) {
				modified_dfs_rec(v, explored, order);
			}
		}
		order[scc_counter++] = u;
	}

}
