package com.example;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class MyClass
{

    public static void main(String[] args)
    {
        // gets the supported ids from GMT-06:00 (U.S. Centeral Standard Time)
        String[] ids = TimeZone.getAvailableIDs(-6 * 60 * 60 * 1000);
        // if no ids were returned, something is wrong, exit program.
        if(ids.length == 0)
        {
            System.exit(0);
        }

        int temp = 0;
        String[] months = {"January", "February", "March", "April", "May",
        "June", "July", "August", "September", "October", "November", "December"};

        int[][] fullMoons = new int[3][2];
        fullMoons[0][0] = 9;
        fullMoons[0][1] = 27;
        fullMoons[1][0] = 10;
        fullMoons[1][1] = 25;
        fullMoons[2][0] = 11;
        fullMoons[2][1] = 25;

        // begin output
      //  System.out.println("Current Time");

        // create a Central Standard Time time zone
        SimpleTimeZone cst = new SimpleTimeZone(-6 * 60 * 60 * 1000, ids[0]);

        // set up daylight savings time rules
        cst.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
        cst.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);

        // create Gregorian Calendar with Centeral DST time zone
        // and current date and time
        Calendar calendar = new GregorianCalendar(cst);
        Date trialTime = new Date();
        calendar.setTime(trialTime);

        temp = calendar.get(Calendar.MONTH);

        if(months[fullMoons[0][0]] == months[temp])
        {
            System.out.println("Today is: " + months[temp] + " "
                    + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("The next full moon is on " + months[fullMoons[0][0]] + " " +
            fullMoons[0][1]);
            System.out.print("The next full moon is in ");
            System.out.print(fullMoons[0][1] - calendar.get(Calendar.DAY_OF_MONTH));
            System.out.print(" days.");
        }
        else if(months[fullMoons[1][0]] == months[temp])
        {
            System.out.println("Today is: " + months[temp] + " "
                    + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("The next full moon is on " + months[fullMoons[0][0]] + " " +
                    fullMoons[0][1]);
            System.out.print("The next full moon is in ");
            System.out.print(fullMoons[0][1] - calendar.get(Calendar.DAY_OF_MONTH));
            System.out.print(" days.");
        }
        else if(months[fullMoons[2][0]] == months[temp])
        {
            System.out.println("Today is: " + months[temp] + " "
                    + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("The next full moon is on " + months[fullMoons[0][0]] + " " +
                    fullMoons[0][1]);
            System.out.print("The next full moon is in ");
            System.out.print(fullMoons[0][1] - calendar.get(Calendar.DAY_OF_MONTH));
            System.out.print(" days.");
        }

//        System.out.println("ERA: " + calendar.get(Calendar.ERA));
//        System.out.println("Year: " + calendar.get(Calendar.YEAR));
//        System.out.println("Month: " + months[temp]);
//        System.out.println("Date: " + calendar.get(Calendar.DAY_OF_MONTH));

    }
}
