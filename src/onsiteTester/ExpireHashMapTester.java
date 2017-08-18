package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.ExpireHashMap;

public class ExpireHashMapTester {

	@Test
	public void test() {
		ExpireHashMap<String,String> emap=new ExpireHashMap<String,String>();
		emap.put("1", "first", 1);
		emap.put("2", "second", 2);
		emap.put("3", "thrid", 3);
		emap.put("4", "fourth", 4);
		emap.put("5", "fifth", 5);
		assertTrue(emap.valueMap.size()==5);
		assertTrue(emap.get("2", 1).equals("second"));
		assertTrue(emap.get("2", 4)==null);
		assertTrue(emap.valueMap.size()==2);
		emap.put("4", "last", 6);
		assertTrue(emap.valueMap.size()==2);
		assertTrue(emap.get("2", 4)==null);
		assertTrue(emap.get("5", 5).equals("fifth"));
		assertTrue(emap.get("5", 6)==null);
		assertTrue(emap.get("4", 6).equals("last"));
	}

}
