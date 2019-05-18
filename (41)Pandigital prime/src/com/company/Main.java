package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        for (long i = 9999999; i > 1000000 ; i--)
        {
            if(isPandigital(i+"") && new BigInteger(i+"").isProbablePrime(10))
            {
                System.out.println("ans: "+ i);
                break;
            }
            System.out.println(i);

        }
    }

    static boolean isPandigital(String a)
    {
        String number = a;
        for (int i = 1; i <= number.length(); i++)
        {
            if(!number.contains(i+""))
                return false;
        }
        return true;
    }
}
//We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
//For example, 2143 is a 4-digit pandigital and is also prime.
//
//What is the largest n-digit pandigital prime that exists?