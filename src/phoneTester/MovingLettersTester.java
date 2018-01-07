package phoneTester;

import static org.junit.Assert.*;
import org.junit.Test;
import phone.MovingLetters;

public class MovingLettersTester {

	@Test
	public void test() {
		MovingLetters tester=new MovingLetters();
		String s1="_L_R";
		String t1="L__R";
		assertTrue(tester.canConstruct(s1, t1));
		String s2="_L_R_";
		String t2="L___R";
		assertTrue(tester.canConstruct(s2, t2));
		String s3="_R_L_";
		String t3="_R__L";
		assertTrue(!tester.canConstruct(s3, t3));
		String s4="_RRL___";
		String t4="_R___RL";
		assertTrue(!tester.canConstruct(s4, t4));
		String s5="_RRR___";
		String t5="_R___RL";
		assertTrue(!tester.canConstruct(s5, t5));
		String s6="_RR___L__LRR__";
		String t6="_R___RL_L_R__R";
		assertTrue(tester.canConstruct(s6, t6));
	}

}
