import java.util.*;
abstract class Account{
    long Accnumber;
    String name ;
    String Branch_name;
    String IFSC ;
    long phnum;
    double balance;
    
    Account(long Accnumber, String name, String Branch_name, String IFSC, long phnum, double balance ){
        this.Accnumber  = Accnumber;
        this.name = name;
        this.Branch_name =Branch_name;
        this.IFSC =IFSC;
        this.phnum = phnum;
        this.balance = balance;
    }
    abstract void deposit(double amt);
    abstract void withdraw(double amt);
}
class BANK extends Account{
    BANK(long Accnumber, String name, String Branch_name,String IFSC,long phnum,double balance){
        super(Accnumber,name,Branch_name,IFSC,phnum,balance);
    }
    @Override
    public void deposit(double amt){
        balance += amt;
        System.out.println("Deposited amt  : "+balance);
    }
    @Override
    public void withdraw(double amt){
        if(amt <= balance){
            balance -= amt;
            System.out.println("withdraw amt:" + amt);
            System.out.println("Balance :"+balance);
        }
        else{
            System.out.println("Insufficient balance*");
        }
    } 
    public void transfer(BANK receiver,double amt){
        if(amt<=balance){
            receiver.balance+=amt;
            balance-=amt;
            System.out.println("Reciever Balance: "+receiver.balance);
            System.out.println("Balance: "+balance);
            
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
  
}
class Main{
    public static void main(String args[]){
        BANK b1 =  new BANK(363935,"Ram","SBI","SBIN900316",9786556,5500.45);
        Scanner sc=new Scanner(System.in);
        boolean ans=true;
        while(ans){
        
            if(!sc.hasNextInt()){
    break;
}
        int choice=sc.nextInt();
        switch(choice){
            case 1:
               b1.deposit(1000);
                break;
            case 2:
                b1.withdraw(3000);
                break;
            case 3:
                BANK b2=new BANK(376968,"Jhon","HDFC","HDFC00976",982648,6000);
                b2.transfer(b2,2000);
                System.out.println("Account number: "+b2.Accnumber);
                System.out.println("Name: "+b2.name);
                System.out.println("Branch name: "+b2.Branch_name);
                System.out.println("IFSC code: "+b2.IFSC);
                System.out.println("Phone no: "+b2.phnum);
                System.out.println("Balance: "+b2.balance);
                break;
            case 4:
                System.out.println("Account number: "+b1.Accnumber);
                System.out.println("Name: "+b1.name);
                System.out.println("Branch name: "+b1.Branch_name);
                System.out.println("IFSC code: "+b1.IFSC);
                System.out.println("Phone no: "+b1.phnum);
                System.out.println("Balance: "+b1.balance);
                break;
            case 5:
                System.out.println("Exit");
                ans=false;
                break;
            default:
                System.out.println("Invalid choice");
                ans=false;
                break;
        }
        }
    }
}