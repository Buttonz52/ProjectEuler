package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> primeList = Esieve(10000);
        System.out.println("Generated Primes");
        boolean notFound = true;
        int odd = 1;

        while(notFound)
        {
            odd += 2;
            int i = 0;
            notFound = false;
            while(odd >= primeList.get(i))
            {
                if(isDoubleSquare(odd-primeList.get(i)))
                {
                    notFound = true;
                    break;
                }
                i++;
            }

        }
        System.out.println("Broken Conjecture -> " + odd);
    }

    public static boolean isDoubleSquare(int n)
    {
        double interm = Math.sqrt(n/2);
        return (interm == (int) interm);

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

//It was proposed by Christian Goldbach that every odd composite number
//can be written as the sum of a prime and twice a square.
//
//9 = 7 + 2×1^2
//15 = 7 + 2×2^2
//21 = 3 + 2×3^2
//25 = 7 + 2×3^2
//27 = 19 + 2×2^2
//33 = 31 + 2×1^2
//
//It turns out that the conjecture was false.
//
//What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?