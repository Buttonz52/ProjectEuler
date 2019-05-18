package com.company;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<facts> factorials = new ArrayList<>();
        factorials.add(facts.ZERO);
        factorials.add(facts.ONE);
        factorials.add(facts.TWO);
        factorials.add(facts.THREE);
        factorials.add(facts.FOUR);
        factorials.add(facts.FIVE);
        factorials.add(facts.SIX);
        factorials.add(facts.SEVEN);
        factorials.add(facts.EIGHT);
        factorials.add(facts.NINE);

        int finalsum = 0;


        for (int i = 10; i < 1000000; i++) {
            String number = "" + i;
            int sum = 0;

            for (int j = 0; j < number.length(); j++) {
                sum += factorials.get(Integer.parseInt(""+number.charAt(j))).getValue();
            }

            if (i == sum)
                finalsum += sum;

            System.out.println(i);

        }

        System.out.println(finalsum);

    }


    private enum facts {
        ZERO(1), ONE(1), TWO(2), THREE(6), FOUR(24), FIVE(120), SIX(720), SEVEN(5040), EIGHT(40320), NINE(362880);

        facts(int i) {
            value = i;
        }

        private final int value;

        public int getValue() {
            return value;

        }
    }
}


//145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//
//Find the sum of all numbers which are equal to the sum of the factorial of their digits.
//
//Note: as 1! = 1 and 2! = 2 are not sums they are not included.