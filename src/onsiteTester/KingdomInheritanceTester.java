package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.KingdomInheritance;

public class KingdomInheritanceTester {

	@Test
	public void test() {
		KingdomInheritance tester=new KingdomInheritance("King");
		tester.giveBirth("King", "son1");tester.giveBirth("King", "son2");tester.giveBirth("King", "son3");
		tester.giveBirth("King2", "son3");tester.giveBirth("King2", "son1");
		tester.display(tester.getOrder());
		tester.giveBirth("son2", "gson21");
		tester.display(tester.getOrder());
		tester.giveBirth("son2", "gson22");
		tester.death("son1");tester.death("King");
		tester.display(tester.getOrder());
		tester.giveBirth("King", "son4");
		tester.giveBirth("son3", "gson31");
		tester.giveBirth("son3", "gson32");
		tester.giveBirth("son3", "gson33");
		tester.display(tester.getOrder());
		tester.death("son3");tester.death("gson32");
		tester.giveBirth("son4", "gson41");
		tester.display(tester.getOrder());
	}

}
