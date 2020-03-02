package in.skillverse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args){
        int op;
        User userController=new User();
        Account accountController=new Account();
        while(true){
            try{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Finsta App");
                System.out.println("=================================");
                System.out.println("1. Add User");
                System.out.println("2. View all Users");
                System.out.println("3. Search User");
                System.out.println("6. Update User");

                System.out.println("=================================");
                System.out.println("Enter Choice");
                op=Integer.parseInt(br.readLine());
                switch(op){
                    case 1:
                        userController.insert();
                        break;
                    case 2:
                        userController.showAllUsers();
                        break;
                    case 3:
                        int userId;
                        System.out.println("Enter the User Id");
                        userId=Integer.parseInt(br.readLine());
                        userController.getUser(userId);
                        break;
                    case 4:
                        accountController.AddAccount();
                        break;
                    case 5:
                        accountController.showAllAccounts();
                        break;
                    case 6:
                        userController.updateUser();
                        break;



                    default:
                        System.out.println("Invalid Choice Retry");
                }

            }
            catch(Exception ex){

                System.out.println("Exception FinstaApp::main "+ex.getMessage());
            }
        }
    }

}











