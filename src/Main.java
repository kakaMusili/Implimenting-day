import java.util.Calendar;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ImplementDay d=new ImplementDay();

        Scanner sc=new Scanner(System.in);

        System.out.println("Current day :" + d.printDay(d.setDay()) );
        System.out.println("Next day :" + d.printDay(d.nextDay()) );
        System.out.println("Previous day :" + d.printDay(d.previousDay()) );

        System.out.println("enter days to add : ");
        int input=sc.nextInt();
        System.out.println("the day will be :" + d.printDay(d.calculateDay(input)) );


    }
}
