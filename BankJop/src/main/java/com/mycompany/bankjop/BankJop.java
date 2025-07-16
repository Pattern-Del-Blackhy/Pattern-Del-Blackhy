/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankjop;
//import java.util.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Dell
 */
public class BankJop{
private double balance;
static int pass;   
static String name;
static ArrayList<String>transactions=new ArrayList<>();
      static  File word =new File("collins.txt");
    public static void main(String[] args) {
        double balance =0;
       // int choice;
        while(true){
            String menu = "1.Check balance \n"+
                    "2.deposit\n"+
                    "3.withdraw\n"+
                    "4.Print account statement\n"+
                    "5.Create an account\n"+
                    "6.Transfer\n"+
                    "7.Exist.";
             String choice= JOptionPane.showInputDialog( null,menu,"Banking System",JOptionPane.PLAIN_MESSAGE);
        switch(choice){
            case "1":
                showbalance(balance);
                break;
            case "2":
                balance +=deposit(balance);
                break;
            case "3":
                balance -=withdraw(balance);
                break;
            case "4":
                statement(balance);
                break;
            case "5":
            CreateA();
                break;
            case "6":
                transfer(balance);
                break;
                case "7":
                JOptionPane.showMessageDialog(null, "Thank you for using our service.");
                    System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null,"Invalid input");
        }
    }
    }
    static void showbalance(double balance){
        int pin4;
         pin4=Integer.parseInt(JOptionPane.showInputDialog("Please enter pin:"));
        if(Integer.toString(pin4).length()<4){
            JOptionPane.showMessageDialog(null,"Pin can't be less than 4 . Try again.");
        } 
        else if(pass==pin4&&word.exists()){
        JOptionPane.showMessageDialog(null,"Dear "+name +" your account balance is :$"+balance);
        }
        else{
          JOptionPane.showMessageDialog(null," Dear customer you do no have an account . select option 5 to create one.\n");
        }
    }
    static double deposit(double balance){
        double amount;
        int pin3;
       amount=Double.parseDouble(JOptionPane.showInputDialog("Enter amount to be deposited"));
        pin3=Integer.parseInt(JOptionPane.showInputDialog("Please enter pin:"));
        //pin3=pp.nextInt();
        if(Integer.toString(pin3).length()<4){
            JOptionPane.showMessageDialog(null,"Pin can't be less than 4 try again.");
            return 0;
        } 
        else if((pass==pin3)&&(amount>0)){
            JOptionPane.showMessageDialog(null,"Dear "+name+" ,you have successfully deposited $ "+ (amount) + " in your account.\n"+"Your Current balance is $"+(balance+amount));
            transactions.add(" you've deposited $"+amount);
            return amount;
        }
        else if((pass!=pin3)){
            JOptionPane.showMessageDialog(null,"Invalid pin .try again ");
            return 0;
        }
        else if(amount<0){
            JOptionPane.showMessageDialog(null,"Amount can't be negative. Try again");
            return 0;
        }
        else{
           JOptionPane.showMessageDialog(null,"failed. it seems you do not have an account .select option 5 to create");
            return 0;
        }
    
    }
     static double withdraw(double balance){
        double with;
        int pin2;
       with=Double.parseDouble( JOptionPane.showInputDialog("Enter amount to be withdrawn:"));
        pin2=Integer.parseInt(JOptionPane.showInputDialog("Plesae enter pin :"));
        if(Integer.toString(pin2).length()<4){
            JOptionPane.showMessageDialog(null,"Pin can't be less than 4 try again.");
            return 0;
        } 
        else if((pass==pin2)&&(balance>with)){
            JOptionPane.showMessageDialog(null,"Dear "+name+" ,you have successfully withdrew $"+with+"\nYour Current balance is $"+(balance-with));
            transactions.add("you've withdrew :$"+with);
            return with;
        }
        else if((pass==pin2)&&(with<0)){
            JOptionPane.showMessageDialog(null,"Amount can't be negative.");
            return 0;
        }
        else if(pass!=pin2){
             JOptionPane.showMessageDialog(null,"Invalid pin.please try again");
             return 0;
        }
        else if(balance<with){
            JOptionPane.showMessageDialog(null,"Insufficient fund");
            return 0;
        }
        else{
            JOptionPane.showMessageDialog(null,"failed !!!");
            return 0;
        }
    }
      static void statement(double balance){
        int pin5;
       pin5=Integer.parseInt( JOptionPane.showInputDialog("Please enter pin:"));
        if(Integer.toString(pin5).length()<4){
            JOptionPane.showMessageDialog(null,"Pin can't be less than 4 try again.");
        } 
        else if((transactions.isEmpty())&&pass==pin5){
            JOptionPane.showMessageDialog(null,"No transaction statement");
        }
        else if(pass!=pin5){
                   JOptionPane.showMessageDialog(null,"Invaild pin .please try again");
        }
        else{
            for(String transaction:transactions){
                JOptionPane.showMessageDialog(null,"Account statement\n"+transaction+"\nYour current balance is :$"+balance);
            }
        }
    }
    static void CreateA(){
        //Scanner scanner=new Scanner(pass);
        try{
            File password =new File("collins.txt");
        FileWriter word=new FileWriter(password);
        int pin;
       name=JOptionPane.showInputDialog("Please Enter your full name :");     
        pin=Integer.parseInt(JOptionPane.showInputDialog("Please Enter 4 digits number :"));
        pass=pin;
        word.write(String.valueOf(pass));
        word.close();
        if(Integer.toString(pin).length()<4){
             JOptionPane.showMessageDialog(null,"Pin can't be less than 4 try again.");
        } else{
             JOptionPane.showMessageDialog(null,"Dear " + name +" , You have successfully created an account"); 
        }
    }
        catch(IOException e){
    JOptionPane.showMessageDialog(null,"Something went wrong!!");
    }
    }
    
    static double transfer(double balance){
        int num,num1,pin6=0;
        double cash = 0;
       num=Integer.parseInt(JOptionPane.showInputDialog("Please enter receipient's number:"));
       num1=Integer.parseInt(JOptionPane.showInputDialog("Please confirm the receipient number:"));
     //Pattern number=new Pattern(0);
      
       
       if((num!=num1)&&(Integer.toString(num1).length()==10)){
        JOptionPane.showMessageDialog(null,"unmatch number.Please make the two numbers are the same.");
        return 0;
    }else if ((num==num1)&&Integer.toString(num1).length()<10){
        JOptionPane.showMessageDialog(null,"wrong number !! Make sure the number is up 10.");
    }else { 
    cash=Double.parseDouble(JOptionPane.showInputDialog("Please enter amount to be transferred:$ "));
        pin6=Integer.parseInt(JOptionPane.showInputDialog("please enter pin: "));
    }    
        if((balance> cash)&&(pass== pin6)){
            JOptionPane.showMessageDialog(null,"Dear "+name +" you have successfully transferred $ "+cash+" to\n "+num1+"Your current balance is $ "+(balance-cash));
            return cash;
        }else if ((pass==pin6)&&(balance<cash)){
            JOptionPane.showMessageDialog(null,"Insufficient fund.");
            return 0;
        }else if(cash<0){
            JOptionPane.showMessageDialog(null,"Amount can' be negative ...");
            return 0;
        }else if(pass!=pin6){
            JOptionPane.showMessageDialog(null,"wrong pin...");
            return 0;
        }else{
            JOptionPane.showMessageDialog(null,"failed !!! please try again");
            return 0;
        }      
    }
   public double getBalance(){
        return balance;
    }

}
