package lib;

public class TaxFunction {

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        
        validateInput(numberOfMonthWorking, numberOfChildren);

        int netIncome = calculateNetIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible);
        int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);

        int taxableIncome = netIncome - nonTaxableIncome;
        int tax = (int) Math.round(0.05 * taxableIncome);

        return Math.max(tax, 0);
    }

    private static void validateInput(int numberOfMonthWorking, int numberOfChildren) {
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 months working per year");
        }
    }

    private static int calculateNetIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible) {
        return (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking - deductible;
    }

    private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
        int baseNonTaxable = 54000000;
        if (isMarried) {
            baseNonTaxable += 4500000;
        }
        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }
        baseNonTaxable += numberOfChildren * 1500000;
        return baseNonTaxable;
    }
}
