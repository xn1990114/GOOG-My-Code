package onsiteTester;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import onsite.MatchMentorAndIntern;
import onsite.MatchMentorAndIntern.Intern;
import onsite.MatchMentorAndIntern.Mentor;

public class MatchMentorAndInternTester {

	@Test
	public void test1() {
		/*
		 * m1 -> i1 i2
		 * m2 -> i3 i4
		 * m3 -> i4
		 * m4 -> i3
		 * 
		 * i1 -> m1 m3
		 * i2 -> m2 m3
		 * i3 -> m1
		 * i4 -> m3
		 */
		MatchMentorAndIntern tester=new MatchMentorAndIntern();
		Mentor m1=tester.new Mentor(1);Mentor m2=tester.new Mentor(2);
		Mentor m3=tester.new Mentor(3);Mentor m4=tester.new Mentor(4);
		Intern i1=tester.new Intern(1);Intern i2=tester.new Intern(2);
		Intern i3=tester.new Intern(3);Intern i4=tester.new Intern(4);
		m1.prefectMatches.add(i1);m1.prefectMatches.add(i2);
		m2.prefectMatches.add(i3);m2.prefectMatches.add(i4);
		m3.prefectMatches.add(i4);m4.prefectMatches.add(i3);
		i1.prefectMatches.add(m1);i1.prefectMatches.add(m3);
		i2.prefectMatches.add(m2);i2.prefectMatches.add(m3);
		i3.prefectMatches.add(m1);i4.prefectMatches.add(m3);
		List<Mentor> mentors=new ArrayList<Mentor>();
		List<Intern> interns=new ArrayList<Intern>();
		mentors.add(m1);mentors.add(m2);mentors.add(m3);mentors.add(m4);
		interns.add(i1);interns.add(i2);interns.add(i3);interns.add(i4);
		System.out.println(tester.rematchWithBackTracking(mentors, interns));
		
		m1.currIntern=i3;m2.currIntern=i4;i4.currMentor=m2;i3.currMentor=m1;
		m4.currIntern=i2;i2.currMentor=m4;
		System.out.println(tester.rematchWithGreedy(mentors, interns));
	}
	@Test
	public void test2() {
		/*
		 * m1 -> i1 i2
		 * m2 -> i3 i4
		 * m3 -> i4
		 * m4 -> i3
		 * 
		 * i1 -> m1 m3
		 * i2 -> m2 m3
		 * i3 -> m1
		 * i4 -> m3
		 */
		MatchMentorAndIntern tester=new MatchMentorAndIntern();
		Mentor m1=tester.new Mentor(1);Mentor m2=tester.new Mentor(2);
		Mentor m3=tester.new Mentor(3);Mentor m4=tester.new Mentor(4);
		Intern i1=tester.new Intern(1);Intern i2=tester.new Intern(2);
		Intern i3=tester.new Intern(3);Intern i4=tester.new Intern(4);
		m1.prefectMatches.add(i1);m1.prefectMatches.add(i2);
		m2.prefectMatches.add(i3);m2.prefectMatches.add(i4);
		m3.prefectMatches.add(i4);m4.prefectMatches.add(i3);
		i1.prefectMatches.add(m1);i1.prefectMatches.add(m3);
		i2.prefectMatches.add(m2);i2.prefectMatches.add(m3);
		i3.prefectMatches.add(m1);i4.prefectMatches.add(m3);
		List<Mentor> mentors=new ArrayList<Mentor>();
		List<Intern> interns=new ArrayList<Intern>();
		mentors.add(m1);mentors.add(m2);mentors.add(m3);mentors.add(m4);
		interns.add(i1);interns.add(i2);interns.add(i3);interns.add(i4);
		
		m1.currIntern=i2;i2.currMentor=m1;m2.currIntern=i4;i4.currMentor=m2;
		m4.currIntern=i1;i1.currMentor=m4;
		System.out.println(tester.rematchWithGreedy(mentors, interns));
	}

}
