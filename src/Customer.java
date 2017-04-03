/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amritansh
 */
public class Customer {
    private final String firstName;
    private final String lastName;
    private final String ssn;
    private final Account account;
   

    Customer(String firstName, String lastName, Account account, String ssn) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.ssn=ssn;
        this.account=account;    
    }
    Account getAccount(){
        return account;
    }
    
    
    @Override
    public String toString(){
        return "Customer Information\n"+
                "First Name: "+firstName+"\n"+
                "Last Name: "+lastName+"\n"+
                "SSN: "+ssn+"\n"+
                account;
    }
    
    public String basicInfo(){
        return 
                "First Name: "+firstName+
                "Last Name: "+lastName+
                "SSN: "+ssn+
                "Account Number: "+account.getAccountNumber();
    }
}
