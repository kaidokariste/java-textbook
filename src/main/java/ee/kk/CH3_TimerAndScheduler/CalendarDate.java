package ee.kk.CH3_TimerAndScheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarDate {
    public static void main(String... args){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        // Prints output Today:29-04-2020
        System.out.println("Today:"+sdf.format(currentDate));
        Date johnBirthday = new Date(77, 9, 16);
        System.out.println("John's Birthday: " + sdf.format(johnBirthday));

        //day of the month
        int day = johnBirthday.getDate();
        System.out.println("Day: " + day);
        int month = johnBirthday.getMonth() + 1;
        System.out.println("Month: " + month);
        int year = johnBirthday.getYear();
        System.out.println("Year: " + year);
    }

}
