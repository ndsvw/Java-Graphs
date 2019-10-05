package coursera.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class WeightedDigraph extends Digraph {

	public class NodeCostPair {
		private int node;
		private Integer cost;

		public NodeCostPair(int node, Integer cost) {
			this.node = node;
			this.cost = cost;
		}

		public int getNode() {
			return node;
		}

		public Integer getCost() {
			return cost;
		}
	}

	public class NodeCostPairComparator implements Comparator<NodeCostPair> {
		public int compare(NodeCostPair pair1, NodeCostPair pair2) {
			if (pair1.getCost() != null && pair2.getCost() == null)
				return -1;
			if (pair1.getCost() == null && pair2.getCost() != null)
				return 1;
			if (pair1.getCost() == null && pair2.getCost() == null)
				return 0;
			if (pair1.getCost() < pair2.getCost())
				return -1;
			if (pair1.getCost() > pair2.getCost())
				return 1;
			return 0;
		}
	}

	protected List<Set<NodeCostPair>> adjList = new ArrayList<Set<NodeCostPair>>();

	public WeightedDigraph(int nodes) {
		super(nodes);
		for (int i = 0; i < nodes; i++) {
			adjList.add(new HashSet<NodeCostPair>());
		}
	}

	@Override
	public void addEdge(int u, int v) throws Exception {
		throw new Exception("Edges must have costs in weighted Digraphs");
	}

	public void addEdge(int u, int v, int c) throws Exception {
		super.addEdge(u, v);
		if (u != v) {
			if (u < nodes && v < nodes) {
				adjList.get(u).add(new NodeCostPair(v, c));
			} else {
				throw new Exception("Trying to connect nodes that don't exist");
			}
		} else {
			throw new Exception("An edge from a node to itself is not allowed");
		}
	}

	public Set<NodeCostPair> getAdjNodesAndCostsOf(int u) {
		return adjList.get(u);
	}

	@Override
	public WeightedDigraph reverse() {
		WeightedDigraph revGraph = new WeightedDigraph(nodes);
		for (int u = 0; u < nodes; u++) {
			for (NodeCostPair pair : getAdjNodesAndCostsOf(u)) {
				int v = pair.getNode();
				int c = pair.getCost();
				try {
					revGraph.addEdge(v, u, c);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
		return revGraph;
	}

	public ArrayList<Integer> dijkstra(int s) {
		ArrayList<Integer> costList = new ArrayList<Integer>(nodes);
		for (int i = 0; i < nodes; i++) {
			costList.add(null);
		}
		costList.set(s, 0);

		boolean[] finished = new boolean[nodes];
		Comparator<NodeCostPair> comparator = new NodeCostPairComparator();
		PriorityQueue<NodeCostPair> pQueue = new PriorityQueue<NodeCostPair>(comparator);
		for (int u = 0; u < nodes; u++) {
			pQueue.add(new NodeCostPair(u, null));
		}
		pQueue.add(new NodeCostPair(s, 0));
		while (pQueue.peek() != null) {
			NodeCostPair pair = pQueue.poll();
			int node = pair.getNode();
			if (!finished[node]) {
				finished[node] = true;
				for (NodeCostPair p : adjList.get(node)) {
					if (costList.get(node) != null) {
						if (costList.get(p.getNode()) == null
								|| costList.get(node) + p.getCost() < costList.get(p.getNode())) {
							costList.set(p.getNode(), costList.get(node) + p.getCost());
							pQueue.add(new NodeCostPair(p.getNode(), costList.get(node) + p.getCost()));
						}
					}
				}
			}
		}

		return costList;
	}

}
