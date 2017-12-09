package com.company;

public class Main {

    public static void main(String[] args) {

        for (int i = 10; i < 99; i++)
        {
            for (int j = 99; j > i; j--)
            {
                String numerator = i+"";
                String denominator = j+"";

                double num = i/j;

                

                System.out.println(i+"/"+j);
            }
        }
    }
}

//The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
//
//We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
//
//There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
//
//If the product of these four fractions is given in its lowest common terms, find the value of the denominator.