package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;
import onsite.IndexKeyMap;

public class IndexKeyMapTester {

	@Test
	public void test() {
		IndexKeyMap map=new IndexKeyMap();
		map.push("k0", "v0");
		map.push("k1", "v1");
		map.push("k2", "v2");
		assertTrue(map.size()==3);
		map.push("k2", "v2");
		map.removeByIndex(3);
		map.removeByKey("k3");
		assertTrue(map.size()==3);
		map.removeByKey("k2");
		assertTrue(map.size()==2);
		map.push("k3", "v3");
		assertTrue(map.size()==3);
		map.removeByIndex(1);
		map.removeByIndex(1);
		assertTrue(map.size()==2);
		map.push("k4", "v4");
		map.push("k5", "v5");
		assertTrue(map.size()==4);
		System.out.println(1+""+'a');
	}

}
