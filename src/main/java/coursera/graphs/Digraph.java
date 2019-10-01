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

}
