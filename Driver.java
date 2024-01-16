import java.util.Scanner;
public class Driver {
    static{
        System.out.println();
        System.out.println("*****-----BLACK MONEY BANK-----*****");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        Bank b = new Bank();
        while(check)
        {
            System.out.println();
            System.out.println("*****-----WELCOME TO ATM-----*****");
            System.out.println("PRESS-1. Check Balance  ");
            System.out.println("PRESS-2. Withdraw ");
            System.out.println("PRESS-3. Deposit ");
            System.out.println("PRESS-4. Change PIN ");
            System.out.println("PRESS-5. Mini Satement ");
            System.out.println("PRESS-6. Exit ");
            System.out.print("Enter you choice = ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                        b.checkBalance();
                        break;
                case 2:
                        System.out.print("Enter the amount to withdraw = ");
                        int amt = sc.nextInt();
                        b.withdraw(amt);
                        break;
                case 3:
                        System.out.print("Enter the amount to deposit = ");
                        int cash = sc.nextInt();
                        b.deposit(cash);
                        break;
                case 4:
                        b.changePin();
                        break;
                case 5: b.miniStatement();
                        break;
                case 6:
                        check=false;
                        break;
                default:
                        System.out.println("Wrong choice!!!");
                        break;
            }
        }
    }
}
