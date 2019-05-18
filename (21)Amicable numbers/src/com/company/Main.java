package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {

	    int[] numbers = new int[10000];
        int sum = 0;

	    for(int i = 2; i < numbers.length; i++)
        {
            numbers[i] = d(i);
        }

        for(int i = 2; i < numbers.length; i++)
        {
            int ans = d(numbers[i]);
            if (i == ans && numbers[i] != ans)
            {
                sum += numbers[i];
                System.out.println(numbers[i]+"/"+ans);
            }

        }

        System.out.println(sum);
    }

    public static int d(int n)
    {
        List<Integer> pfactors = primeFactors(n);
        Set<Integer> factors = getFactors(pfactors);
        List<Integer> Lfactors = new ArrayList<Integer>(factors);
        Collections.sort(Lfactors);

        int sum = 0;
        for(int i = 0; i < Lfactors.size()-1; i++)
        {
            sum += Lfactors.get(i);
        }

        return sum;
    }

    public static Set<Integer> getFactors(List<Integer> pfactors)
    {
        int Imask = 0;
        int bitLength = pfactors.size();
        int max = (int)Math.pow(2,bitLength); //<-make sure this is right for other numbers not just 120
        Set<Integer> factors = new HashSet<Integer>();

        while(Imask < max)
        {
            String m = Integer.toBinaryString(Imask);
            String mask = m;

            for(int i = 0; i < bitLength - m.length(); i++)
            {
                mask = "0"+mask;
            }

            int n = 1;
            for(int i = 0; i < bitLength; i++)
            {
                int exp = Integer.parseInt(""+mask.charAt(i));
                n *= Math.pow(pfactors.get(i),exp);
            }
            factors.add(n);
            Imask++;
        }
        return factors;
    }

    public static List<Integer> primeFactors(int n)
    {
        List<Integer> pFs = new ArrayList<Integer>();

        if(n == 0)
            return pFs;

        // Print the number of 2s that divide n
        while (n%2==0)
        {
            pFs.add(2);
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                pFs.add(i);
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            pFs.add(n);

        return pFs;
    }

    public static <T> T[] convert(List<Integer> al, Class clazz) {
        return (T[]) al.toArray((T[]) Array.newInstance(clazz, al.size()));
    }
}

//Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
//If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
//
//For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
//The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
//
//Evaluate the sum of all the amicable numbers under 10000.