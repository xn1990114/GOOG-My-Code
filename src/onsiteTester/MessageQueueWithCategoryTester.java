package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MessageQueueWithCategory;

public class MessageQueueWithCategoryTester {

	@Test
	public void test() {
		MessageQueueWithCategory qu=new MessageQueueWithCategory();
		assertTrue(qu.pollAllType()==null);
		assertTrue(qu.pollType("Audio")==null);
		assertTrue(qu.pollType("Text")==null);
		AudioMessage am1=new AudioMessage("Audio 1");
		AudioMessage am2=new AudioMessage("Audio 2");
		AudioMessage am3=new AudioMessage("Audio 3");
		AudioMessage am4=new AudioMessage("Audio 4");
		TextMessage tm1=new TextMessage("Text 1");
		TextMessage tm2=new TextMessage("Text 2");
		TextMessage tm3=new TextMessage("Text 3");
		TextMessage tm4=new TextMessage("Text 4");
		qu.offer(am1);
		qu.offer(am2);
		assertTrue(qu.pollAllType()==am1);
		assertTrue(qu.pollType("Text")==null);
		assertTrue(qu.pollType("Audio")==am2);
		qu.offer(tm1);qu.offer(am1);qu.offer(am2);qu.offer(am3);
		qu.offer(tm2);qu.offer(tm3);qu.offer(tm4);qu.offer(am4);
		assertTrue(qu.pollType("Audio")==am1);
		assertTrue(qu.pollAllType()==tm1);
		assertTrue(qu.pollType("Text")==tm2);
		
		assertTrue(qu.pollType("Audio")==am2);
		assertTrue(qu.pollType("Audio")==am3);
		assertTrue(qu.pollAllType()==tm3);
		
		assertTrue(qu.pollType("Audio")==am4);
		assertTrue(qu.pollAllType()==tm4);
		
	}

}
