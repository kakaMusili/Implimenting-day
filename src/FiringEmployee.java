import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class FiringEmployee {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Number of TestCases");
        int testCases=sc.nextInt();

        for(int i=0;i<testCases;i++)
        {
            System.out.println("*** Test Case "+(i+1)+" ***");
            System.out.println("Enter the Number of Employees");
            int emp=sc.nextInt();

            calculateBlackList(emp);
            System.out.println();
        }




    }
    
    public static void calculateBlackList( int employee)
    {
        int blacklisted=0;


        TreeSet<Integer> list=new TreeSet<>();
        TreeSet<Integer> blacklistedMember=new TreeSet<>();

        for(int i=1;i<=employee;i++)
        {
            int value= i;
            if(value==1)
            {
                continue;
            }
            list.add(value);

            if(isPrime(value)==true)
            {
                blacklisted ++;
                blacklistedMember.add(value);
            }
        }


        System.out.println(list);
        System.out.println("Total number of blacklisted Employees are  " + blacklisted);
        System.out.println("blacklisted member(s) are  " + blacklistedMember);

    }

    public static boolean isPrime(int n)
    {
       boolean checkPrime=false;

       int sum=n+(n-1);

       for (int i=2;i<sum;i++)
       {
          if(sum%i==0)
          {
              return false;

          }else {
              checkPrime=true;
          }

       }

       return checkPrime;

    }

}
