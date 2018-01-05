package com.company;

public class Main {

    public static void main(String[] args) {
	    String dec = "";

	    int i = 1;
	    while(dec.length() <= 1000000)
	    {
                dec += i;
                i++;
                System.out.println(dec.length());
        }

        System.out.println(dec);
        System.out.println(dec.charAt(0));
        System.out.println(dec.charAt(9));
        System.out.println(dec.charAt(99));
        System.out.println(dec.charAt(999));
        System.out.println(dec.charAt(9999));
        System.out.println(dec.charAt(99999));
        System.out.println(dec.charAt(999999));
    }
}

//An irrational decimal fraction is created by concatenating the positive integers:
//
//0.123456789101112131415161718192021...
//
//It can be seen that the 12th digit of the fractional part is 1.
//
//If dn represents the nth digit of the fractional part, find the value of the following expression.
//
//d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000