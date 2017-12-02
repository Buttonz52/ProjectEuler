package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.*;

public class Main {

    final static int MAX_DECIMAL_LENGTH = 100;

    public static void main(String[] args) {



        String[] decimalArray = new String[999];

        BigDecimal one = new BigDecimal("1");

        for (int i = 0; i < 999; i++)
        {
            String str = one.divide(new BigDecimal("" + (1+i)), 100, RoundingMode.HALF_EVEN).toString();
            decimalArray[i] = str.substring(2);
            //System.out.println(str.substring(2));
        }

        int max = 0;
        int index = 0;

        for(int i = 0; i < decimalArray.length; i++)
        {
            int curr = longestCycle(decimalArray[i],0,0);
            if (curr > max)
            {
                max = curr;
                index = i;
            }

        }

        System.out.println("Max cycle is " + max);
        System.out.println("1/"+(index+1));


    }

    //so broken
    public static int longestCycle(String s,int r, int c) //leading index  //cycle length
    {
        int l = r;                      //following index

        do
        {
            r++;
            c++;
        }
        while(s.charAt(l) != s.charAt(r) && c < MAX_DECIMAL_LENGTH/2);

        if(c >= 50)
        {
            c = 1;
            r = l+1;
        }

        for (int i = 0; i < r-l; i++)
        {
            if(s.charAt(i+l) != s.charAt(i+c+l))
                return longestCycle(s,r,0);
        }

        return c;
    }
}

//A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
//
//1/2	= 	0.5
//1/3	= 	0.(3)
//1/4	= 	0.25
//1/5	= 	0.2
//1/6	= 	0.1(6)
//1/7	= 	0.(142857)
//1/8	= 	0.125
//1/9	= 	0.(1)
//1/10	= 	0.1
//Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
//
//Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.