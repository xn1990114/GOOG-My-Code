package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RandomMazeGeneration;

public class RandomMazeGenerationTester {

	@Test
	public void test() {
		RandomMazeGeneration tester=new RandomMazeGeneration();
		tester.printMaze(tester.createMaze(20,25));
	}

}
