package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.MaxConinuousLengthString;

public class MaxConinuousLengthStringTester {

	@Test
	public void test() {
		MaxConinuousLengthString tester=new MaxConinuousLengthString();
		String[] strs1={"a","ab","acb","tabc","tabqc", "tabpqc"};
		tester.display(tester.findLastStringNoSequenceChange(strs1));
		tester.display(tester.findLastStringWithSequenceChange(strs1));
		String[] strs2={"","adcd","a","a","b","d","c","asd","ab","acb","tabc","ad","adc","adsc","adcd","addd"};
		tester.display(tester.findLastStringNoSequenceChange(strs2));
		tester.display(tester.findLastStringWithSequenceChange(strs2));
	}

}
