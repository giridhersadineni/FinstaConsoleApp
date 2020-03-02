package in.skillverse;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class User{

    public int userId;
    public String name;
    public String fatherName;
    public String email;
    public String phone;
    public String address;

    public User(){
    }



    public User(int id,String name){
        this.userId=id;
        this.name=name;
    }

    public String[] getDetails(){
        String arr[]=new String[2];
        arr[0]=Integer.toString(this.userId);
        arr[1]=this.name;
        return arr;
    }

    public void insert(){
        try{
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(isr);
            System.out.println("Enter the User ID");
            this.userId=Integer.parseInt(br.readLine());
            System.out.println("Enter Name of the User");
            this.name=br.readLine();
            System.out.println("Enter Father Name");
            this.fatherName=br.readLine();
            System.out.println("Enter email");
            this.email=br.readLine();
            System.out.println("Enter phone");
            this.phone=br.readLine();
            System.out.println("Enter Address");
            this.address=br.readLine();
        }
        catch(Exception ex){
            System.out.println("Error From User::insert "+ex.getMessage());
        }

        saveDetails();
    }


    public void saveDetails(){
        try{
            Writer fw=new FileWriter("users.csv",true);
            fw.write("\n"+this.userId+",");
            fw.write(this.name+",");
            fw.write(this.fatherName+",");
            fw.write(this.email+",");
            fw.write(this.phone+",");
            fw.write(this.address+"\r");
            fw.close();
        }
        catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }


    public void showAllUsers(){
        try{
            Reader r=new FileReader("users.csv");
            int ch=1;
            while(ch>0){
                ch=r.read();
                System.out.print((char)ch);
            }
            r.close();
        }
        catch(Exception ex){
            System.out.println("Error From User::showAllUsers"+ex.getMessage());
        }

    }

    public void getUser(int userId){
        String[] User=new String[6];
        boolean userFound=false;
        String line="";
        try{
            Reader r=new FileReader("users.csv");
            BufferedReader br=new BufferedReader(r);

            while((line=br.readLine())!=null){
                StringTokenizer fields=new StringTokenizer(line,",");
                int id=Integer.parseInt(fields.nextToken());
                if(id==userId){
                    System.out.println(line);
                    userFound=true;
                }

            }
            if(!userFound){
                System.out.println("User doesnot exist");
            }



        }
        catch (Exception ex){
            System.out.println("Error From User::showAllUsers"+ex.getMessage());
        }
    }

    public void updateUser()
    {
        Scanner sc = new Scanner(System.in);
        String[] Users=new String[1000];
        int i=0;
        int userId;
        boolean userFound=false;
        String line="";
        try{
            Reader r=new FileReader("users.csv");
            BufferedReader filereader=new BufferedReader(r);

//            Reads file and stores it in Strings Array

            while((line=filereader.readLine())!=null){
              Users[i]=line;
            }
//            Asking User for User Information
            System.out.println("Enter the User ID");
            userId=Integer.parseInt(sc.next());
            for (int j = 0; j <Users.length ; j++) {
                String user=Users[j];
                StringTokenizer userDetails=new StringTokenizer(user,",");
                int id=Integer.parseInt(userDetails.nextToken());
                if(id==userId){
                    try{
                        String updatedUser="";
                        InputStreamReader isr=new InputStreamReader(System.in);
                        BufferedReader br=new BufferedReader(isr);
                        System.out.println("Enter the User ID");
                        updatedUser+=br.readLine()+",";
                        System.out.println("Enter Name of the User");
                        updatedUser+=br.readLine()+",";
                        System.out.println("Enter Father Name");
                        updatedUser+=br.readLine()+",";
                        System.out.println("Enter email");
                        updatedUser+=br.readLine()+",";
                        System.out.println("Enter phone");
                        updatedUser+=br.readLine()+",";
                        System.out.println("Enter Address");
                        updatedUser+=br.readLine()+"\n";
                        Users[j]=updatedUser;
                    }
                    catch(Exception ex){
                        System.out.println("Error From User::insert "+ex.getMessage());
                    }
                }
                if(user==null)
                    break;
                System.out.println(user);
            }




        }
        catch (Exception ex){
            System.out.println("Error From User::showAllUsers"+ex.getMessage());
        }


    }

}
