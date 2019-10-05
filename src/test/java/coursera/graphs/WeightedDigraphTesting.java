package coursera.graphs;

import static org.junit.Assert.*;

import org.junit.Test;

import coursera.graphs.WeightedDigraph.NodeCostPair;

public class WeightedDigraphTesting {

	@Test(expected = Exception.class)
	public void test1() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(2);
		graph.addEdge(0, 1);
	}

	@Test
	public void test2() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(3);
		graph.addEdge(0, 1, 1);
		graph.addEdge(1, 2, 2);
		assertTrue(graph.getAdjNodesOf(0).size() == 1);
		assertTrue(graph.getAdjNodesOf(1).size() == 1);
		assertTrue(graph.getAdjNodesOf(2).size() == 0);
	}

	@Test
	public void test3() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(3);
		graph.addEdge(0, 1, 1);
		graph.addEdge(1, 2, 2);
		assertTrue(graph.getAdjNodesAndCostsOf(0).size() == 1);
		NodeCostPair pair1 = graph.getAdjNodesAndCostsOf(0).iterator().next();
		assertTrue(pair1.getNode() == 1);
		assertTrue(pair1.getCost() == 1);
		assertTrue(graph.getAdjNodesAndCostsOf(1).size() == 1);
		NodeCostPair pair2 = graph.getAdjNodesAndCostsOf(1).iterator().next();
		assertTrue(pair2.getNode() == 2);
		assertTrue(pair2.getCost() == 2);
		assertTrue(graph.getAdjNodesAndCostsOf(2).size() == 0);
	}

	@Test
	public void test4() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(3);
		graph.addEdge(0, 1, 1);
		graph.addEdge(1, 2, 2);
		graph = graph.reverse();
		assertTrue(graph.getAdjNodesAndCostsOf(0).size() == 0);
		NodeCostPair pair = graph.getAdjNodesAndCostsOf(1).iterator().next();
		assertTrue(pair.getNode() == 0);
		assertTrue(pair.getCost() == 1);
		NodeCostPair pair2 = graph.getAdjNodesAndCostsOf(2).iterator().next();
		assertTrue(pair2.getNode() == 1);
		assertTrue(pair2.getCost() == 2);
		assertTrue(graph.getAdjNodesAndCostsOf(0).size() == 0);
	}

}
