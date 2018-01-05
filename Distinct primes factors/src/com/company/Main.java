package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static final int NUM_CONSEC = 4;

    public static void main(String[] args) {


        List<Integer> primeList = Esieve(1000000); //generate primes

        boolean notFound = true;
        int n = 19;


        while(notFound)     //loop until we find the answer
        {
            List<List<Integer>> exponents = new ArrayList<>();
            for(int i = 0; i < NUM_CONSEC; i++)
            {
                int temp = n+i;
                List<Integer> exps = getPrimeFactors(temp, primeList);
                if(countNonZero(exps) != NUM_CONSEC)
                    break;
                else
                {
                    exponents.add(exps);
                }


                if(i == NUM_CONSEC-1 && checkAns(exponents, primeList))  //check for no repeats in exponents
                {
                    for (int j = 0; j < NUM_CONSEC; j++)
                    {
                        System.out.println(n+j);
                    }
                    notFound = false;
                }

            }
            n++;


        }

    }

    public static int countNonZero(List<Integer> list)
    {
        int sum = 0;
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) != 0)
                sum++;
        }
        return sum;
    }

    public static boolean checkAns(List<List<Integer>> exponents, List<Integer> primeList)
    {
        List<Integer> noDups = new ArrayList<>();

        for (int i = 0; i < NUM_CONSEC; i++)
        {
            for (int j = 0; j < exponents.get(i).size(); j++)
            {
                int exp = exponents.get(i).get(j);
                int factor = (int)Math.pow(primeList.get(j),exp);
                if(noDups.contains(factor))
                    return false;
                if(factor != 1 && !noDups.contains(factor))
                    noDups.add(factor);

            }
        }
        return true;
    }

    public static List<Integer> getPrimeFactors(int n, List<Integer> primeList)
    {
        List<Integer> exponents = new ArrayList<>();
        int index = 0;

        while(n != 1)    //loop until we have created the prime factorization of the number n
        {
            int exp = 0;

            while(n % primeList.get(index) == 0)     //loop until we have found all of the current prime factor
            {
                n /= primeList.get(index);
                exp++;
            }
            exponents.add(exp);
            index++;
        }
        return exponents;
    }

    public static List<Integer> Esieve(int n)
    {
        // init returning List
        List<Integer> primeList = new ArrayList<>();

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[n+1];


        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primeList.add(i);
        }
        return primeList;
    }
}

//The first two consecutive numbers to have two distinct prime factors are:
//
//14 = 2 × 7
//15 = 3 × 5
//
//The first three consecutive numbers to have three distinct prime factors are:
//
//644 = 2² × 7 × 23
//645 = 3 × 5 × 43
//646 = 2 × 17 × 19.
//
//Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?