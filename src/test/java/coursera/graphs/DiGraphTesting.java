package coursera.graphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiGraphTesting {

	@Test
	public void test1() throws Exception {
		Digraph graph = new Digraph(2);
		graph.addEdge(0, 1);
		assertTrue(graph.getAdjNodesOf(0).contains(1) && graph.getAdjNodesOf(0).size() == 1);
		assertTrue(graph.getAdjNodesOf(1).isEmpty());
	}
	
	@Test
	public void test2() throws Exception {
		Digraph graph = new Digraph(2);
		graph.addEdge(0, 1);
		Digraph revDigraph = graph.reverse();
		assertTrue(revDigraph.getAdjNodesOf(0).isEmpty());
		assertTrue(revDigraph.getAdjNodesOf(1).contains(0) && revDigraph.getAdjNodesOf(1).size() == 1);
	}
	
	@Test
	public void test3() throws Exception {
		Digraph graph = new Digraph(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		Digraph revDigraph = graph.reverse();
		assertTrue(revDigraph.getAdjNodesOf(0).isEmpty());
		assertTrue(revDigraph.getAdjNodesOf(1).contains(0) && revDigraph.getAdjNodesOf(1).size() == 1);
		assertTrue(revDigraph.getAdjNodesOf(2).contains(1) && revDigraph.getAdjNodesOf(2).size() == 1);
	}

}
