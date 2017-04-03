/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amritansh
 */
public class Account {

    /**
     * @return the balance
     */
    private double balance; 
    private double interest=.02;
    private int accountNumber;
    private static int numberOfAccounts = 1000000;
    Account(){
        this.accountNumber=numberOfAccounts++;
    }
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest*100;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void widthraw(double amount){
        if(amount+5> balance){
            System.out.println("You Have Insufficient funds");
            return;
        }
            balance -=(amount+5);
            checkInterest(0);
            System.out.println("You have widthrawn $"+amount+" with Fee of $5");
            System.out.println("Present Balance: $"+balance);
    }
    
    public void deposit(double deposit){
        if(deposit<0){
            System.out.println("You cannot deposit negative amount");
            return;
        }
        checkInterest(deposit);
        deposit = deposit+deposit*interest;
        balance +=deposit;
        System.out.println("You have deposited $"+deposit+" with Interest rate of "+(interest*100));
        System.out.println("Present Balance: $"+balance);
        
    }
    public void checkInterest(double amount){
        if(balance+amount>10000){
            interest=0.05;
        }else{
            interest=0.02;
        }
    }
}
