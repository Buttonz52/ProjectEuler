package com.company;

public class Main {

    public static void main(String[] args) {

        int year = 1901;
        int day = -30;        // day % 7 = 0 if mon, 1 if tue, 2 if wed, 3 if thu, 4 if fri, 5 if sat, 6 if sun
        int count = 0;
        int[] months = new int[12];
        months[0] = 31; months[1] = 28;months[2] = 31;months[3] = 30;months[4] = 31;months[5] = 30;
        months[6] = 31;months[7] = 31;months[8] = 30;months[9] = 31;months[10] = 30;months[11] = 31;

        while(year <= 2000)
        {
            for(int i = 0; i < months.length; i++)
            {
                if(i == 1 && (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0))  //leap year
                    day++;

                day += months[i];

                if (day % 7 == 0)
                    count++;
            }
            year++;
        }
        System.out.println(count);
    }
}

//    You are given the following information, but you may prefer to do some research for yourself.
//
//        1 Jan 1900 was a Monday.
//        Thirty days has September,
//        April, June and November.
//        All the rest have thirty-one,
//        Saving February alone,
//        Which has twenty-eight, rain or shine.
//        And on leap years, twenty-nine.
//        A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
//        How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
//        January 1, 1901 (Tuesday)