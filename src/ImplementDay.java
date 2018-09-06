import java.util.Calendar;

import static java.lang.Math.abs;

public class ImplementDay implements Day {

    int day;
    String days;
    Calendar calendar = Calendar.getInstance();

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    @Override
     public int setDay()
    {

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        this.setDay(dayOfWeek);

        return day;
    }


    public String printDay(int date)
    {
        String days="";
        switch (date)
        {
            case 1 :
                days="Monday";
                break;
            case 2 :
                days="Tuesday";
                break;

            case 3 :
                days="Wenesday";
                break;
            case 4:
                days="Thursday";
                break;
            case 5:
                days="Friday";
                break;
            case 6:
                days="Saturday";
                break;
            case 7:
                days="Sunday";
                break;
        }

        return days;
    }

    @Override
    public int nextDay(){
       int nextday = calendar.get(Calendar.DAY_OF_WEEK)+1;


        return nextday;

    }

    @Override
    public int previousDay()
    {
        int nextday = calendar.get(Calendar.DAY_OF_WEEK)-1;

        return nextday;
    }

    @Override
    public int calculateDay(int calc)
    {
        int calcDay=setDay()+abs(calc);
        int mod=calcDay%7;
        return mod;
    }


}

