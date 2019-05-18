package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> primeList = Esieve(10000);        //collect all 4-digit prime numbers

        for (int i = 1; i < primeList.size(); i++)
        {
            for (int j = i; j < primeList.size(); j++)
            {
                int diff = primeList.get(j) - primeList.get(i);
                int k = primeList.get(j)+diff;
                if(isPermutation(primeList.get(i),primeList.get(j),k) && primeList.contains(k) && k != i && k != j && i != j)
                {
                    System.out.println("1: "+primeList.get(i));
                    System.out.println("2: "+primeList.get(j));
                    System.out.println("3: "+(primeList.get(j)+diff));
                }
            }

        }

        System.out.println("Generated Primes");

    }

    public static boolean isPermutation(int i, int j, int k)
    {
        List<Character> numbers = new ArrayList<>();
        for (int l = 0; l < 4; l++)
        {
            numbers.add((i+"").charAt(l));
        }

        for (int l = 0; l < 4; l++)
        {
            if(!numbers.contains((j+"").charAt(l)) || !numbers.contains((k+"").charAt(l)))      //also need to remove that char when it is found
                return false;
        }

        return true;


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
            if (isPrime[i] && (i+"").length() == 4) primeList.add(i);
        }
        return primeList;
    }

}

//The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330,
// is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the
// 4-digit numbers are permutations of one another.
//
//There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
// exhibiting this property, but there is one other 4-digit increasing sequence.
//
//What 12-digit number do you form by concatenating the three terms in this sequence?