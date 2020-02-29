package in.skillverse;
import java.io.*;
import java.util.Scanner;
public class Account
{

    public int userId;
    public int accountNumber;
    public String accountName;
    public int category;
    public int balance;

    public void AddAccount()
    {
        try{
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(isr);
            System.out.println("Enter the User id:");
            this.userId=Integer.parseInt(br.readLine());
            System.out.println("Enter the Account Number:");
            this.accountNumber=Integer.parseInt(br.readLine());
            System.out.println("Enter the Account Name:");
            this.accountName=br.readLine();
            System.out.println("Enter the category:");
            this.category=Integer.parseInt(br.readLine());
            System.out.println("Enter the balance:");
            this.balance=Integer.parseInt(br.readLine());
        }
        catch(Exception e){
            System.out.println("Error from User::AddAccount"+e.getMessage());
        }
        Save();
    }
    public void Save(){
        try
        {
            Writer fw=new FileWriter("accountdetails.csv",true);
            fw.write("\n"+this.userId+",");
            fw.write(this.accountNumber+",");
            fw.write(this.accountName+",");
            fw.write(this.category+",");
            fw.write(this.balance+"\r");
        }
        catch(Exception e){
            System.out.println("Error from User::AddAccount"+e.getMessage());
        }
    }

    public void showAllAccounts(){
        try
        {
            Reader r=new FileReader("accountdetails.csv");
            int ch=1;
            while(ch>0)
            {
                ch=r.read();
                System.out.print((char)ch);
            }
            r.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error From User::showAllAccounts"+ex.getMessage());
        }

    }
}
