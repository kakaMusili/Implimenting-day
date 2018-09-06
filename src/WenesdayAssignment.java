import java.lang.*;
import java.util.Scanner;

public class WenesdayAssignment {

    // Function to calculate height
    static int height(int N) {
        return (int) Math.ceil(Math.log(N + 1) / Math.log(2)) - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type  1 to Execute Question 1 ");
        System.out.println("Type  2 to Execute Question 2");
        System.out.println("Type  0 to Exit");



        int input= sc.nextInt();
        switch(input) {
            case 1:
                System.out.println("enter the size of the heap ");
                int height=sc.nextInt();
                System.out.println("The height of the heap is : " + height(height));
                break;
            case 2:
                System.out.println("enter number of ranks : ");
                int t=sc.nextInt();
                int o=0;
                while(o<t)
                {
                    System.out.println("enter the total number of employees ");
                    int n=sc.nextInt();
                    int[] arr=new int[n+1];


                    System.out.println("enter each employees rank");
                    for(int i=1;i<arr.length;i++) {

                        arr[i] = sc.nextInt();
                    }
                    arr[0]=-1;
                    int[] cal=new int[arr.length];
                    int fans=0;
                    for(int i=1;i<cal.length;i++)
                    {
                        int x=calSenor(i,arr);
                        cal[i]=x;
                    }
                    for(int i=1;i<cal.length;i++)
                    {
                        if(isPrime(cal[i]+i)&&cal[i]!=0)
                        {
                            fans++;
                        }
                    }
                    System.out.println("final output is : " +fans);
                    o++;
                }
                main(null);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input");
                main(null);


        }


    }
    public static int calSenor(int i,int arr[])
    {
        int count=0;
        while(arr[i]!=0)
        {
            i=arr[i];
            count++;
            if(count>=arr.length-1)
            {
                return 0;
            }
        }
        return count;
    }
    public static boolean isPrime(int n)
    {
        int i=2;
        if(n==0||n==1)
        {
            return false;
        }
        while(i<=Math.sqrt(n))
        {
            if(n%i==0)
            {
                return false;
            }
            i++;
        }
        return true;

    }
}