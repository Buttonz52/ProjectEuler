package com.company;

import java.math.BigInteger;

public class Main {

    static BigInteger sum = BigInteger.ZERO;

    public static void main(String[] args) {

        permutation("0123456789");

        System.out.println(sum);
    }

    static boolean isFullyDivisible(String a)
    {
        if(Integer.parseInt(""+a.charAt(7)+a.charAt(8)+a.charAt(9)) % 17 != 0)
            return false;
        if(Integer.parseInt(""+a.charAt(6)+a.charAt(7)+a.charAt(8)) % 13 != 0)
            return false;
        if(Integer.parseInt(""+a.charAt(5)+a.charAt(6)+a.charAt(7)) % 11 != 0)
            return false;
        if(Integer.parseInt(""+a.charAt(4)+a.charAt(5)+a.charAt(6)) % 7 != 0)
            return false;
        if(Integer.parseInt(""+a.charAt(3)+a.charAt(4)+a.charAt(5)) % 5 != 0)
            return false;
        if(Integer.parseInt(""+a.charAt(2)+a.charAt(3)+a.charAt(4)) % 3 != 0)
            return false;
        if(Integer.parseInt(""+a.charAt(1)+a.charAt(2)+a.charAt(3)) % 2 != 0)
            return false;

        return true;

    }

    static boolean isPandigital(String a)
    {
        String number = a;
        for (int i = 0; i < number.length(); i++)
        {
            if(!number.contains(i+""))
                return false;
        }
        return true;
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0 && isFullyDivisible(prefix))
            sum = sum.add(new BigInteger(prefix));
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
//The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits
//0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
//
//Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
//
//d2d3d4=406 is divisible by 2
//d3d4d5=063 is divisible by 3
//d4d5d6=635 is divisible by 5
//d5d6d7=357 is divisible by 7
//d6d7d8=572 is divisible by 11
//d7d8d9=728 is divisible by 13
//d8d9d10=289 is divisible by 17
//Find the sum of all 0 to 9 pandigital numbers with this property.