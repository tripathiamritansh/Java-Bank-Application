
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amritansh
 */
public class Menu {
    //Instance variable
    Scanner keyboard = new Scanner(System.in);
    Bank bank = new Bank();
    boolean exit;// By default false
    
    public static void main(String[] args){
     Menu menu=new Menu();
     menu.run();
    }
    
    public void run(){
        printHeader();
        while(!exit){
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("+----------------------------+");
        System.out.println("|                            |");
        System.out.println("|  Welcome to Java Bank App  |");
        System.out.println("|                            |");
        System.out.println("+----------------------------+");

    }

    private void printMenu() {
        System.out.println("Please Make a Selection");
        System.out.println("1)Create a New Account");
        System.out.println("2)Make a Deposit");
        System.out.println("3)Make a Widthrawal");
        System.out.println("4)List Account Balance");
        System.out.println("5)Exit");

    }

    private void performAction(int choice) {
        switch(choice){
            case 0: {
                System.out.println("Thank you for using the application");
                System.exit(0);
                break;}
            case 1:{
                createAnAccount();
                break;
            }
            case 2:{
                makeADeposit();
                break;
            }
            case 3:{
                makeAWidthrawal();
                break;
            }
            case 4:{
                listBalances();
                break;
            }
            default:
                System.out.println("Unknown Error..");
        }
    }

    private int getInput() {
        int choice =-1;
        do{
            System.out.println("Enter Your Choice");
            try{
                choice = Integer.parseInt(keyboard.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Invalid, Enter Numbers only!!");
            }
            if(choice<0 || choice>4){
                System.out.println("Choice outside range");
            }
        }while(choice<0 || choice>4);
        return choice;
    }

    private void createAnAccount() {
        String firstName, lastName, ssn, accountType="";
        double initialDeposit=0;
        boolean valid =false;
        while(!valid){
            System.out.println("Please Enter an account type!");
            accountType = keyboard.nextLine();
            if(accountType.equalsIgnoreCase("checking")|| accountType.equalsIgnoreCase("saving")){
                valid=true;
            }else{
                System.out.println("Invalid account type, please enter checking or saving");
            }
        }
        System.out.println("Please Enter your First name");
        firstName = keyboard.nextLine();
        System.out.println("Please Enter your Last name");
        lastName = keyboard.nextLine();
        System.out.println("Please Enter your SSN");
        ssn = keyboard.nextLine();
        valid=false;
        System.out.println("Please enter Initial Deposit");
        while(!valid){
            try{
               initialDeposit = Double.parseDouble(keyboard.nextLine());
            }catch(NumberFormatException e){
               System.out.println(" Deposit must be a number");
            }
            if(accountType.equalsIgnoreCase("checking")){
                if(initialDeposit<100){
                    System.out.println("Checking account require minimum of $100");

                }else{
                    valid=true;
                }
            }else if(accountType.equalsIgnoreCase("saving")){
                if(initialDeposit<100){
                    System.out.println("Saving account require minimum of $50");         
                }else{
                    valid=true;
                }
            }
        }
        Account account;
        if(accountType.equalsIgnoreCase("checking")){
            account = new Checking(initialDeposit);
        }else{
            account = new Saving(initialDeposit);
        }
        Customer customer = new Customer(firstName, lastName, account,ssn);
        bank.addCustomer(customer);
    }

    private void makeADeposit() {
        int account = selectAccount();
        if(account>=0){
            System.out.println("How much do you want to deposit");
            double amount =0;
            try{
                amount = Double.parseDouble(keyboard.nextLine());
            }catch(NumberFormatException e){
                amount=0;
            }
            bank.getCustomer(account).getAccount().deposit(amount);
        }
    }

    private void makeAWidthrawal() {
        int account = selectAccount();
        if(account>=0){
            System.out.println("How much do you want to Widthraw");
            double amount =0;
            try{
                amount = Double.parseDouble(keyboard.nextLine());
            }catch(NumberFormatException e){
                amount=0;
            }
            bank.getCustomer(account).getAccount().widthraw(amount);
        }
    }

    private void listBalances() {
        int account = selectAccount();
        if(account>=0){
            System.out.println(bank.getCustomer(account).getAccount());
        }else{
            System.out.println("Invalid selection");
            
        }
    }

    private int selectAccount() {
        ArrayList<Customer> customers = bank.getCustomers();
        if(customers.size()<=0){ 
            System.out.println("No Customer"); 
            return -1;
        }
        System.out.println("Select an Account");
        for(int i=0;i< customers.size();i++){
            System.out.println(i+1+") "+customers.get(i).basicInfo());
        }
        int account=0;
        System.out.print("Please Select an account: ");
        try{
            account = Integer.parseInt(keyboard.nextLine())-1;
            
        }catch(NumberFormatException e){
            account =-1;
        }
        if(account<0 || account>customers.size()){
            System.out.println("Invalid Account Selected");
            return -1;
        }
        return account;
    }
    
    
}
