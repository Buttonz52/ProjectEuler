package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        BigInteger fact = new BigInteger("1");

        for(int i = 1; i <= 100; i++)
        {
            String IR = Integer.toString(i);
            fact = fact.multiply(new BigInteger(IR));
        }

        String IR = fact.toString();
        int sum = 0;

        for(int i = 0; i < IR.length(); i++)
        {
            sum += Integer.parseInt(IR.charAt(i)+"");
        }

        System.out.println(sum);

    }
}

//n! means n × (n − 1) × ... × 3 × 2 × 1
//
//For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
//and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
//
//Find the sum of the digits in the number 100!