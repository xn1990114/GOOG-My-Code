package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ExpireHashMap;

public class ExpireHashMapTester {

	@Test
	public void test() {
		ExpireHashMap<String,String> emap=new ExpireHashMap<String,String>(2);
		emap.put("1", "first", 1);
		emap.put("2", "second", 2);
		assertTrue(emap.valueMap.size()==2);
		assertTrue(emap.get("2", 2).equals("second"));
		emap.put("3", "thrid", 3);
		emap.put("4", "fourth", 4);
		assertTrue(emap.get("2", 5)==null);
		emap.put("5", "fifth", 5);
		assertTrue(emap.valueMap.size()==3);
		assertTrue(emap.get("5", 5).equals("fifth"));
		emap.put("4", "last", 6);
		assertTrue(emap.valueMap.size()==2);
		assertTrue(emap.get("2", 6)==null);
		assertTrue(emap.get("5", 8)==null);
		assertTrue(emap.get("4", 8).equals("last"));
	}

}
