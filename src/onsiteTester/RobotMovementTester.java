package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RobotMovement;

public class RobotMovementTester {

	@Test
	public void test() {
		RobotMovement tester=new RobotMovement();
		int[] r1=tester.move("FF2R3F");
		assertTrue(r1[0]==0&&r1[1]==-1);
		int[] r2=tester.move("FFR3FFF40R2F3RF");
		assertTrue(r2[0]==7&&r2[1]==3);
	}

}
