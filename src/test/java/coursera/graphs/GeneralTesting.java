package coursera.graphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeneralTesting {

	@Test
	public void test1() {
		Graph graph = new Graph(3);
		assertTrue(graph.getAdjNodesOf(0).size() == 0);
		assertTrue(graph.getAdjNodesOf(1).size() == 0);
		assertTrue(graph.getAdjNodesOf(2).size() == 0);
	}

	@Test
	public void test2() throws Exception {
		Graph graph = new Graph(3);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		assertTrue(graph.getAdjNodesOf(0).size() == 2);
		assertTrue(graph.getAdjNodesOf(1).size() == 1);
		assertTrue(graph.getAdjNodesOf(2).size() == 1);
	}

	@Test
	public void test3() throws Exception {
		Graph graph = new Graph(3);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		assertTrue(graph.getAdjNodesOf(0).size() == 2);
		assertTrue(graph.getAdjNodesOf(1).size() == 2);
		assertTrue(graph.getAdjNodesOf(2).size() == 2);
	}

	@Test
	public void test4() throws Exception {
		Graph graph = new Graph(2);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		assertTrue(graph.getAdjNodesOf(0).size() == 1);
		assertTrue(graph.getAdjNodesOf(1).size() == 1);
	}

	@Test(expected = Exception.class)
	public void test5() throws Exception {
		Graph graph = new Graph(2);
		graph.addEdge(1, 1);
	}

}
