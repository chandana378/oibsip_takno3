import java.util.*;
class Atm
{
    public static HashMap<Integer,ArrayList<String>>cusDet =new HashMap<Integer,ArrayList<String>>();
    public static ArrayList<ArrayList<String>>transaction =new ArrayList<ArrayList<String>>();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter your Choice :\n1.CustomerLogin\n2.Quit ");
            int m=sc.nextInt();
            switch(m)
            {
                case 1:
                    CustomerLogin();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a Valid number");
            }
        }
    }
    public static void CustomerLogin() {
        ArrayList<String> det=new ArrayList<>();
        det.add("7308");
        det.add("chandana");
        det.add("15000");
        cusDet.put(6129, det);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Credit Card Number");
        int cnum=sc.nextInt();
        System.out.println("Enter your Pin Number");
        int pin=sc.nextInt();
        String pin1=String.valueOf(pin);
        if(cusDet.containsKey(cnum))
        {
            if(pin1.equals((cusDet.get(cnum).get(0))))
            {
                System.out.println("Welcome User"+" "+(cusDet.get(cnum).get(1)));
                Transaction(cnum);
            }
            else
            {
                System.out.println("You entered wrong! Check your pin number");
            }
        }
        else
            System.out.println("Check your card Number again");
    }
    public static void Transaction(int cnum) {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter your Choice from:\n1.Transactions History \n2.WithDraw \n3.Deposit \n4.Transfer\n5.Quit ");
            int m=sc.nextInt();
            switch(m)
            {   case 1:
                    TransactionsHistory(cnum);
                    break;
                case 2:
                    WithDraw(cnum);
                    break;
                case 3:
                    Deposit(cnum);
                    break;
                case 4:
                    Transfer(cnum);
                    break;
                case 5:
                    System.out.println("Thanks for Using");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct number from the above Cases");
            }
        }
    }
    public static void TransactionsHistory(int cnum) {
        
        for(ArrayList<String> i:transaction)
        {
            if(Integer.parseInt(i.get(0))==cnum){
                for(String j:i){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
        }
    }
    public static void WithDraw(int cnum) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amount:");
        int cash=sc.nextInt();
        if(cash<=Integer.parseInt(cusDet.get(cnum).get(2))){
            System.out.println("Your Amount is proceded");
            String amt=cusDet.get(cnum).get(2);
            int amt1=Integer.parseInt(amt);
            amt1-=cash;
            amt=String.valueOf(amt1);
            ArrayList<String> details=cusDet.get(cnum);
            details.set(2, amt);
            cusDet.put(cnum,details);
            ArrayList<String> transactionDetails=new ArrayList<>();
            transactionDetails.add(String.valueOf(cnum));
            transactionDetails.add("With Draw");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("Your Balance is: "+cusDet.get(cnum).get(2));
        }
        else{
            System.out.println("Less Balance");
        }
    }
    public static void Deposit(int cnum) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amount: ");
        int cash=sc.nextInt();
        System.out.println("Your Amount is Deposited");
            String amt=cusDet.get(cnum).get(2);
            int amt1=Integer.parseInt(amt);
            amt1+=cash;
            amt=String.valueOf(amt1);
            ArrayList<String> details=cusDet.get(cnum);
            details.set(2, amt);
            cusDet.put(cnum,details);
            ArrayList<String> transactionDetails=new ArrayList<>();
            transactionDetails.add(String.valueOf(cnum));
            transactionDetails.add("Deposit");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("Your Balance is: "+cusDet.get(cnum).get(2));
    }
    public static void Transfer(int cnum) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Account Number of transfer account ");
        int acc1=sc.nextInt();
        System.out.println("Enter Amount to Transfer ");
        int cash=sc.nextInt();
        if(cash<=Integer.parseInt(cusDet.get(cnum).get(2))){
            System.out.println("Amount of "+cash+"Rs"+"Transfered to "+acc1);
            String amt=cusDet.get(cnum).get(2);
            int amt1=Integer.parseInt(amt);
            amt1-=cash;
            amt=String.valueOf(amt1);
            ArrayList<String> details=cusDet.get(cnum);
            details.set(2, amt);
            cusDet.put(cnum,details);
            ArrayList<String> transactionDetails=new ArrayList<>();
            transactionDetails.add(String.valueOf(cnum));
            transactionDetails.add("Transfer");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("The Balance Amount is: "+cusDet.get(cnum).get(2)+"Rs");
        }
        else{
            System.out.println("Sorry Less Balance.");
        }
    }
}