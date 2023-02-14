package me.sontag.codetest.utils;

/**
 *  A class containing utilities related to math
 */
public class MathUtil {

    // This class shouldn't be instantiated.
    private MathUtil(){}

    /**
     *  Returns a to the power of e
     *  @param a the base
     *  @param e the exponent
     *  @return a to the power of e
     */
    public static double pow(double a, int e) {
        double result = 1;
        for(int i = 0; i < e; i++)
            result *= a;

        return result;
    }

    /**
     *  Method that calculates the monthly payments
     *  @param monthlyInterest The monthly interest% in decimal form
     *  @param totalLoan The total loan in euros
     *  @param payments The number of payment periods as months
     *  @return The monthly payment in euros
     */
    public static double calculateMonthlyPayment(double monthlyInterest, double totalLoan, int payments) {
        double interestPower = MathUtil.pow(1+monthlyInterest, payments);
        return totalLoan*(monthlyInterest*interestPower)/(interestPower-1);
    }
}
