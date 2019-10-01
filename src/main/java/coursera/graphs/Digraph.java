package coursera.graphs;

public class Digraph extends Graph {

	public Digraph(int nodes) {
		super(nodes);
	}

	public void addEdge(int u, int v) throws Exception {
		if (u != v) {
			adjList.get(u).add(v);
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
}
