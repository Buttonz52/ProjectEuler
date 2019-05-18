package com.company;

public class Main {

    public static void main(String[] args) {

        long sum = 0;

        for (int i = 0; i < 1000000; i++)
        {
            if(checkPalindrome(Integer.toString(i)))
            {
                String binary = Integer.toBinaryString(i);
                if(checkPalindrome(binary))
                {
                    sum += i;
                }
            }
        }

        System.out.println("Sum: "+sum);
    }

    public static boolean checkPalindrome(String n)
    {
        String number = n+"";

        for(int i = 0; i < (number.length()/2); i++)
        {
            if (number.charAt(i) != number.charAt(number.length()-(i+1)))
                return false;
        }

        return true;
    }
}

//The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
//
//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
//
//(Please note that the palindromic number, in either base, may not include leading zeros.)