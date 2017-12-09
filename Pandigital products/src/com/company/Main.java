package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Integer> bag = new HashSet<Integer>();
        long sum = 0;

        //grab every pandigital sequence

        for (int i = 1; i < 99; i++)
        {
            for (int j = 100; j < 9999; j++)
            {
                int product = multiply(i+"",j+"");
                if(isPandigital(""+i,""+j,""+(product)))
                    bag.add(i*j);
            }
        }

        for (int n : bag)
            sum += n;
        System.out.println(sum);
    }

    static int multiply(String a, String b)
    {
        int product = Integer.parseInt(a)*Integer.parseInt(b);
        if(((product+"").length()+a.length()+b.length() == 9) && (isPandigital(a,b,product+"")))
            return product;

        return 0;
    }

    static boolean isPandigital(String a, String b, String c)
    {
        String number = a+b+c;
        for (int i = 1; i <= number.length(); i++)
        {
            if(!number.contains(i+""))
                return false;
        }
        return true;
    }
}
//We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
// for example, the 5-digit number, 15234, is 1 through 5 pandigital.
//
//The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier,
// and product is 1 through 9 pandigital.
//
//Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
//
//HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.