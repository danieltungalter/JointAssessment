package JointAssessment;

import java.util.Scanner;

public class JointAssessment {
	
	 public static void main(String args[])
	 {
	 System.out.println("Please enter husband's income: ");
	 Scanner x = new Scanner(System.in);
	 int husband = x.nextInt(); 
	 
	 System.out.println("Please enter wife's income: ");
	 Scanner y = new Scanner(System.in);
	 int wife = y.nextInt(); 
	 
	 System.out.println("Husband net total income is : " + NetTotalIncome(husband) );
	 System.out.println("Wife net total income is : " + NetTotalIncome(wife) );
	 System.out.println("Husband net chargeable income is : " + NetChargeableIncome(husband) );
	 System.out.println("Wife net chargeable income is : " + NetChargeableIncome(wife) );
	 System.out.println("The tax of husband is : " + Tax(NetChargeableIncome(husband)) );
	 System.out.println("The tax of wife is : " + Tax(NetChargeableIncome(wife)) );
	 System.out.println("The tax payable of husband is : " + TaxPayable(NetChargeableIncome(husband)) );
	 System.out.println("The tax payable of wife is : " + TaxPayable(NetChargeableIncome(wife)) );
	 System.out.println("The tax payable of both husband and wife are : " + (TaxPayable(NetChargeableIncome(husband))+TaxPayable(NetChargeableIncome(wife))) );
	 System.out.println();
	 System.out.println("The total net income is : " + TotalIncome(husband,wife) );
	 System.out.println("The total net chargeable income is : " + TotalNetChargeableIncome(husband,wife) );
	 System.out.println("The join tax is : " + Tax(TotalNetChargeableIncome(husband,wife)));
	 System.out.println("The join payable tax is : " + TaxPayable(TotalNetChargeableIncome(husband,wife)));
	 System.out.println();
	 if (TaxPayable(TotalNetChargeableIncome(husband,wife)) < (TaxPayable(NetChargeableIncome(husband))+TaxPayable(NetChargeableIncome(wife))))
		 System.out.println("Joint Assessment Recommended : Yes" );
	 else
		 System.out.println("Joint Assessment Recommended : No" );
	 }
	 
	 public static double NetTotalIncome(double income)
	 {return Math.round((income - Math.min(income * 0.05, 15000))*100.0)/100.0;}
	 
	 public static double NetChargeableIncome(double income)
	 {return Math.max(NetTotalIncome(income)-132000, 0);}
	 
	 public static double Tax(double income)
	 {
		 double tax = 0;
		 if (income < 45000) {
			tax = (income * 0.02);
		 }
		 else if (income > 45000 && income < 90000) {
			tax = (45000 * 0.02 + (income-45000) * 0.07);
		 }
		 else if (income > 90000 && income < 135000) {
			tax = (45000 * 0.02 + 45000 * 0.07 + (income-90000) * 0.12);
		 }
		 else if (income > 135000) {
			tax = (45000 * 0.02 + 45000 * 0.07 + 45000 * 0.12 + (income-135000) * 0.17);
		 }
		 tax = Math.round(tax*100.0)/100.0;
		return tax;
	 }
	 
	 public static double TaxPayable(double income)
	 {
		double TaxPayable = Math.max(Tax(income), 0);
		return TaxPayable-(Math.min(TaxPayable * 0.75, 20000));
	 }
	 
	 public static double TotalIncome(double husband, double wife)
	 {
		return Math.max(NetTotalIncome(husband) + NetTotalIncome(wife), 0);
	 }
	 
	 public static double TotalNetChargeableIncome(double husband, double wife)
	 {
		return Math.max(TotalIncome(husband,wife) - 264000, 0);
	 }
}
