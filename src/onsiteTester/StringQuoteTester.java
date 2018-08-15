package onsiteTester;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import onsite.StringQuote;
import onsite.StringQuote.Quote;

public class StringQuoteTester {

	@Test
	public void test() {
		StringQuote tester=new StringQuote();
		String[] strs={"w1 w2, w3 w4 w5! w6 w7 w8.w9,w10,w11,w12,w13",
					   "w3,w2 w1! w3,w5,w6 w7 w8 w9 w10 w11 w12 w13",
				       "w1 w2 w3,w2 w1! w3,w5,w6 w7 w8 w9 w10 w11 w12"
		};
		List<List<Quote>> res=tester.findQuotes(strs);
		for(int i=0;i<res.size();i++){
			List<Quote> curr=res.get(i);
			for(Quote q:curr){
				System.out.print(q.toString()+"\t");
			}
			System.out.println();
		}
	}

}
