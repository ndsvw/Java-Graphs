package coursera.graphs;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SCCTesting {

	@Test
	public void test1() throws Exception {
		Digraph graph = new Digraph(2);
		graph.addEdge(0, 1);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 2);
	}

	@Test
	public void test2() throws Exception {
		Digraph graph = new Digraph(2);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 1);
	}

	@Test
	public void test3() throws Exception {
		Digraph graph = new Digraph(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 3);
	}

	@Test
	public void test4() throws Exception {
		Digraph graph = new Digraph(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 1);
	}

	@Test
	public void test5() throws Exception {
		Digraph graph = new Digraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 1);
		graph.addEdge(4, 1);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 4);
	}

	@Test
	public void test6() throws Exception {
		Digraph graph = new Digraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 1);
		graph.addEdge(4, 1);
		graph.addEdge(3, 0);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 2);
	}

	@Test
	public void test7() throws Exception {
		Digraph graph = new Digraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 2);
	}

	@Test
	public void test8() throws Exception {
		Digraph graph = new Digraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);
		graph.addEdge(3, 2);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 1);
	}

	@Test
	public void test9() throws Exception {
		Digraph graph = new Digraph(7);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);
		graph.addEdge(6, 1);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 3);
	}

	@Test
	public void test10() throws Exception {
		Digraph graph = new Digraph(9);
		graph.addEdge(0, 6);
		graph.addEdge(6, 3);
		graph.addEdge(3, 0);
		graph.addEdge(6, 8);
		graph.addEdge(8, 5);
		graph.addEdge(5, 2);
		graph.addEdge(2, 8);
		graph.addEdge(5, 7);
		graph.addEdge(7, 1);
		graph.addEdge(1, 4);
		graph.addEdge(4, 7);
		List<Set<Integer>> sccList = graph.calculateSCC();
		assertTrue(sccList.size() == 3);
	}

}
