package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.RepeatStringMatch;

public class RepeatStringMatchTester {

	@Test
	public void test() {
		RepeatStringMatch tester=new RepeatStringMatch();
		assertTrue(tester.countRepeat("abcd", "cdabcdab")==3);
		assertTrue(tester.countRepeat("abcd", "cdabcdabc")==3);
		assertTrue(tester.countRepeat("abcd", "cdabcd")==2);
		assertTrue(tester.countRepeat("aba", "aabaa")==3);
		assertTrue(tester.countRepeat("aba", "aabaab")==3);
		assertTrue(tester.countRepeat("aba", "baab")==2);
		assertTrue(tester.countRepeat("aabaa", "baab")==2);
		assertTrue(tester.countRepeat("acbac", "cbac")==1);
	}

}
