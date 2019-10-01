package coursera.graphs;

import static org.junit.Assert.*;

import org.junit.Test;

public class DfsTesting {

	@Test
	public void test1() throws Exception {
		Graph graph = new Graph(3);
		assertTrue(graph.dfs(0).contains(0));
		assertTrue(graph.dfs(0).size() == 1);
		assertTrue(graph.dfs(1).contains(1));
		assertTrue(graph.dfs(1).size() == 1);
		assertTrue(graph.dfs(2).contains(2));
		assertTrue(graph.dfs(2).size() == 1);
	}

	@Test
	public void test2() throws Exception {
		Graph graph = new Graph(3);
		graph.addEdge(0, 1);
		assertTrue(graph.dfs(0).contains(0) && graph.dfs(0).contains(1));
		assertTrue(graph.dfs(0).size() == 2);
		assertTrue(graph.dfs(1).contains(1) && graph.dfs(1).contains(0));
		assertTrue(graph.dfs(1).size() == 2);
		assertTrue(graph.dfs(2).contains(2));
		assertTrue(graph.dfs(2).size() == 1);
	}

	@Test
	public void test3() throws Exception {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		assertTrue(graph.dfs(0).size() == 5);

	}

}
