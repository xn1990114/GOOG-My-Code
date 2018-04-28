package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MeetingRoomSchedule;

public class MeetingRoomScheduleTester {

	@Test
	public void test1() {
		MeetingRoomSchedule tester=new MeetingRoomSchedule();
		int[][] meetings={{1,1,6},{2,3,5}};
		tester.displayRes(tester.sechduleMeeting(meetings));
		System.out.println();
	}
	@Test
	public void test2() {
		MeetingRoomSchedule tester=new MeetingRoomSchedule();
		int[][] meetings={{1,1,6},{2,3,6},{3,0,7},{4,6,7}};
		tester.displayRes(tester.sechduleMeeting(meetings));
		System.out.println();
	}
	@Test
	public void test3() {
		MeetingRoomSchedule tester=new MeetingRoomSchedule();
		int[][] meetings={{1,1,6},{2,3,6},{3,0,7},{4,6,7},{5,5,8},{6,0,2},{7,7,8},{8,7,8}};
		tester.displayRes(tester.sechduleMeeting(meetings));
		System.out.println();
	}
}
