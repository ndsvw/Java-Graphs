package coursera.graphs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DijkstraTesting {

	@Test
	public void test1() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(3);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 2);
		ArrayList<Integer> solution = graph.dijkstra(0);
		assertTrue(solution.get(0) == 0);
		assertTrue(solution.get(1) == 1);
		assertTrue(solution.get(2) == 2);
	}
	
	@Test
	public void test2() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(3);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 2);
		ArrayList<Integer> solution = graph.dijkstra(2);
		assertTrue(solution.get(0) == null);
		assertTrue(solution.get(1) == null);
		assertTrue(solution.get(2) == 0);
	}
	
	@Test
	public void test3() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(4);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 5);
		graph.addEdge(2, 3, 1);
		ArrayList<Integer> solution = graph.dijkstra(0);
		assertTrue(solution.get(0) == 0);
		assertTrue(solution.get(1) == 1);
		assertTrue(solution.get(2) == 3);
		assertTrue(solution.get(3) == 4);
	}
	
	@Test
	public void test4() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(4);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 5);
		graph.addEdge(2, 3, 1);
		ArrayList<Integer> solution = graph.dijkstra(1);
		assertTrue(solution.get(0) == null);
		assertTrue(solution.get(1) == 0);
		assertTrue(solution.get(2) == 2);
		assertTrue(solution.get(3) == 3);
	}
	
	@Test
	public void test5() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(4);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 5);
		graph.addEdge(2, 3, 1);
		ArrayList<Integer> solution = graph.dijkstra(2);
		assertTrue(solution.get(0) == null);
		assertTrue(solution.get(1) == null);
		assertTrue(solution.get(2) == 0);
		assertTrue(solution.get(3) == 1);
	}
	
	@Test
	public void test6() throws Exception {
		WeightedDigraph graph = new WeightedDigraph(4);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 4);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 5);
		graph.addEdge(2, 3, 1);
		ArrayList<Integer> solution = graph.dijkstra(3);
		assertTrue(solution.get(0) == null);
		assertTrue(solution.get(1) == null);
		assertTrue(solution.get(2) == null);
		assertTrue(solution.get(3) == 0);
	}

}
