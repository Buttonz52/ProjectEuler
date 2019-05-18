package com.company;

public class Main {

    public static void main(String[] args) {

        int i = 7;
        int triangular = 28;


        while (true)
        {
            i += 1;
            triangular += i;
            int factors = count_factors(triangular);
            if (factors > 500)
            {
                System.out.println(i+ " "+ triangular);
                break;
            }
            //System.out.println(i+ " "+ triangular);
        }


    }

    public static int count_factors(int k)
    {
        int factors = 2;    // include 1 and K
        for(int i = 2; i < Math.floor(Math.sqrt(k) + 1); i++)
        {
            if (k % i == 0)
            {
                if (i*i == k)      // don't count sqrt twice.
                    factors += 1;
                else
                    factors += 2;
            }
        }
        return factors;

    }

}
