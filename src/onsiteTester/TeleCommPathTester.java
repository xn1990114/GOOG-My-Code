package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.TeleCommPath;

public class TeleCommPathTester {
	
	/*				
	 * 				8
	 * 				|  \
	 *    0(A)		6  -- 7
	 *    |			|
	 *    1 -- 2 -- 4  -- 5(B)
	 *    			|
	 *    			3
	 *    
	 *    
	 */

	@Test
	public void test1() {
		TeleCommPath tester=new TeleCommPath();
		boolean[][] rails={{false,true ,false,false,false,false,false,false,false},
						   {true ,false,true ,false,false,false,false,false,false},
						   {false,true ,false,false,true ,false,false,false,false},
						   {false,false,false,true ,false,false,false,false,false},
						   {false,false,true ,true ,false,true ,true ,false,false},
						   {false,false,false,false,true ,false,false,false,false},
						   {false,false,false,false,true ,false,false,true ,true },
						   {false,false,false,false,false,false,true ,false,true },
						   {false,false,false,false,false,false,true ,true ,false}};
		boolean[][] tele={{false,false,false,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {false,false,false,false,false,false,true ,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {false,false,true ,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false}};
		assertTrue(!tester.canAvoidCommunication(0, 5, rails, tele, 10));
		assertTrue(tester.canAvoidCommunication(0, 5, rails, tele, 3));
		assertTrue(tester.canAvoidCommunication(0, 5, rails, tele, 4));
		assertTrue(!tester.canAvoidCommunication(0, 5, rails, tele, 5));
	}
	@Test
	public void test2() {
		TeleCommPath tester=new TeleCommPath();
		boolean[][] rails={{false,true ,false,false,false,false,false,false,false},
						   {true ,false,true ,false,false,false,false,false,false},
						   {false,true ,false,false,true ,false,false,false,false},
						   {false,false,false,true ,false,false,false,false,false},
						   {false,false,true ,true ,false,true ,true ,false,false},
						   {false,false,false,false,true ,false,false,false,false},
						   {false,false,false,false,true ,false,false,true ,true },
						   {false,false,false,false,false,false,true ,false,true },
						   {false,false,false,false,false,false,true ,true ,false}};
		boolean[][] tele={{false,false,true,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {true,false,false,false,false,false,true ,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {false,false,true ,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false},
						  {false,false,false,false,false,false,false,false,false}};
		assertTrue(!tester.canAvoidCommunication(5, 0, rails, tele, 10));
		assertTrue(!tester.canAvoidCommunication(5, 0, rails, tele, 3));
		assertTrue(!tester.canAvoidCommunication(5, 0, rails, tele, 4));
	}
}
