package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> abundants = new ArrayList<Integer>();

        for(int i = 12; i <= 28123; i++)
        {
            Set<Integer> facts = getFactors(primeFactors(i));
            facts.remove(i);            // get the proper divisors
            int[] f = toInt(facts);
            int sum = 0;
            for(int j = 0; j < facts.size(); j++)
            {
                sum += f[j];
            }
            if(sum > i)
                abundants.add(i);
        }

        System.out.println("Abundants Made");

        Set<Integer> pairs = new HashSet<Integer>();

        for (int i = 0; i < abundants.size(); i++)
        {
            for(int j = 0; j <= i; j++)
            {
                int pair = abundants.get(i) + abundants.get(j);
                if(pair <= 28123)
                    pairs.add(pair);
            }
        }

        List<Integer> neg = new ArrayList<Integer>();

        System.out.println("Pairs Made");

        int sum = 0;

        for(int i = 1; i < 28123; i++)
        {
            if(!pairs.contains(i))
                sum+=i;
        }

        System.out.println(sum);


        //filtered abundant numbers so that its pseudo factors can be used to find all other abundant numbers

//        List<Integer> filteredAbundants = new ArrayList<Integer>();
//
//        filteredAbundants.add(12);
//
//        for(int i = 0; i < abundants.size(); i++)
//        {
//            for(int j = 0; j < filteredAbundants.size(); j++)
//            {
//                int n = abundants.get(i) % 12;
//                if(abundants.get(i) % filteredAbundants.get(j) == 0)// || (abundants.get(i) > 46 && n %2 == 0))
//                    break;
//                if(j == filteredAbundants.size()-1)
//                    filteredAbundants.add(abundants.get(i));
//            }
//        }
//
//        System.out.println("Abundants Filtered");

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

    public static int[] toInt(Set<Integer> set) {
        int[] a = new int[set.size()];
        int i = 0;
        for (Integer val : set) a[i++] = val;
        return a;
    }
}



// A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
// For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//
// A number n is called deficient if the sum of its proper divisors is less than n and
// it is called abundant if this sum exceeds n.
//
// As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
// the smallest number that can be written as the sum of two abundant numbers is 24.
// By mathematical analysis, it can be shown that all integers greater than 28123 can be
// written as the sum of two abundant numbers. However, this upper limit cannot be reduced any
// further by analysis even though it is known that the greatest number that cannot be expressed
// as the sum of two abundant numbers is less than this limit.
//
// Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.