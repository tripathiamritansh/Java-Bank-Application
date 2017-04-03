/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amritansh
 */
public class Saving extends Account {
    
    private static String accountType="Saving";
    Saving(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        this.checkInterest(0);
    }
    
    @Override
    public String toString(){
        return "Account Type: "+accountType+" Account\n"+
                "Account Number: "+this.getAccountNumber()+"\n"+
                "Balance: "+this.getBalance()+"\n"+
                "Interest Rate: "+this.getInterest()+"\n";
                        
    }
}
