package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        for (int i = 10; i < 99; i++)
        {
            for (int j = 99; j > i; j--)
            {
                StringBuilder sbnum = new StringBuilder(i+"");
                StringBuilder sbdenum = new StringBuilder(j+"");

                double num1 = (double)i/j;

                double num2 = tryCancel(sbnum,sbdenum);

                if(num1 == num2 && ((i+"").charAt(1) != '0' && (j+"").charAt(1) != '0'))
                    System.out.println(i+"/"+j);

                //System.out.println(i+"/"+j);
            }
        }
    }

    public static double tryCancel(StringBuilder num, StringBuilder denum)
    {
        for(int k = 0; k < num.length(); k++)
        {
            for (int l = 0; l < denum.length(); l++)
            {
                if(num.charAt(k) == denum.charAt(l))
                {
                    num.deleteCharAt(k);
                    denum.deleteCharAt(l);
                    int a = Integer.parseInt(String.valueOf(num));
                    int b = Integer.parseInt(String.valueOf(denum));
                    return (double)a/b;
                }

            }

        }
        return 0.0;
    }
}

//The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
//
//We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
//
//There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
//
//If the product of these four fractions is given in its lowest common terms, find the value of the denominator.