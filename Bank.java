import java.util.Scanner;

public class Bank implements ATM {
    double bal;
    int pin=0000;
    MiniStatement m[]=new MiniStatement[5];
    int x=0;
    
    Scanner sc = new Scanner(System.in);
    
    public void checkBalance()
    {
        System.out.println();
        System.out.print("Enter the PIN = ");
        int checkpin = sc.nextInt();
        if(checkpin==pin)
        {
            System.out.println("Current Balance = "+bal);
        }
        else
        {
            System.out.println("Wrong PIN entered !!!");
        }
    }
    public void withdraw(int amt)
    {
        System.out.println();
        boolean check = true;
        System.out.print("Enter the PIN = ");
        int checkpin = sc.nextInt();
        if(checkpin==pin)
        {
            while(check)
            {
                try{
                    if(amt>0 && amt<=bal && amt<=40000 && amt%100==0)
                    {
                        bal=bal-amt;
                        System.out.println("Amount withdrawn successfully!!!");
                        printReceipt();
                        System.out.println("Withdrawal Balance = "+amt);
                        System.out.println("Available Balance = "+bal);
                        if(x<5)
                        {
                            m[x]=new MiniStatement(amt,"Withdraw");
                            x++;
                        }
                        else
                        {
                            for(int i=0; i<m.length-1; i++)
                            {
                                m[i]=m[i+1];
                            }
                            x--;
                            m[x]=new MiniStatement(amt,"Withdraw");
                            x++;
                        }
                        check=false;
                    }
                    else if(amt<0)
                    {
                        System.out.println("Withdrawal amount can not be 0 ...");
                        System.out.println("Try again...");
                        System.out.print("Enter the amount to withdraw = ");
                        amt = sc.nextInt();
                    }
                    else if(amt>=40000)
                    {
                        System.out.println("Withdrawal amount can not be more than 40000RS...");
                        System.out.println("Try again...");
                        System.out.print("Enter the amount to withdraw = ");
                        amt = sc.nextInt();
                    }
                    else if(amt%100!=0)
                    {
                        System.out.println("Withdrawal amount should be multiple of 100...");
                        System.out.println("Try again...");
                        System.out.print("Enter the amount to withdraw = ");
                        amt = sc.nextInt();
                    }
                    else
                    {
                        System.out.println("Insufficient Balance !!!");
                        throw new LowBalanceException();
                    }
                }
                catch(Exception e)
                {
                    e.getStackTrace();
                    check=false;
                }
            }
        }
        else
        {
            System.out.println("Wrong PIN entered !!!");
        }
    }
    public void deposit(int cash)
    {
        System.out.println();
        if(cash>0 && cash<=50000 && cash%100==0)
        {
            System.out.print("Enter the PIN = ");
            int checkpin = sc.nextInt();
            if(checkpin==pin)
            {
                bal=bal+cash;
                System.out.println("Amount deposited successfully...");
                printReceipt();
                System.out.println("Deposited Balance = "+cash);
                System.out.println("Available Balance = "+bal);
                if(x<5)
                    {
                        m[x]=new MiniStatement(cash,"Deposited");
                        x++;
                    }
                else
                {
                    for(int i=0; i<m.length-1; i++)
                    {
                        m[i]=m[i+1];
                    }
                    x--;
                    m[x]=new MiniStatement(cash,"Deposited");
                    x++;
                }
            }
            else
            {
                System.out.println("Wrong PIN entered !!!");
            }
        }
        else if(cash<0)
        {
            System.out.println("Depositing amount can be 0 ...");
        }
        else if(cash%100!=0)
        {
            System.out.println("Depositing amount should be a multiple of 100 ...");
        }
        else
        {
            System.out.println("Depositing amount can not exceed 50000Rs");
        }
    }
    public void printReceipt()
    {
        System.out.println();
        System.out.println("**********Receipt**********");
    }
    public void miniStatement()
    {
        System.out.println();
        System.out.println("**********MiniStatement**********");
        for(int i = 0; i < 5;i++)
        {
            if(i<x)
            {
                System.out.print(m[i].amt+" ");
                System.out.print(m[i].msg);
                System.out.println();
            }
        }
        System.out.println("*********************************");
    }
    public void changePin()
    {
        System.out.println();
        boolean check=true;
        System.out.print("Enter current PIN = ");
        int checkpin = sc.nextInt();
        if(checkpin==pin)
        {
            while(check)
            {
                System.out.print("Enter new PIN = ");
                int newpin = sc.nextInt();
                if(newpin==pin)
                {
                    System.out.println("New PIN can not be same as current PIN !!!");
                    System.out.println("Try again...");
                }
                else
                {
                    int count=0;
                    int np=newpin;
                    while(newpin>0)
                    {
                        newpin=newpin/10;
                        count++;
                    }
                    if(count==4)
                    {
                        pin=np;
                        System.out.println("PIN changed successfully!!!");
                        check=false;
                    }
                    else
                    {
                        System.out.println("PIN should for 4 digits !!!");
                        System.out.println("Try again...");
                    }
                }
            }
        }
        else
        {
            System.out.println("Wrong PIN entered !!!");
        }
    }
}
