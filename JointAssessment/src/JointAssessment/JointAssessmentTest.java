package JointAssessment;

import static org.junit.Assert.*;

import org.junit.Test;

public class JointAssessmentTest {

	@Test
	public void test() {
		JointAssessment tester;
		tester = new JointAssessment();
		 
		System.out.println("Starting test " + new 
		Object(){}.getClass().getEnclosingMethod().getName());
		
		assertEquals(285000, tester.NetTotalIncome(300000),0);
		assertEquals(153000, tester.NetChargeableIncome(300000),0);
		assertEquals(37500, tester.Tax(300000),0);
		assertEquals(17500, tester.TaxPayable(300000),0);
		assertEquals(482600, tester.TotalIncome(300000,208000),0);
		assertEquals(218600, tester.TotalNetChargeableIncome(300000,208000),0);
		
		System.out.println("Ending test " + new 
		Object(){}.getClass().getEnclosingMethod().getName());

	}

}
