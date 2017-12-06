package com.company;

import java.math.*;

public class Main {

    public static void main(String[] args) {

        BigDecimal one = new BigDecimal("1");

        for (int i = 0; i < 999; i++)   //Print the decimal numbers
        {
            String str = one.divide(new BigDecimal("" + (1 + i)), 1000, RoundingMode.HALF_EVEN).toString();
            System.out.println(str.substring(2));
        }

        int max = 0;
        int index = 0;


        for (int i = 1; i < 1000; i++)
        {
            int curr = getMultiplicativeOrder(i);
            if(curr > max)
            {
                max = curr;
                index = i;
            }
        }


        System.out.println("Max: "+max);
        System.out.println("d: "+index);

    }

    public static int getMultiplicativeOrder(int n)
    {
        for (int i = 1; i < n; i++)
        {
            BigInteger IR;
            BigInteger ten = new BigInteger("10");
            BigInteger ind = new BigInteger(i+"");
            BigInteger nn = new BigInteger(n+"");

            IR = ten.modPow(ind, nn);

            if(IR.compareTo(BigInteger.ONE) == 0)
                return i;
        }

        System.out.println(n);

        return 0;
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

//Note that the period of 1/d is equal to the multiplicative order of d.
//http://mathworld.wolfram.com/RepeatingDecimal.html