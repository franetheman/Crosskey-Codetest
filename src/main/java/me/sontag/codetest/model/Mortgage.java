package me.sontag.codetest.model;

import me.sontag.codetest.utils.MathUtil;

import java.text.DecimalFormat;

/**
 *  Data class representing a mortgage
 */
public class Mortgage {
    private DecimalFormat df = new DecimalFormat("#.##");

    private String name;
    private double monthlyInterest;
    private double totalLoan;
    private int payments;
    private double monthlyPayment;

    /**
     *  Default constructor
     */
    public Mortgage() {

    }

    /**
     *  Getter for monthly interest
     *  @return the monthly interest in decimal form
     */
    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    /**
     *  Setter for monthly interest.
     *  Sets it as decimal form as the input comes as a percentage value
     *  @param monthlyInterest the monthly interest as a percentage
     */
    public void setMonthlyInterest(double monthlyInterest) {
        this.monthlyInterest = monthlyInterest/100;
    }

    /**
     *  Getter for the total loan
     *  @return the total loan in euros
     */
    public double getTotalLoan() {
        return totalLoan;
    }

    /**
     *  Setter for the total loan value
     *  @param totalLoan the total loan in euros
     */
    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    /**
     *  Getter for the number of payment periods
     *  @return the number of payment periods as months
     */
    public int getPayments() {
        return payments;
    }

    /**
     *  Setter for the number of payment periods
     *  @param payments the number of years that payments will be made
     */
    public void setPayments(int payments) {
        this.payments = 12*payments;
    }

    /**
     *  Getter for the customer name
     *  @return the customer name
     */
    public String getName() {
        return name;
    }

    /**
     *  Setter for the customer name
     *  @param name the customer name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Calculates and sets the monthly payment amount as euros
     */
    public void setMonthlyPayment() {
        monthlyPayment = MathUtil.calculateMonthlyPayment(monthlyInterest, totalLoan, payments);
    }

    /**
     *  Getter for the monthly payment as euros
     *  @return the monthly payment as euros
     */
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     *  Creates a string representation of the mortgage object.
     *  The string representation matches the desired output
     *  @return a string representation of this object
     */
    @Override
    public String toString() {
        return name + " wants to borrow " + totalLoan + "€ for a period of " + ((int)payments/12) +
                " years and pay " + df.format(monthlyPayment) + "€ each month";
    }
}
